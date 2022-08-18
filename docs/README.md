```shell
cd live-backend/live-backend-common
mvn clean install
cd ../live-backend-mp 
mvn clean package

cd coral-community/coral-backend/coral-backend-mp/src/main/resources
ln -s application-dev.properties.txt application-dev.properties
ln -s application-prod.properties.txt application-prod.properties

cd coral-community/coral-backend/coral-backend-mp
mvn clean package
cd ../../docker/
cd coral-fe
ln -s ../coral/Dockerfile Dockerfile
cd ..
cp ../coral-backend/coral-backend-mp/target/coral-backend-mp-1.0.0.jar coral-fe/ 

sudo docker-compose up
sudo docker-compose up -d
sudo docker-compose ps

sudo docker-compose up coral-mysql80
sudo docker-compose up -d coral-mysql80

mysql -h127.0.0.1 -uroot -p -P3301
coral123456

show databases;
use coral;

create database coral default character set utf8mb4 collate utf8mb4_unicode_ci;
use coral;
create user 'coral'@'127.0.0.1' identified by 'coral123456';
grant all privileges on coral.* to 'coral'@'127.0.0.1';
flush privileges;

mysql -h127.0.0.1 -uroot -p -P3301 coral < ../coral-community.sql

sudo docker-compose up coral-mongodb
sudo docker-compose up -d coral-mongodb

sudo docker-compose up coral-mongo-express
sudo docker-compose up -d coral-mongo-express

http://49.232.6.131:8107/

sudo docker-compose up coral-redis
sudo docker-compose up -d coral-redis

sudo docker-compose build

sudo docker-compose up coral
sudo docker-compose up -d coral

http://49.232.6.131:8106
https://coral.7otech.com/

find . -name "docker-compose.yml"|xargs -I {} grep -r 'redis' {}
find . -name "docker-compose.yml"|xargs -I {} grep -r '6381' {}

sudo docker rmi `docker images | grep none | awk '{print $3}'`
```