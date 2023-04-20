# Docker + spring boot


## Commands

- to spin the mysql docker container

```sh
docker run -d \
  --name my-mysql \
  -e MYSQL_ROOT_PASSWORD=myrootpassword \
  -e MYSQL_DATABASE=mydb \
  -e MYSQL_USER=myuser \
  -e MYSQL_PASSWORD=mypassword \
  -v mysql_data:/var/lib/mysql \
  -p 3306:3306 \
  mysql
```

- to run the application docker container, change the image name
```sh
docker run -p 6060:6060 my-spring-boot-app:3.0
```
- environment variables example

```sh
docker run -p 6060:6060 -e super_cool_value=1234 my-spring-boot-app:3.0
```
- run all the containers with docker-compose
```sh
docker-compose up
```
- remove all docker containers ran with compose file
```sh
docker-compose down --rmi all
```

