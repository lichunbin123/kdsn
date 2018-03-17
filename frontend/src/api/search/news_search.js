import client from './client'

export default {
  esSearchNewsWithSource (from, size, searchText) {
    return client.client.search({
      index: 'news',
      from: from || 0,
      size: size || 10,
      body: {
        query: {
          bool: {
            filter: [
              {
                match: {
                  source_site: '光粒网'
                }
              }
            ],
            should: [
              {
                match: {
                  news_title: searchText
                }
              },
              {
                match: {
                  news_content: searchText
                }
              }
            ],
            minimum_should_match: 1
          }
        }
      }
    })
  },
  esSearchNews (from, size, searchText) {
    return client.client.search({
      index: 'news',
      from: from || 0,
      size: size || 10,
      body: {
        query: {
          bool: {
            should: [
              {
                match: {
                  news_title: searchText
                }
              },
              {
                match: {
                  news_content: searchText
                }
              }
            ],
            minimum_should_match: 1
          }
        }
      }
    })
  },
  randomSearch (from, size) {
    console.log('已经运行')
    return client.client.search({
      index: 'news',
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
  }
}
