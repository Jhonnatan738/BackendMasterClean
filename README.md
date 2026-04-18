<h1 align="center"> Portfolio Backend API Suite </h1>

<p align="center">
<img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" />
<img src="https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white" />
<img src="https://img.shields.io/badge/JSON_Web_Tokens-000000?style=for-the-badge&logo=json-web-tokens&logoColor=white" />
<img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" />
</p>
Sobre el Proyecto

Este repositorio contiene la arquitectura backend centralizada diseñada para gestionar la información de mi ecosistema profesional. Se trata de una API REST escalable, construida sobre Spring Boot 3, donde el foco principal ha sido la seguridad robusta y el manejo eficiente de la persistencia de datos, asegurando una base sólida para cualquier integración frontend.
Tech Stack
Herramienta	Tecnología
Framework	v3.x
Seguridad	JWT Auth
Base de Datos	JPA / Hibernate
Lenguaje	v17/21
Documentación	OpenAPI 3
Build Tool	
Arquitectura del Sistema (Clean Architecture)

El backend ha sido estructurado bajo un patrón de capas para garantizar la separación de responsabilidades y facilitar el mantenimiento:

    Capa de Seguridad (Security Core): Implementación de SecurityFilterChain personalizada, utilizando filtros de interceptación para validar JSON Web Tokens (JWT) en cada petición.

    Gestión de Errores Global: Uso de @RestControllerAdvice para capturar excepciones personalizadas, garantizando que el cliente reciba respuestas estandarizadas y profesionales.

    Persistencia y Relaciones: Integración con PostgreSQL, manejando entidades relacionales y repositorios optimizados con Spring Data JPA.

    Inyección de Dependencias: Gestión avanzada de Beans para evitar el acoplamiento fuerte y resolver conflictos de dependencias circulares.

Endpoints Destacados (Integración)

    ✅ Auth Module: Endpoints de /login y /auth para generación y validación de tokens.

    ✅ Project Management: CRUD completo para la gestión de proyectos en el portafolio.

    ✅ Public Access: Configuración de rutas de solo lectura accesibles sin autenticación.

    ✅ Swagger Docs: Interfaz interactiva para pruebas de API en tiempo real.

Seguridad & Control de Errores

    [!IMPORTANT]
    Autenticación Stateless: El sistema no almacena sesiones en servidor, todo se maneja mediante tokens cifrados, lo que permite una escalabilidad horizontal superior.

    Excepciones Personalizadas: Se han creado clases específicas (RecursoNoEncontrado, AuthFailed) para un control granular de las respuestas HTTP.

    CORS Configuration: Configuración optimizada para permitir conexiones seguras desde el dominio del frontend.

    Validación de Datos: Uso de anotaciones de validación para asegurar la integridad de los datos antes de persistir en la base de datos.

Ejecución Local

    Clona el repositorio:
    Bash

    git clone https://github.com/Jhonnatan738/Portfolio-Backend.git

    Configura el entorno:
    Asegúrate de tener una instancia de PostgreSQL corriendo y configura las credenciales en application.properties.

    Ejecuta la aplicación:
    Bash

    mvn clean install
    mvn spring-boot:run

<p align="center">
Desarrollado por <a href="[Jhonnatan Posada](https://jhonnatanposada.dev/)" target="_blank">Jhonnatan Posada</a>
</p>
