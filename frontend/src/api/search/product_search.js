import client from './client'

export default {
  randomSearch (from, size) {
    console.log('已经运行')
    return client.client.search({
      index: 'product',
      from: from || 0,
      size: size || 10,
      body: {
        query: {
          function_score: {
            query: {
              match_all: {}
            },
            functions: [
              {
                random_score: {}
              }
            ]
          }
        }
      }
    })
  },
  esSearchProduct (from, size, searchText) {
    return client.client.search({
      index: 'product',
      from: from || 0,
      size: size || 10,
      body: {
        query: {
          bool: {
            should: [
              {
                match: {
                  product_text: searchText
                }
              },
              {
                match: {
                  product_company: searchText
                }
              }
            ],
            minimum_should_match: 1
          }
        }
      }
    })
  }
}
