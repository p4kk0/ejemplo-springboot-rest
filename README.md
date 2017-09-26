# ejemplo-springboot-rest
Ejemplo Rest, Spring boot con H2 DB

### URL para H2
http://localhost:8080/ejemplorest/h2

### URIs Rest
*  Guardar (Post) *http://localhost:8080/ejemplorest/personas*
```
{
    "nombre": "nombre de persona",
    "apellidos": "apellidos de persona",
    "edad": 31
}
```
*  Editar (Put) *http://localhost:8080/ejemplorest/personas/{id}* ejemplo *http://localhost:8080/ejemplorest/personas/2*
```
{
    "nombre": "otro nombre de persona",
    "apellidos": "apellidos de persona",
    "edad": 22
}
```
*  Consultar todas las personas (Get) *http://localhost:8080/ejemplorest/personas*
*  Consultar una persona (Get) *http://localhost:8080/ejemplorest/personas/{id}* ejemplo *http://localhost:8080/ejemplorest/personas/2*
*  Eliminar una persona (Delete) *http://localhost:8080/ejemplorest/personas/{id}* ejemplo *http://localhost:8080/ejemplorest/personas/2*
