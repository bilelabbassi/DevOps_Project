 sudo docker container run --name mysqldb --network kaddemnetwork -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=kaddemdb -v /home/mysql/data:/var/lib/mysql -d mysql:8

sudo docker build -t imagekaddem:v1 .

sudo docker container run --network kaddemnetwork --name kaddemcontainer -p 8080:8080 -d imagekaddem:v1



INSERT INTO contrat (id_Contrat, archive,date_debut_contrat, date_fin_contrat, montant_contrat,specialite)
VALUES (1, true ,'2023-10-05', '2024-10-05', 1000 ,'VOTRE_SPECIALITE');

sudo sysctl -w vm.max_map_count=262144

curl GET http://172.24.2:8080/contract/2022-10-01/2025-12-31







FROM maven:3.6.3 AS build
WORKDIR /home/app
COPY . .
 COPY pom.xml /home/app
RUN mvn install
 FROM openjdk:8-jdk-alpine
COPY --from=build /home/app/target/KaddemProject-1.0.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]

docker run -d -p 9090:9090 -v /home/prometheus/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus

prometheus monotoring
grafana visualisation