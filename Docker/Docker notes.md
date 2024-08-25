What is Docker?

Docker helps developers build, share, run, and verify applications anywhere — without tedious environment configuration or management.


Docker is a platform and tool that allows developers to develop, deploy, and run applications in containers. Containers are lightweight, standalone, and executable packages that contain everything needed to run a piece of software, including the code, runtime, system tools, system libraries, and settings. Docker provides a way to package up an application and its dependencies into a standardized unit for software development.

- Docker uses containerization technology to create and manage containers.
- With Docker, developers can easily package their applications and all of their dependencies into a single container image that can be run on any Docker-compatible system. 
- This makes it easier to deploy applications across different environments, such as development, testing, and production, without having to worry about differences in the underlying infrastructure.


Why do we need docker?
What are are the features of docker?

docker run <image>:<version>
-----------------------------

When the first time we download all the layers will get downloaded but from now onwards if we want to download different version only a few layers will get downloaded.



docker ps
----------
- PS Stands for Process Status.
- used to list the running containers.


docker run -d redis
docker start <Container Id>

docker run -d -p6001:6379
--name redis-older redis:4.0











----------------------
----------------------


CHALLANGE 5:
How Service Discover and Register other micro services?

Service Discovery and Registration in Microservices.


1. SERVICE DISCOVERY
2. SERVICE REGISTRATION
3. LOAD BALANCING

UPSTREAM SERVICE: DEPENTABLE ON DOWN STREAM
DOWN STREAM SERVICE: 

BACKING SERVICE: DOWNSREAM SERVICE IS THE BACKING SERVICE OF UP STREAM SERVICE.




TRADITIONAL APPS:
- HOSTNAME
- IP ADDRESS
- DNS
- LIMITED HORIZONTAL SCALABILITY AND LICENSES COSTS
- SINGLE POINT OF FAILURE AND CENTRALIZED CHECKPOINTS
- MANUALLY MANAGED TO UPDATE ANY IPS AND CONGIS
- COMPLEX IN NATURE AND NOT CONTAINERS FRIENDLY





SOA APPLICATIONS????????
DNS???
ROUTING TABLE IN DNS???


MODREN APPS
- SERVICE DISCOVERY/ LOAD BALANCING

WHY SERVICE DISCOVERY
- 

CLOUD NATIVE APPLICATION??????????

SERVICE DISCOVER PATTERN??


**** CLIEN-SIDE SERVICE DISCOVERY****
**** SERVICE-SIDE SERVICE DISCOVERY****





**** CLIEN-SIDE SERVICE DISCOVERY****

- A CENTRAL SERVIER THAT MAINTAIN A GLOBAL VIEW OF ADDRESSES(IP + PORT NUMBER)


- MSS THAT CONNNECT TO CENTRAL SERVER TO REGISTER THEIR ADDR WHEN THEY STARTED AND READY.

- MSS NEED TO SEND THEIR HEARTBEATS AT REGULAR INTERVALS TO CENTRAL SERVER ABOUT THEIR HEALTH.

- MSS THAT CONNECT TO THE CENTRAL SERVER TO DEREGISTER THEIR ADDR WHEN THEY ARE ABOUT TO SHUTDOWN.



**** CLIEN-SIDE SERVICE DISCOVERY AND LOAD BALANCING****
- IF MULTIPLE INSTANCES OF THE SERVICE ARE AVAILABLE, THE REGISTRY RETURNS A LIST OF IP ADDRESSES. THE CLIENT APP THEN SELECTS ONE BASED ON ITS OWN DEFINED LOAD-BALANCING STRATEGY.

- THE RESPONSIBILITY OF THE LOAD-BALANCING AND SERVICE(IP+PORT) INSTANCE CHOOSING IS ON CLIENT.




---

SERVICE DISCOVERY LAYER??
GOSSIP PROTOCAL USED TO SHARE DATA TO CLIENTS.

-----------


SPING CLOUD NETFLIX EUREKA
SPING CLOULD LOAD BALANCER
NETFLIX FEIGH CLIENT


ALTERNATIVE TO LOAD BALANCERS
- CONSUL
- APACHE ZOOKEEPER



NETFLIX RIBBON: CLIENT SIDE LOAD BALANCING



HEALTH CHECK PROPERTIES
--- READINESS
--- LIVENESS


HOW TO SHUTDOWN A SERVICE GRACEFULLY AND WHY?



EUREKA SELF-PRESERVATION MODE TO AVOID NETWORK TRAP ISSUES.

































