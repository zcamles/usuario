# Users micro-service
Este micro-servicio ofrece funcionalidades en torno a los usuarios, actualmente esta en construccion.

**Disclaimer: este codigo resuelve la necesidad planteada en el archivo Evaluation.md**

## Requerimientos
- Java 17

## Tecnologias
- Java 17
- Spring WebMvc
- Gradle
- Postman
- Swagger
- Git

# Servicio
## Rutas
- **URI-Local:** http://localhost:8080 
- **Base-Path:** /api/sign

## Testing
Para ejecutar las pruebas solo debes hacer uso del comando correspondiente a tu S.O:
- windows: `./gradlew.bat test`
- linux: `./gradlew test`
- mac: `./gradlew test`

Tambien puedes usar tu IDE favorito para ejecutarlas.

# Construir el servicio

Para utilizar el servicio tienes a continuacion la forma:
- la opcion que tienes es utilizar el gradle wrapper que viene en el servicio, de igual forma debes tener instalado java 17 en tu equipo, por que debes compilar por tu cuenta el servicio, para ello utilizaras el comando build desde el wrapper correspondiente a tu equipo:
-- windows: `./gradlew.bat build`
-- linux: `./gradlew build`
-- mac: `./gradlew build`

# Levantar el servicio

una vez construido el servicio, solo en el caso de haber compilado mediante Gradle, si usaste la opcion docker o docker-compose salta hasta la seccion `Pruebas`, se generaran dos Jar's esto es para eficientar el uso posterior de docker, para ello solo debes correr el siguiente comando y asi ejecutaras el servicio
- `java -jar /ruta/hacia/el/proyecto/build/libs/nombre-del-servicio.jar`

si todo va bien deberias ver los logs levantarse en tu consola, ya ahora puedes continuar con las pruebas.

# Pruebas
para utilizar postman debes simplemente importar el archivo que se encuentra dentro de la carpeta postman y correr la colleccion, esto ejecutara las pruebas que viene dentro de cada request, si todo ha salido bien todas deberian estar en verde.

# Swagger UI
el proyecto cuenta con [Swagger-UI](http://localhost:8080/api/sign/swagger-ui/index.html#/usuario-rest/signUp)