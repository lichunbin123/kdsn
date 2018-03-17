export default {
  parseEs: function (data) {
    var returnData = []
    data.forEach(function (value) {
      // console.log(typeof value._source)
      value._source['id'] = value._id
      console.log('-----------------------------------------------------------------------' + value._source['id'])
      returnData.push(value._source)
    })
    return returnData
  },
  convertMenu: function (data, userId) {
    var returnData = []
    console.log(userId)
    data.forEach(function (value) {
      returnData.push({
        'siteType': value.type,
        'siteName': value.label,
        'userId': userId
      })
    })
    return returnData
  }
}
