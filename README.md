## terminal-shop-services

## Create application docker image

- docker build -t "terminal-shop-services" .

## Run image in a docker container

- docker run -d -p 8080:8080 --name terminal-shop-services  terminal-shop-services:latest


    El perfil puede especificarse usando -e "SPRING_PROFILES_ACTIVE=Profile"
    Ejemplo: 
    docker run -d -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=LOCAL" --name terminal-shop-services terminal-shop-services:latest
  

## See Swagger

- Visualizar el template html de Swagger:
  - http://localhost:8080/swagger-ui-html