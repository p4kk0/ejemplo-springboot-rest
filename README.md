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
*  Editar (Put) *http://localhost:8080/ejemplorest/personas/{idPersona}* ejemplo *http://localhost:8080/ejemplorest/personas/2*
```
{
    "nombre": "otro nombre de persona",
    "apellidos": "apellidos de persona",
    "edad": 22
}
```
*  Consultar todas las personas (Get) *http://localhost:8080/ejemplorest/personas*
*  Consultar una persona (Get) *http://localhost:8080/ejemplorest/personas/{idPersona}* ejemplo *http://localhost:8080/ejemplorest/personas/1*
```
{
    "idPersona": 1,
    "nombre": "p4kk0",
    "apellidos": "Carr",
    "edad": 89,
    "_links": {
        "self": {
            "href": "http://localhost:8080/ejemplorest/personas/1"
        },
        "empleos": {
            "href": "http://localhost:8080/ejemplorest/personas/1/empleos"
        }
    }
}
```

*  Eliminar una persona (Delete) *http://localhost:8080/ejemplorest/personas/{idPersona}* ejemplo *http://localhost:8080/ejemplorest/personas/2*

### Hateoas
Servicio Empleado para ejemplificar links de hateoas
Una persona puede tener mas de un empleo

* Consultar todos los empleos de una persona (Get) *http://localhost:8080/ejemplorest/personas/{idPersona}/empleos/* ejemplo *http://localhost:8080/ejemplorest/personas/1/empleos/* 
```
[
    {
        "idEmpleo": 2,
        "nombreEmpleo": "Java developer",
        "empresa": "DC",
        "sector": "publico",
        "fechaInicio": "2016-10-21 00:00:00",
        "fechaFin": "2017-10-21 00:00:00",
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/ejemplorest/personas/1/empleos/2"
            },
            {
                "rel": "persona",
                "href": "http://localhost:8080/ejemplorest/personas/1"
            }
        ]
    },
    {
        "idEmpleo": 3,
        "nombreEmpleo": "Scala developer",
        "empresa": "MO",
        "sector": "privado",
        "fechaInicio": "2011-10-21 00:00:00",
        "fechaFin": "2015-10-21 00:00:00",
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/ejemplorest/personas/1/empleos/3"
            },
            {
                "rel": "persona",
                "href": "http://localhost:8080/ejemplorest/personas/1"
            }
        ]
    }
]
```

* Consultar un empleo de una persona (Get) *http://localhost:8080/ejemplorest/personas/{idPersona}/empleos/{idEmpleo}* ejemplo *http://localhost:8080/ejemplorest/personas/1/empleos/3* 
```
{
    "idEmpleo": 3,
    "nombreEmpleo": "Scala developer",
    "empresa": "MO",
    "sector": "privado",
    "fechaInicio": "2011-10-21 00:00:00",
    "fechaFin": "2015-10-21 00:00:00",
    "_links": {
        "self": {
            "href": "http://localhost:8080/ejemplorest/personas/1/empleos/3"
        },
        "persona": {
            "href": "http://localhost:8080/ejemplorest/personas/1"
        }
    }
}
```

* Guardar una empleo de una persona (Post) *http://localhost:8080/ejemplorest/personas/1/empleos*
Petición
```
{
    "nombreEmpleo": "Java developer",
    "empresa": "DC",
    "sector": "publico",
    "fechaInicio": "2016-10-21 00:00:000",
    "fechaFin": "2017-10-21 00:00:000"
}
```
