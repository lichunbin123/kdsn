import client from '../search/client'

export default {
  existsMenu: function (user) {
    return client.client.search({
      index: 'menu',
      q: 'menu_user:' + user
    }).then(function (data) {
      return data
    })
  },
  uploadMenu: function (menuData) {
    client.client.bulk({
      body: [
        // action description
        { index: { _index: 'myindex', _type: 'mytype', _id: 1 } },
        // the document to index
        {
          user_id: 5,
          // user_id: this.$cookie.get('authorizedUser').get('id'),
          user_menu: menuData
        }
      ]
    })
  },
  getMenu: function (user) {
    var tmpThis = this
    return this.existsMenu(user).then((res) => {
      // 不存在目录,则先返回, 并创建目录
      if (res.hits.total !== 0) {
        console.log('i------------------------------is not 0')
      } else {
        return tmpThis.generateMenu().then((res) => {
          console.log('+++++++++++++++++++++++++++++')
          return res
        })
      }
    })
  },
  generateMenu: function () {
    var tmpThis = this
    return client.client.search({
      index: 'news',
      size: 0,
      body: {
        aggs: {
          all_interests: {
            terms: {field: 'news_type'},
            'aggs': {
              avg_age: {
                terms: {field: 'source_site'}
              }
            }
          }
        }
      }
    }).then(function (data) {
      var menuData = tmpThis.parseMenuJson(data)
      console.log('--------------------menuDatais')
      console.log(menuData)
      tmpThis.uploadMenu(menuData)
      return menuData
    })
  },
  parseMenuJson: function (data) {
    var resultMap = []
    data.aggregations.all_interests.buckets.forEach(function (value) {
      let childArray = []
      value.avg_age.buckets.forEach(function (keyValue) {
        childArray.push({
          label: keyValue.key
        })
      })
      let myMap = {
        'label': value.key,
        'children': childArray
      }
      resultMap.push(myMap)
    })
    return resultMap
  }
}
