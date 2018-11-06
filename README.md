# Knowledge discovery search-engine

# Introduction 

Frontend framework: Vue 

UI framework: Element-UI

Backend framework: Springboot & mybatis & Elasticsearch

Database: mysql/mariaDb, version is no mot greater than 5.7 if mysql if preferred

# how 

- via fixed protocol and response 

- via webSocket

# install dependencies 

in root directory

``` $ mvn install ```

in root/frontend directory run the npm 

``` $ cd frontend```

``` $ npm install``` or ``` cnpm install ```

cnpm could install via ``` npm install cnpm -g```

## import database

login into mysql or mariaDb shell 

and execute

```sql
$ create database usping;
$ use usping;
$ source usping.sql;
```

Make sure the path of usping.sql, check with $(pwd) or you should execute with

```
$ source <ABSOLUTE_PATH_OF_SQLFILE>/usping.sql;
```

# Run backend server

run the main methods under src

# Run front server

``` $ cd frontend```

``` $ npm run dev``` 

# Work with docker

The dev environment of elasticsearch well integrated final.
Use 
``` docker-compose up ```
to start .

