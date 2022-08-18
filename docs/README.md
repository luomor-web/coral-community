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

sudo docker-compose up coral-mysql80
sudo docker-compose up -d coral-mysql80

sudo docker-compose up coral-mongodb
sudo docker-compose up -d coral-mongodb

sudo docker-compose up coral-mongo-express
sudo docker-compose up -d coral-mongo-express

sudo docker-compose up coral-redis
sudo docker-compose up -d coral-redis


sudo docker-compose build

sudo docker-compose up coral
sudo docker-compose up -d coral

find . -name "docker-compose.yml"|xargs -I {} grep -r 'redis' {}
find . -name "docker-compose.yml"|xargs -I {} grep -r '6381' {}
```