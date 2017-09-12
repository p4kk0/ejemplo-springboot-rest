# ejemplo-springboot-rest
Ejemplo Rest, Spring boot con H2 DB

### URL para H2
http://localhost:8080/h2

### URIs Rest
*  Guardar (Post) *http://localhost:8080/personas*
```
{
    "nombre": "nombre de persona",
    "apellidos": "apellidos de persona",
    "edad": 31,
    "gay": false
}
```
*  Editar (Put) *http://localhost:8080/personas/{id}* ejemplo *http://localhost:8080/personas/2*
```
{
    "nombre": "otro nombre de persona",
    "apellidos": "apellidos de persona",
    "edad": 22,
    "gay": false
}
```
*  Consultar todas las personas (Get) *http://localhost:8080/personas*
*  Consultar una persona (Get) *http://localhost:8080/personas/{id}* ejemplo *http://localhost:8080/personas/2*
*  Eliminar una persona (Delete) *http://localhost:8080/personas/{id}* ejemplo *http://localhost:8080/personas/2*
