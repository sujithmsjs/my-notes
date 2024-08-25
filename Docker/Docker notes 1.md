mvn compile jib:dockerBuild
docker image push docker.io/sujithms/employee-service:v8

services:
	config-server:
		image: "sujithms/config-servier:v3"
		container_name: configserver-ms
		ports:
			- "8071:8071"
		depends_on:
			rabbit:
				condition: service_healthy
		healthcheck:
			test: "curl --fail --silent localhost:8071/actuator/health/readiness | grep UP || exit 1"
			interval: 10s
			timeout: 5s
			retries: 10
			start_period:10s
		extends:
			file: common-config.yml
			service: microservice-base-config
		
	
	eureka-server:
		image: "sujithms/eureka-server:v4"
		container_name: eureka-server
		ports:
			- "8070:8070"
		healthcheck:
			test: "curl --fail --silent localhost:8070/actuator/health/readiness | grep UP || exit 1"
			interval: 10s
			timeout: 5s
			retries: 10
			start_period:10s
		networks:
			- sujithnet
		deploy:
			resources:
				limits:
					memory:700m
		environment:
			SPRING_RABBITMQ_HOST:"rabbit"
			SPRING_APPLICATION_NAME:"eureka-server"
			
			
		extends:
			file: common-config.yml
			service: microservice-base-config
		
		
		
		
		depends_on:
			configserver:
				condition: service_healthy
			eureka-server:
				condition: service_healthy
				
		
		environment:
			EUREKA_CLIENT_SERVICEURL_DEFAULTZONE:http://eurekaserver:8070/eureka/


GOTO DOCER-COMPOSE ROOT FOLDER:
$ docker compose -up -d
$ docker compose down
$ docker compose start
$ docker compose stop

- RESTART
- PAUSE
- UNPAUSE
- PS
- LOGS
- EXEC
- BUILD
- 

docker-compose up: Create and start containers defined in the docker-compose.yml file. If no services are specified, all services are started.

docker-compose down: Stop and remove containers created by docker-compose up. By default, it stops the containers and removes containers, networks, and volumes.

docker-compose start: Start containers that are defined in the docker-compose.yml file.

docker-compose stop: Stop containers defined in the docker-compose.yml file without removing them.

docker-compose restart: Restart containers defined in the docker-compose.yml file.

docker-compose pause: Pause services by suspending their processes.

docker-compose unpause: Resume paused services.

docker-compose ps: List running services in the current project.

docker-compose logs: View output logs from services.

docker-compose exec: Execute a command in a running container. For example:

bash
Copy code
docker-compose exec <service-name> <command>
docker-compose build: Build or rebuild services defined in the docker-compose.yml file.

docker-compose pull: Pull images for services defined in the docker-compose.yml file.

docker-compose config: Validate and view the compose file.

docker-compose version: Display Docker Compose version information.

docker-compose scale: Scale services to a specified number of instances. For example:

bash
Copy code
docker-compose scale <service-name>=<number-of-instances>

CLIENT SIDE LOAD BALANCING
--------------------------


localhost:8087/eureka/apps

LOAD BALANCING: ROUND ROBIN
OPEN FEIGH CLIENT HANDLES LOAD BALANCING




101831371659
424501504436