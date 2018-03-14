# Knowledge discovery search-engine

# Brief introduction 

Front framework: Vue, mvvm 

UI framework: Element-UI

Back end framework: Springboot y mybatis

Database: Maradb

# how front end server communicate with back end 

In traditional java project, we have shared session between JSP page y java servlet. So you can always see the bind data format like {} or {} in jsp page or thymeleaf page or something else.

For flexible characteristic, I introduce vue for manage front data. Entonces there is no anything like "${}" in page. And all the page are in static format for faster load speed, which is very important.  

So the front end server will post request to back end server by Axios.js with "Authorization" field in header and several parameters in body for fetch data. There is a filter in springboot will check it's "Authorization" field and return RESTFUL json data to front if the token is valid. Token module is powered by jjwt.jar.

Of course there will be problem in communication between front and back, but I handle it with CrossDomain annotation.

# install dependencies 

install dependencies
in Root dir, install jar dependencies by maven

``` $ mvn install ```

**Please modify your maven repository to aliyun maven repo, which helps you to build successful and speed up processing.**

Entonces, cd to the frontend dir and install js dependencies by npm.

npm can be replace with cnpm and install cnpm with ``` $ npm install cnpm -g ```

Cnpm is strongly recommended for the terrible network in china.

``` $ cd frontend```

``` $ npm install``` or ``` cnpm install ```

## import database

login into mysql or mariadb server

and execute

```sql
$ create database usping;
$ use usping;
$ source rh.sql;
```

rh.sql is in this repository's root directory.

Make sure the path of rh.sql, check with $(pwd) or you should execute with

```
$ source <ABSOLUTE_PATH_OF_SQLFILE>/rh.sql;
```

# Run backend server

in Root dir, just simple run the main method of src/main/java/com/usping/kdsn/KDSNBootApplication.

The java backend will start with the log streaming.

# Run front server

``` $ cd frontend```

``` $ npm run dev``` or ``` cnpm run dev ```

# Dockerize

The dev environment of elasticsearch well integrated final.
Use 
``` docker-compose up ```
to start .

Which requires linux os or win10 professional/win server 2012

# Progress

-   user module 
-   knowledge module
-   shopping module
-   service module
-   myusping
-   usping manage 

