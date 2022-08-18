```shell
cd live-backend/live-backend-common
mvn clean install
cd ../live-backend-mp 
mvn clean package

cd coral-community/coral-backend/coral-backend-mp/src/main/resources
ln -s application-dev.properties.txt application-dev.properties
ln -s application-prod.properties.txt application-prod.properties
```