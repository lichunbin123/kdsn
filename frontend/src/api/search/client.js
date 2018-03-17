var elasticsearch = require('elasticsearch')
var client = new elasticsearch.Client({
  host: 'localhost:9200/usping',
  log: 'trace'
})

export default{
  client
}
