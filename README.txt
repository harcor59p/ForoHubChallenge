# API REST - Gestión de Tópicos

Esta API permite gestionar los tópicos relacionados con cursos. Los endpoints soportan operaciones CRUD (Crear, Leer, Actualizar y Eliminar) y están desarrollados con **Java 17** y **Spring Boot**.

---

## Tabla de Contenidos

- [Endpoints](#endpoints)
  - [Crear Tópico](#crear-tópico)
  - [Obtener Tópicos](#obtener-tópicos)
  - [Obtener Tópico por ID](#obtener-tópico-por-id)
  - [Actualizar Tópico](#actualizar-tópico)
  - [Eliminar Tópico](#eliminar-tópico)
- [Modelo de Datos](#modelo-de-datos)
- [Requisitos Previos](#requisitos-previos)
- [Instalación](#instalación)

---

## Endpoints

### Crear Tópico

**Método:** `POST`  
**Endpoint:** `/topicos`  

**Body (JSON):**
```json
{
    "titulo": "Como se crea un CRUD en Spring",
    "mensaje": "Quisiera conocer la forma de realizar la creación y codificación de un CRUD en Java con Spring",
    "fechaCreacion": "2025-01-21T10:00",
    "status": "CREADO",
    "usuarioId": 1,
    "cursoId": 1
}
```

**Respuesta Exitosa (201):**
```json
{
    "id": 1,
    "titulo": "Como se crea un CRUD en Spring",
    "mensaje": "Quisiera conocer la forma de realizar la creación y codificación de un CRUD en Java con Spring",
    "fechaCreacion": "2025-01-21T10:00",
    "status": "CREADO",
    "usuario": 1,
    "curso": 1,
    "activo": true
}
```

---

### Obtener Tópicos

**Método:** `GET`  
**Endpoint:** `/topicos`  

**Parámetros Opcionales:**
- `page` (entero): Número de la página.
- `size` (entero): Cantidad de registros por página.
- `sort` (string): Campo para ordenar los registros.

**Respuesta Exitosa (200):**
```json
{
    "content": [
        {
            "id": 1,
            "titulo": "Como se crea un CRUD en Spring",
            "mensaje": "Quisiera conocer la forma de realizar la creación y codificación de un CRUD en Java con Spring",
            "fechaCreacion": "2025-01-21T10:00",
            "status": "CREADO",
            "usuario": 1,
            "curso": 1,
            "activo": true
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10
    },
    "totalElements": 1,
    "totalPages": 1
}
```

---

### Obtener Tópico por ID

**Método:** `GET`  
**Endpoint:** `/topicos/{id}`  

**Respuesta Exitosa (200):**
```json
{
    "id": 1,
    "titulo": "Como se crea un CRUD en Spring",
    "mensaje": "Quisiera conocer la forma de realizar la creación y codificación de un CRUD en Java con Spring",
    "fechaCreacion": "2025-01-21T10:00",
    "status": "CREADO",
    "usuario": 1,
    "curso": 1,
    "activo": true
}
```

**Respuesta Error (404):**
```json
{
    "timestamp": "2025-01-21T11:00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Tópico no encontrado",
    "path": "/topicos/999"
}
```

---

### Actualizar Tópico

**Método:** `PUT`  
**Endpoint:** `/topicos/{id}`  

**Body (JSON):**
```json
{
    "titulo": "Actualización del título",
    "mensaje": "Este es un mensaje actualizado",
    "status": "ACTUALIZADO",
    "fechaCreacion": "2025-01-22T15:00"
}
```

**Respuesta Exitosa (200):**
```json
{
    "id": 1,
    "titulo": "Actualización del título",
    "mensaje": "Este es un mensaje actualizado",
    "fechaCreacion": "2025-01-22T15:00",
    "status": "ACTUALIZADO",
    "usuario": 1,
    "curso": 1,
    "activo": true
}
```

---

### Eliminar Tópico

**Método:** `DELETE`  
**Endpoint:** `/topicos/{id}`  

**Respuesta Exitosa (204):**  
Sin contenido.

**Respuesta Error (404):**
```json
{
    "timestamp": "2025-01-21T11:00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Tópico no encontrado",
    "path": "/topicos/999"
}
```

---

## Modelo de Datos

### Tópico
| Campo          | Tipo        | Descripción                                 |
|----------------|-------------|---------------------------------------------|
| `id`           | Long        | Identificador único del tópico.            |
| `titulo`       | String      | Título del tópico.                         |
| `mensaje`      | String      | Contenido o descripción del tópico.        |
| `fechaCreacion`| LocalDateTime | Fecha y hora de creación del tópico.     |
| `status`       | Enum        | Estado del tópico (`CREADO`, `ACTUALIZADO`).|
| `usuarioId`    | Long        | ID del usuario asociado.                   |
| `cursoId`      | Long        | ID del curso asociado.                     |
| `activo`       | Boolean     | Indica si el tópico está activo.           |

---

## Requisitos Previos

1. **Java 17**
2. **Spring Boot 3.x**
3. **Base de datos**: Configurada y en ejecución (MySQL, PostgreSQL, etc.).
4. **Postman** (o herramienta similar) para probar los endpoints.

---

## Instalación

1. Clona este repositorio.
2. Configura la conexión a la base de datos en el archivo `application.properties` o `application.yml`.
3. Ejecuta la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Accede a los endpoints desde `http://localhost:8080`.

