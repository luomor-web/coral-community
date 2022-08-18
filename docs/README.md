```shell
cd live-backend/live-backend-common
mvn clean install
cd ../live-backend-mp 
mvn clean package

cd coral-community/coral-backend/coral-backend-mp/src/main/resources
ln -s application-dev.properties.txt application-dev.properties
ln -s application-prod.properties.txt application-prod.properties

sudo docker-compose up
sudo docker-compose up -d

sudo docker-compose up coral-mysql80
sudo docker-compose up -d coral-mysql80

find . -name "docker-compose.yml"|xargs -I {} grep -r 'redis' {}
find . -name "docker-compose.yml"|xargs -I {} grep -r '6381' {}
```