# 🏥 Medvoll API

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-brightgreen)
![Java](https://img.shields.io/badge/Java-21-orange)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Maven](https://img.shields.io/badge/Maven-3.9-red)
![License](https://img.shields.io/badge/License-MIT-yellow)

> 🩺 **API REST para gestión de consultas médicas** desarrollada con Spring Boot, diseñada para administrar médicos, pacientes y consultas de manera eficiente y segura.

## 📋 Tabla de Contenidos

- [🔍 Descripción del Proyecto](#-descripción-del-proyecto)
- [✨ Funcionalidades](#-funcionalidades)
- [🏗️ Arquitectura](#️-arquitectura)
- [🛠️ Tecnologías Utilizadas](#️-tecnologías-utilizadas)
- [📁 Estructura del Proyecto](#-estructura-del-proyecto)
- [⚙️ Instalación y Configuración](#️-instalación-y-configuración)
- [🚀 Uso de la API](#-uso-de-la-api)
- [🔐 Autenticación](#-autenticación)
- [📝 Documentación de Endpoints](#-documentación-de-endpoints)
- [🧪 Testing](#-testing)
- [🤝 Contribuciones](#-contribuciones)

## 🔍 Descripción del Proyecto

**Medvoll API** es una aplicación REST desarrollada como parte del programa de formación Alura, implementando un sistema completo de gestión médica que permite:

- 👩‍⚕️ Administrar información de médicos
- 🧑‍🦽 Gestionar datos de pacientes  
- 📅 Programar y cancelar consultas médicas
- 🔒 Control de acceso mediante autenticación JWT
- 📊 Documentación interactiva con Swagger

## ✨ Funcionalidades

### 👨‍⚕️ Gestión de Médicos
- ✅ **Registrar** nuevos médicos con validaciones
- 📋 **Listar** médicos activos con paginación
- 🔄 **Actualizar** información de médicos
- 🗑️ **Eliminación lógica** (desactivar médicos)
- 🔍 **Consultar** detalles de un médico específico

### 👥 Gestión de Pacientes  
- ✅ **Registrar** nuevos pacientes
- 📋 **Listar** pacientes activos con paginación
- 🔄 **Actualizar** información de pacientes
- 🗑️ **Eliminación lógica** (desactivar pacientes)
- 🔍 **Consultar** detalles de un paciente específico

### 📅 Sistema de Consultas
- 📝 **Agendar** consultas con validaciones avanzadas
- ❌ **Cancelar** consultas con motivo
- 🤖 **Asignación automática** de médicos disponibles
- ✔️ **Validaciones de negocio**:
  - Horarios de funcionamiento (Lunes-Sábado, 07:00-19:00)
  - Anticipación mínima de 30 minutos
  - Un paciente por día máximo
  - Médicos sin consultas simultáneas
  - Verificación de médicos y pacientes activos

### 🔐 Seguridad
- 🔑 **Autenticación JWT** con tokens seguros
- 🛡️ **Spring Security** para protección de endpoints
- 🚫 **Control de acceso** a recursos protegidos

## 🏗️ Arquitectura

La aplicación sigue el patrón **MVC (Model-View-Controller)** con **Domain Driven Design**:

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Controllers   │────│    Services     │────│  Repositories   │
│   (REST API)    │    │   (Business)    │    │   (Data Layer)  │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │                       │
         ▼                       ▼                       ▼
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│      DTOs       │    │   Validations   │    │    Entities     │
│  (Data Transfer)│    │  (Business Rules)│    │   (Database)    │
└─────────────────┘    └─────────────────┘    └─────────────────┘
```

## 🛠️ Tecnologías Utilizadas

### 🔧 Backend Core
| Tecnología | Versión | Descripción |
|------------|---------|-------------|
| ![Java](https://img.shields.io/badge/-Java-ED8B00?logo=java) | **21** | Lenguaje de programación principal |
| ![Spring Boot](https://img.shields.io/badge/-Spring%20Boot-6DB33F?logo=spring) | **3.5.3** | Framework principal para desarrollo |
| ![Maven](https://img.shields.io/badge/-Maven-C71A36?logo=apache-maven) | **3.9+** | Gestión de dependencias y construcción |

### 🗄️ Persistencia de Datos
| Tecnología | Versión | Descripción |
|------------|---------|-------------|
| ![Spring Data JPA](https://img.shields.io/badge/-Spring%20Data%20JPA-6DB33F?logo=spring) | **3.5.3** | Abstracción para acceso a datos |
| ![MySQL](https://img.shields.io/badge/-MySQL-4479A1?logo=mysql) | **8.0+** | Sistema de gestión de base de datos |
| ![Hibernate](https://img.shields.io/badge/-Hibernate-59666C?logo=hibernate) | **6.4+** | ORM (Object-Relational Mapping) |

### 🔐 Seguridad
| Tecnología | Versión | Descripción |
|------------|---------|-------------|
| ![Spring Security](https://img.shields.io/badge/-Spring%20Security-6DB33F?logo=spring) | **6.2+** | Framework de seguridad |
| ![JWT](https://img.shields.io/badge/-JWT-000000?logo=json-web-tokens) | **4.5.0** | Tokens de autenticación |

### 🛠️ Herramientas de Desarrollo
| Tecnología | Versión | Descripción |
|------------|---------|-------------|
| ![Lombok](https://img.shields.io/badge/-Lombok-BC1A1A) | **1.18+** | Reducción de código boilerplate |
| ![Bean Validation](https://img.shields.io/badge/-Bean%20Validation-orange) | **3.0+** | Validaciones de datos |
| ![SpringDoc](https://img.shields.io/badge/-SpringDoc-green) | **2.8.9** | Documentación OpenAPI/Swagger |
| ![Spring DevTools](https://img.shields.io/badge/-Spring%20DevTools-6DB33F?logo=spring) | **3.5.3** | Herramientas de desarrollo |

## 📁 Estructura del Proyecto

```
📂 src/main/java/com/medvoll/api/
├── 📄 ApiApplication.java                 # Clase principal de la aplicación
│
├── 📂 controller/                         # Controladores REST
│   ├── 🩺 MedicoController.java          # Endpoints de médicos
│   ├── 👥 PacienteController.java        # Endpoints de pacientes  
│   ├── 📅 ConsultaController.java        # Endpoints de consultas
│   ├── 🔐 AutenticacionController.java   # Endpoint de login
│   └── 👋 HelloController.java           # Endpoint de prueba
│
├── 📂 domain/                            # Lógica de dominio
│   ├── 📂 medico/                        # Dominio de médicos
│   │   ├── 👨‍⚕️ Medico.java              # Entidad Médico
│   │   ├── 📝 MedicoDTO.java             # DTO para creación
│   │   ├── 📋 ListaMedicoDTO.java        # DTO para listado
│   │   ├── 🔄 ActualizarMedicoDTO.java   # DTO para actualización
│   │   ├── 📊 DetallesActualizacionMedicoDTO.java # DTO respuesta
│   │   ├── 🏥 Especialidad.java          # Enum especialidades
│   │   └── 🗃️ IMedicoRepository.java     # Repositorio de médicos
│   │
│   ├── 📂 paciente/                      # Dominio de pacientes
│   │   ├── 👤 Paciente.java              # Entidad Paciente
│   │   ├── 📝 PacienteDTO.java           # DTO para creación
│   │   ├── 📋 ListaPacienteDTO.java      # DTO para listado
│   │   ├── 🔄 ActualizarPacienteDTO.java # DTO para actualización
│   │   ├── 📊 DetallesPacienteDTO.java   # DTO respuesta
│   │   └── 🗃️ IPacienteRepository.java   # Repositorio de pacientes
│   │
│   ├── 📂 consulta/                      # Dominio de consultas
│   │   ├── 📅 Consulta.java              # Entidad Consulta
│   │   ├── 📝 DatosReservaConsultaDTO.java      # DTO para agendar
│   │   ├── ❌ DatosCancelamientoConsultaDTO.java # DTO para cancelar
│   │   ├── 📊 DatosDetallesConsultaDTO.java     # DTO respuesta
│   │   ├── 🔄 MotivoCancelamiento.java          # Enum motivos
│   │   ├── 🏥 ReservaDeConsultaService.java     # Servicio de consultas
│   │   ├── 🗃️ IConsultaRepository.java         # Repositorio consultas
│   │   └── 📂 validaciones/              # Validaciones de negocio
│   │       ├── ✅ ValidadorDeConsultas.java     # Interfaz validador
│   │       ├── ⏰ ValidadorConsultaConAnticipacion.java
│   │       ├── 🕐 ValidadorFueraHorarioConsulta.java
│   │       ├── 👨‍⚕️ ValidadorMedicoActivo.java
│   │       ├── 📅 ValidadorMedicoConOtraConsultaEnElMismoHorario.java
│   │       ├── 👥 ValidadorPacienteActivo.java
│   │       └── 📆 ValidadorPacienteSinOtraConsultaElMismoDia.java
│   │
│   ├── 📂 direccion/                     # Dominio de direcciones
│   │   ├── 🏠 Direccion.java             # Entidad embebida
│   │   └── 📝 DireccionDTO.java          # DTO de dirección
│   │
│   ├── 📂 usuario/                       # Dominio de usuarios
│   │   ├── 👤 Usuario.java               # Entidad Usuario
│   │   ├── 🔐 AutenticacionDTO.java      # DTO de login
│   │   ├── 🔑 AutenticacionService.java  # Servicio de autenticación
│   │   └── 🗃️ IUsuarioRepository.java    # Repositorio usuarios
│   │
│   └── ❌ ValidacionException.java       # Excepción personalizada
│
└── 📂 infra/                            # Infraestructura
    ├── 📂 exceptions/                    # Manejo de excepciones
    │   └── 🚨 GestorDeErrores.java      # Controlador global de errores
    │
    ├── 📂 security/                      # Configuración de seguridad
    │   ├── 🔒 SecurityConfiguration.java # Configuración Spring Security
    │   ├── 🔑 TokenService.java         # Servicio para JWT
    │   ├── 🛡️ SecurityFilter.java       # Filtro de seguridad
    │   └── 📝 DatosTokenJWT.java        # DTO para token
    │
    └── 📂 springdoc/                     # Configuración documentación
        └── 📚 SpringDocConfiguration.java # Config Swagger/OpenAPI

📂 src/main/resources/
├── ⚙️ application.properties             # Configuración principal
├── 🧪 application-test.properties        # Configuración para tests
└── 🚀 application-prod.properties        # Configuración para producción

📂 src/test/java/
├── 📂 controller/                        # Tests de controladores
│   └── 🧪 ConsultaControllerTest.java
└── 📂 domain/                           # Tests de dominio
    └── 📂 medico/
        └── 🧪 IMedicoRepositoryTest.java
```

## ⚙️ Instalación y Configuración

### 📋 Prerrequisitos

Asegúrate de tener instalado:

- ☕ **Java 21** o superior
- 📦 **Maven 3.9+**
- 🗄️ **MySQL 8.0+**
- 🛠️ **IDE** (IntelliJ IDEA, Eclipse, VS Code)

### 🚀 Pasos de Instalación

1. **📥 Clonar el repositorio**
   ```bash
   git clone https://github.com/tu-usuario/medvoll-api.git
   cd medvoll-api
   ```

2. **🗄️ Configurar base de datos MySQL**
   ```sql
   CREATE DATABASE medvoll;
   CREATE USER 'medvoll_user'@'localhost' IDENTIFIED BY 'tu_password';
   GRANT ALL PRIVILEGES ON medvoll.* TO 'medvoll_user'@'localhost';
   FLUSH PRIVILEGES;
   ```

3. **⚙️ Configurar variables de entorno**
   
   Crea un archivo `.env` o configura las variables de sistema:
   ```properties
   MYSQL_HOST=localhost:3306
   DB_MYSQL=medvoll
   MYSQL_USER=medvoll_user
   DB_PASSWORD=tu_password
   JWT_SECURITY_TOKEN_SECRET=mi_clave_secreta_jwt_muy_larga_y_segura
   ```

4. **📦 Instalar dependencias**
   ```bash
   mvn clean install
   ```

5. **🚀 Ejecutar la aplicación**
   ```bash
   mvn spring-boot:run
   ```

   O ejecutar el JAR compilado:
   ```bash
   java -jar target/api-0.0.1-SNAPSHOT.jar
   ```

6. **✅ Verificar instalación**
   
   La aplicación estará disponible en: `http://localhost:8080`
   
   Documentación Swagger: `http://localhost:8080/swagger-ui.html`

## 🚀 Uso de la API

### 🌐 Base URL
```
http://localhost:8080
```

### 📊 Documentación Interactiva
La documentación completa de la API está disponible en Swagger UI:
```
http://localhost:8080/swagger-ui.html
```

## 🔐 Autenticación

### 🔑 Obtener Token JWT

**Endpoint:** `POST /login`

```json
{
    "login": "admin@medvoll.com",
    "contrasena": "123456"
}
```

**Respuesta:**
```json
{
    "jwTtoken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### 🛡️ Usar Token en Requests

Incluir el token en el header `Authorization`:
```
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

## 📝 Documentación de Endpoints

### 👨‍⚕️ Endpoints de Médicos

| Método | Endpoint | Descripción | Auth |
|--------|----------|-------------|------|
| `POST` | `/medicos` | 📝 Registrar nuevo médico | 🔒 JWT |
| `GET` | `/medicos` | 📋 Listar médicos (paginado) | 🔒 JWT |
| `GET` | `/medicos/{id}` | 👀 Obtener detalles de médico | 🔒 JWT |
| `PUT` | `/medicos` | ✏️ Actualizar médico | 🔒 JWT |
| `DELETE` | `/medicos/{id}` | 🗑️ Eliminar médico (lógico) | 🔒 JWT |

### 👥 Endpoints de Pacientes

| Método | Endpoint | Descripción | Auth |
|--------|----------|-------------|------|
| `POST` | `/pacientes` | 📝 Registrar nuevo paciente | 🔒 JWT |
| `GET` | `/pacientes` | 📋 Listar pacientes (paginado) | 🔒 JWT |
| `GET` | `/pacientes/{id}` | 👀 Obtener detalles de paciente | 🔒 JWT |
| `PUT` | `/pacientes` | ✏️ Actualizar paciente | 🔒 JWT |
| `DELETE` | `/pacientes/{id}` | 🗑️ Eliminar paciente (lógico) | 🔒 JWT |

### 📅 Endpoints de Consultas

| Método | Endpoint | Descripción | Auth |
|--------|----------|-------------|------|
| `POST` | `/consultas` | 📝 Agendar nueva consulta | 🔒 JWT |
| `DELETE` | `/consultas` | ❌ Cancelar consulta | 🔒 JWT |

### 🔐 Endpoint de Autenticación

| Método | Endpoint | Descripción | Auth |
|--------|----------|-------------|------|
| `POST` | `/login` | 🔑 Iniciar sesión | ❌ Público |

### 🎯 Ejemplos de Uso

#### 📝 Registrar Médico
```bash
curl -X POST http://localhost:8080/medicos \
  -H "Authorization: Bearer {token}" \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Dr. Juan Pérez",
    "email": "juan.perez@medvoll.com",
    "telefono": "123456789",
    "documento": "12345678901",
    "especialidad": "CARDIOLOGIA",
    "direccion": {
      "calle": "Av. Siempre Viva",
      "distrito": "Centro",
      "ciudad": "Springfield",
      "numero": "742",
      "complemento": "Piso 2"
    }
  }'
```

#### 📅 Agendar Consulta
```bash
curl -X POST http://localhost:8080/consultas \
  -H "Authorization: Bearer {token}" \
  -H "Content-Type: application/json" \
  -d '{
    "idPaciente": 1,
    "idMedico": 1,
    "fecha": "2024-12-15T10:00:00"
  }'
```

## 🧪 Testing

### 🔍 Ejecutar Tests
```bash
# Todos los tests
mvn test

# Tests específicos
mvn test -Dtest=ConsultaControllerTest
mvn test -Dtest=IMedicoRepositoryTest
```

### 📊 Cobertura de Tests
```bash
mvn test jacoco:report
```

Los reportes se generan en: `target/site/jacoco/index.html`

## 🎯 Reglas de Negocio Implementadas

### ✅ Validaciones de Consultas

1. **⏰ Horario de Atención**
   - Lunes a Sábado: 07:00 - 19:00
   - Domingos: Cerrado

2. **⏱️ Anticipación Mínima**
   - Consultas deben agendarse con al menos 30 minutos de anticipación

3. **👥 Límite por Paciente**
   - Un paciente solo puede tener una consulta por día

4. **👨‍⚕️ Disponibilidad de Médicos**
   - Médicos no pueden tener consultas simultáneas
   - Solo médicos activos pueden ser asignados

5. **🎲 Asignación Automática**
   - Si no se especifica médico, se asigna uno disponible aleatoriamente

## 🐛 Manejo de Errores

La API maneja diferentes tipos de errores:

### 400 - Bad Request
```json
{
  "error": "Datos de entrada inválidos",
  "message": "El campo 'email' es obligatorio"
}
```

### 401 - Unauthorized  
```json
{
  "error": "Token inválido o expirado"
}
```

### 404 - Not Found
```json
{
  "error": "Recurso no encontrado",
  "message": "Médico con ID 123 no existe"
}
```

### 500 - Internal Server Error
```json
{
  "error": "Error interno del servidor"
}
```

## 🔧 Configuración de Entornos

### 🧪 Desarrollo (application.properties)
```properties
spring.application.name=api
spring.datasource.url=jdbc:mysql://localhost:3306/medvoll
spring.jpa.show-sql=true
server.error.include-stacktrace=never
```

### 🧪 Testing (application-test.properties)  
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.hibernate.ddl-auto=create-drop
```

### 🚀 Producción (application-prod.properties)
```properties
spring.datasource.url=${DATABASE_URL}
spring.jpa.show-sql=false
spring.jpa.hibernate.ddl-auto=validate
```

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Por favor:

1. 🍴 Fork el proyecto
2. 🌿 Crear una rama feature (`git checkout -b feature/nueva-funcionalidad`)
3. 💾 Commit cambios (`git commit -m 'Agregar nueva funcionalidad'`)
4. 📤 Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. 🔄 Abrir un Pull Request

### 📋 Guidelines de Contribución

- ✅ Seguir las convenciones de código existentes
- 🧪 Escribir tests para nuevas funcionalidades
- 📖 Actualizar documentación cuando sea necesario
- 🔍 Verificar que todos los tests pasen

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo [LICENSE](LICENSE) para más detalles.

## 👨‍💻 Autor

**Santiago Ferreira**
- 📧 Email: ferreirasantiago659@gmail.com
- 💼 LinkedIn: [Santiago Ferreira](https://linkedin.com/in/santiagoandres-ferreira)
- 🐱 GitHub: [@Santf9](https://github.com/Santf9)

---

<div align="center">

**⭐ ¡Si te gusta este proyecto, dale una estrella! ⭐**

*Desarrollado con ❤️ como parte del programa de formación Alura*

![Made with Spring Boot](https://img.shields.io/badge/Made%20with-Spring%20Boot-brightgreen)
![Made with Java](https://img.shields.io/badge/Made%20with-Java-orange)
![Made with MySQL](https://img.shields.io/badge/Made%20with-MySQL-blue)

</div>
