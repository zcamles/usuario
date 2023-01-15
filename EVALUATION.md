# Evaluacion Java

Desarrolle una aplicacion que exponga una API RESTful de creacion de usuarios.

Todos los endpoints deben aceptar y retornar solamente JSON, inclusive al para los mensajes de error.

Todos los mensajes deben seguir el formato:

```
{"mensaje": "mensaje de error"}
```

## Registro

- [X] Ese endpoint deberá recibir un usuario con los campos "nombre", "correo", "contraseña", más un listado de objetos "teléfono", respetando el siguiente formato:

```
{
  "name": "Juan Rodriguez",
  "email": "juan@rodriguez.org",
  "password": "hunter2",
  "phones": [
    {
      "number": "1234567",
      "citycode": "1",
      "contrycode": "57"
    }
  ]
}
```

- [X] Responder el código de status HTTP adecuado
- [X] En caso de éxito, retorne el usuario y los siguientes campos:
    - id: id del usuario (puede ser lo que se genera por el banco de datos, pero sería más deseable un UUID)
    - created: fecha de creación del usuario
    - modified: fecha de la última actualización de usuario
    - last_login: del último ingreso (en caso de nuevo usuario, va a coincidir con la fecha de creación)
    - token: token de acceso de la API (puede ser UUID o JWT)
    - isactive: Indica si el usuario sigue habilitado dentro del sistema.
- [X] Si caso el correo conste en la base de datos, deberá retornar un error "El correo ya registrado".
- [X] El correo debe seguir una expresión regular para validar que formato sea el correcto. (aaaaaaa@dominio.cl)
- [X] La clave debe seguir una expresión regular para validar que formato sea el correcto.
- [X] El valor de la expresión regular para la contrasena debe ser configurable
- [ ] El token deberá ser persistido junto con el usuario

## Requisitos
- Banco de datos en memoria.
- Proceso de build vía Gradle o Maven.
- Persistencia con JPA.
- Framework SpringBoot.
- Java 8+
- script de creación de BD.
- Readme explicando cómo probarlo.
- Diagrama de la solución.

## Requisitos opcionales
- JWT como token
- Pruebas unitarias
- Swagger