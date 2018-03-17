import client from './client'

export default {
  randomSearch (from, size) {
    console.log('已经运行')
    return client.client.search({
      index: 'task',
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
  esSearchTask (from, size, searchText) {
    return client.client.search({
      index: 'service',
      from: from || 0,
      size: size || 10,
      body: {
        query: {
          bool: {
            should: {
              match: {
                service_title: searchText
              }
            },
            minimum_should_match: 1
          }
        }
      }
    })
  },
  esSearchTaskWithSource (from, size, searchText) {
    return client.client.search({
      index: 'task',
      from: from || 0,
      size: size || 10,
      body: {
        query: {
          bool: {
            should: [
              {
                match: {
                  task_title: searchText
                }
              },
              {
                match: {
                  task_content: searchText
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
