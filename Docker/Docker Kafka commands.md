docker-compose exec kafka --create --topic baeldung_linux --partitions 1 --replication-factor 1 --bootstrap-server kafka:9092




kafka-topics.bat --create --topic mytoopic --bootstrap-server localhost:9092




docker-compose exec kafka --create --topic mytoopic --bootstrap-server kafka:9092
docker-compose exec


kafka-topics.bat --create --topic mytoopic --bootstrap-server localhost:9092


-------------------
Syntax:
docker exec <kafka-container-name-or-id> kafka-topics.sh --create --topic my-topic --partitions 1 --replication-factor 1 --bootstrap-server localhost:9092

Example:
docker exec kafka kafka-topics.sh --create --topic my-topic --partitions 1 --replication-factor 1 --bootstrap-server localhost:9092
-------------------


docker exec -it <kafka-container-name-or-id> /bin/bash


docker exec -it kafka /bin/bash



111%10 = 1 => (111/10)+1 => 11+1 = 12
13%10 = 3 => (13/10)+1 => 11+1 = 12 

