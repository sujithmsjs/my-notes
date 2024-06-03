Docker
------

Container:
 A way to package application with all the necessary dependenies and configuration.
 
 Protable artifact: Easy to shared and moved around.
 
 Makes development adnd deployement more efficient.

 Layers of images

 Mostly Linux Based Image, because small in size.

 Application image on top 

What is the advantage of the layers
- Already existing layers won't downloaded again.
- Only different layers are downloaded.


App Development after Docker:
 - Own isolated env.
 - Packaged with all the needed configuration.
 - One command to install the app.
 - Run same app with 2 different verions.

Image v/s Container
-------------------
Image is like a class in Jave.
Container is like a instance of the class.

Image is the actual package. Container actually start the applicaiton.

Image is artiface and can be moved around.
Container environment is created.

Image is not running where as Container is running.

Container Port v/s Host Port
----------------------------
 - Multiple containers can run on your host machine.
 - Your laptop has only certain ports available.
 
 - Conflict when same port on host machine.
 


Workflow with Docker
--------------------
 - Development
 - Continous Integration/Delivary
 - Deployment
 
 
 
COMMANDS:
----------
docker pc
docker pc -a

docker run postgress:9.6
docker run redis
docker run -d redis


docker pull
docker run: Starts new container
docker start
docker stop

docker stop <c-id>
docker start <c-id>

docker ps
docker logs <c-name>
docker exec -it
INTERACTIVE TERMINAL

docker network ls 


MongoDB
-------
https://marioyepes.com/blog/mongodb-express-using-docker/

docker run -d `
-p 9000:27017 `
-e MONGO_INITDB_ROOT_USERNAME=rootuser `
-e MONGO_INITDB_ROOT_PASSWORD=rootpass `
--name mongodb `
-v mongodb-data:/data/db `
--net mongo-express-network `
mongo

MongoDB Express
---------------
docker run -d `
-p 8081:8081 `
-e ME_CONFIG_MONGODB_ADMINUSERNAME=rootuser `
-e ME_CONFIG_MONGODB_ADMINPASSWORD=rootpass `
-e ME_CONFIG_MONGODB_SERVER=mongodb `
-e ME_CONFIG_BASICAUTH=false `
--name mongo-express `
--net mongo-express-network `
mongo-express

------------------------------

# mongo-express.yml
version: "3" (Docker Compose Version)

services:

  mongodb: (Service Name)
    image: mongo (Docker image to be used)
    container_name: mongodb (name of the container)
    ports: (Maps port)
      - 27017:27017 
    environment:
      - MONGO_INITDB_ROOT_USERNAME=rootuser
      - MONGO_INITDB_ROOT_PASSWORD=rootpass
    volumes: (to persist MongoDB data)
      - mongodb-data

  mongo-express: (Service Name)
    image: mongo-express (Docker image to be used)
    container_name: mongo-express
    ports:
      - 8081:8081
    environment:
      - ME_CONFIG_MONGODB_ADMINUSERNAME=rootuser
      - ME_CONFIG_MONGODB_ADMINPASSWORD=rootpass
      - ME_CONFIG_MONGODB_SERVER=mongodb

networks:
  default:
    name: mongo-express-network

volumes:
  mongodb-data:
    driver: local


-------------------------------------------------------------------

docker run redis

# start a redis instance
docker run --name dr-redis -d redis

# start with persistent storage
docker run --name some-redis -d redis redis-server --save 60 1 --loglevel warning





















----------------------------------------------


docker exec -it kafka1 sh -c "cd /usr/bin && sh"


## Write To Topic



## Create Topics

kafka-topics --create --topic mytoopic --bootstrap-server localhost:9092


kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 10 --topic test

## Read Topics

kafka-topics --list --bootstrap-server localhost:9092

## Edit Topics

kafka-topics --bootstrap-server localhost:9092 --alter --topic mytoopic --partitions 6



In kafka 3.1.0(Scala 2.13)
 
 
Start zookeeper
zookeeper-server-start ..\..\config\zookeeper.properties
zookeeper-server-start C:\kafka_2.13-3.1.0\config\zookeeper.properties
 
 
Start Kafka
kafka-server-start.bat ..\..\config\server.properties
kafka-server-start.bat C:\kafka_2.13-3.1.0\config\server.properties
 
 
Create topics
kafka-topics --create --topic mytoopic --bootstrap-server localhost:9092
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 10 --topic test
 
Alter topic
kafka-topics --bootstrap-server localhost:9092 --alter --topic mytoopic --partitions 6
kafka-topics --bootstrap-server localhost:9092 --alter --topic foo --partitions 11 --replication-factor 2
 
Delete topic
kafka-topics --bootstrap-server localhost:9092 --delete --topic my-topic-name
 
list of topics
kafka-topics --list --bootstrap-server localhost:9092
 
kafka producer
kafka-console-producer -topic mytoopic -bootstrap-server localhost:9092
 
kafka consumer
kafka-console-consumer --topic mytoopic -bootstrap-server localhost:9092
kafka-console-consumer --topic mytoopic -bootstrap-server localhost:9092 -from-beginning
 
Stop Kafka
kafka-server-stop.bat
 
Stop zookeeper
zookeeper-server-stop.bat
 
consumer groups
kafka-consumer-groups --bootstrap-server localhost:9092 --all-groups --describe
 
 
Describe Kafka Topic
------------------------------
$ bin/kafka-topics --describe --bootstrap-server localhost:9092 --topic mytoopic
 
 
ssh -i "kafka-dev.pem.pem" centos@ec2-15-206-74-96.ap-south-1.compute.amazonaws.com












