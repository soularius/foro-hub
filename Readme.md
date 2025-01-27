
# ForoHub API

ForoHub es una API REST creada con **Java Spring Boot** para gestionar tópicos, usuarios y cursos. Esta API permite a los usuarios crear, consultar, actualizar y eliminar registros, con características como validaciones, paginación y búsquedas avanzadas.

## 🚀 Funcionalidades Principales

### Usuarios
- Crear un usuario.
- Consultar todos los usuarios o por ID.
- Actualizar los datos de un usuario.
- Eliminar un usuario.
- Inscribir un usuario en un curso.

### Cursos
- Crear un curso.
- Consultar todos los cursos o por ID.
- Actualizar los datos de un curso.
- Eliminar un curso.

### Tópicos
- Crear un tópico asociado a un autor y curso.
- Consultar todos los tópicos o por ID.
- Consultar tópicos paginados.
- Buscar tópicos por curso y año.
- Actualizar un tópico.
- Eliminar un tópico.

---

## 🛠️ Configuración del Proyecto

### 1. Clonar el Repositorio
```bash
git clone https://github.com/tu-usuario/foro-hub-api.git
cd foro-hub-api
```

### 2. Configurar la Base de Datos
1. Asegúrate de tener una base de datos MySQL en funcionamiento.
2. Crea un esquema llamado `foro_hub`:
   ```sql
   CREATE DATABASE foro_hub;
   ```

### 3. Configuración en `application.properties`
Edita el archivo `src/main/resources/application.properties` con las credenciales de tu base de datos:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Instalar Dependencias
Usa Maven para descargar todas las dependencias:
```bash
mvn clean install
```

### 5. Ejecutar el Proyecto
Inicia la aplicación:
```bash
mvn spring-boot:run
```

---

## 🗂️ Estructura del Proyecto

```
src/
├── main/
│   ├── java/com/example/CHALENGER_4/
│   │   ├── config/               # Configuraciones (seguridad, Swagger, etc.)
│   │   ├── controller/           # Controladores REST
│   │   ├── dto/                  # Clases de transferencia de datos (DTOs)
│   │   ├── exception/            # Manejo global de excepciones
│   │   ├── model/                # Entidades JPA
│   │   ├── repository/           # Interfaces para acceso a datos
│   │   ├── service/              # Lógica de negocio
│   │   └── Chalenger4Application.java  # Clase principal
│   └── resources/
│       ├── db/migration/         # Scripts de migración Flyway (opcional)
│       ├── application.properties # Configuración del proyecto
│       └── static/               # Archivos estáticos (HTML, CSS, etc.)
```

---

## 🧪 Pruebas

### **Colección de Postman**
Puedes importar la colección completa de Postman para probar todos los endpoints. A continuación, se detallan algunos ejemplos básicos.

### **1. Endpoints de Usuario**
#### Crear un Usuario
- **POST**: `http://localhost:8080/users`
```json
{
    "name": "John Doe",
    "email": "johndoe@example.com"
}
```

#### Inscribir un Usuario en un Curso
- **PUT**: `http://localhost:8080/users/{userId}/enroll/{courseId}`

---

### **2. Endpoints de Curso**
#### Crear un Curso
- **POST**: `http://localhost:8080/courses`
```json
{
    "name": "Spring Boot",
    "description": "Curso de introducción a Spring Boot"
}
```

---

### **3. Endpoints de Tópico**
#### Crear un Tópico
- **POST**: `http://localhost:8080/topics`
```json
{
    "title": "Pregunta sobre Spring",
    "message": "¿Cómo configurar Flyway en Spring Boot?",
    "authorId": "123e4567-e89b-12d3-a456-426614174000",
    "courseId": "456e7890-e89b-12d3-a456-426614174111"
}
```

#### Obtener Tópicos Paginados
- **GET**: `http://localhost:8080/topics/paged?page=0&size=5`

#### Buscar Tópicos por Curso y Año
- **GET**: `http://localhost:8080/topics/search?courseName=Spring Boot&year=2023`

---

## 📚 Documentación de la API
La API incluye una interfaz Swagger para explorar y probar los endpoints:
- URL: `http://localhost:8080/swagger-ui/index.html`

---

## 🚨 Reglas de Negocio

1. **Validaciones**:
    - Todos los campos son obligatorios.
    - No se permite crear tópicos duplicados (basado en título y mensaje).

2. **Paginación y Búsqueda**:
    - Los tópicos pueden ser consultados de forma paginada y con criterios de búsqueda (curso y año).

---

## 🔧 Tecnologías Usadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL**
- **Swagger**
- **Postman (para pruebas)**

---

## 📄 Licencia
Este proyecto está bajo la licencia [MIT](LICENSE).

---
