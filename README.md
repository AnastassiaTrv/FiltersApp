# FiltersApp
A service that allows you to create filters with different search criterias. It also provides you with a list of already created filters. These filters can after be used by any other part of a system for a different search scenarios.

<p align="center">
  <img src="./demo/demo_picture.png" width="750">
</p>

1. Start backend server:
```shell
cd FiltersApp/filtersapp-backend/
./mvnw spring-boot:run
```
* use  ```mvnw.cmd``` for the Windows environment if you don't have maven installed
* server default port is 8097
* there are 2 filters records in the DB created on app startup
* h2 in-memory DB web console url:
```shell
http://localhost:8097/h2-console/
```
* use connection string:
```shell
jdbc:h2:mem:filtersapp
```

2. Start client app:
```shell
cd FiltersApp/filtersapp-frontend/
npm install
ng serve --open
```
* client opens on port 4400
* it uses Angular material as a basic components library and Bootstrap 5 for layout
