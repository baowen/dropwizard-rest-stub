# dropwizard-rest-stub
A sample dropwizard test stub


**Build instructions**

1)  compile and build the app using command
mvn package

2) run the dropwizard app
java -jar target/dropwizard-rest-stub-1.0-SNAPSHOT.jar server config.yml

**Dockerize app**

1) build the docker image
docker build -t dropwizard-rest-stub .


2) Run the docker container
docker run -it -p 9000:9000 -p 9001:9001 -e ENV_VARIABLE_VERSION=1.1.1 dropwizard-rest-stub


**Using the app**

The sample app will have the following endpoints
```
GET     /person/all (...)
GET     /person/get/{id} (...)
GET     /person/remove (...)
POST    /person/save (...)
```

 List with all persons can be found on this URL: http://localhost:9000/person/all. You can get person by id: http://localhost:9000/person/get/1.

Health checks are found in admin panel: http://localhost:9001. Try removing all persons by invoking several times this URL: http://localhost:9000/person/remove
