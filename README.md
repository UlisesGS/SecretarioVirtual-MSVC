# 📅 Gestor de Turnos - Proyecto en Desarrollo 🚀

## 📌 Descripción General
Este proyecto es un **software altamente flexible** para la **gestión de turnos** en cualquier ámbito profesional.  
Permite **diagramar los horarios** de cada empleado y asignar turnos a los usuarios de forma sencilla.  
El sistema está diseñado con una **arquitectura de microservicios** y desarrollado en **Java Spring Boot** con **PostgreSQL** como base de datos principal.

## 🛠️ Funcionalidades Principales
- 👥 **Gestión de Usuarios**: Registro, autenticación y administración de roles.
- 🧑‍💼 **Gestión de Empleados**: Alta, baja y modificación de datos.
- 📅 **Disponibilidad de Fechas**: Planificación de horarios y turnos.
- 🛎️ **Servicios Ofrecidos**: Administración de todos los servicios que la organización provee.
- 📋 **Turnos y Citas**: Reserva, cancelación y reprogramación de turnos.
- 🔒 **Seguridad de Doble Capa**: Validación de token tanto en el Gateway como en cada servicio.
- ♻️ **Refresh Token**: Maximiza la seguridad renovando credenciales sin interrumpir la experiencia.
- 🔐 **Claves SSL (.pem)**: Protección de la comunicación entre servicios.

## 🏗️ Arquitectura de Microservicios
El sistema está compuesto por **9 microservicios** independientes pero integrados:
1. 📜 **service-registry** – Registro de servicios (Eureka Server).
2. ⚙️ **config-server** – Centralización de configuración.
3. 🌐 **gateway** – Puerta de entrada y balanceo de carga.
4. 👤 **service-user** – Gestión de usuarios.
5. 📆 **service-date** – Gestión de fechas y disponibilidad.
6. 🛡️ **service-security** – Seguridad y autenticación.
7. 🧑‍💼 **service-employee** – Gestión de empleados.
8. 📅 **service-appointment** – Administración de turnos.
9. 🛎️ **service-services** – Gestión de servicios ofrecidos.

## 🛡️ Seguridad
El proyecto implementa una **doble validación de tokens**:  
- **En el Gateway** antes de permitir el paso.  
- **En cada microservicio** para evitar accesos directos indebidos.  
Además, utiliza **Refresh Tokens** para mantener sesiones seguras y **certificados SSL (.pem)** para cifrar la comunicación.

## 👨‍💻 Equipo de Desarrollo
Este proyecto está siendo desarrollado por un **equipo de 2 programadores** apasionados por crear software seguro, escalable y de alto rendimiento:
- **[Daniel Iwach](https://github.com/Daniel-iwach)** — Backend.  
- **[Ulises Gadea](https://github.com/UlisesGS)** — Backend.

## 📅 Estado del Proyecto
📌 **Fase:** Desarrollo Activo 🏗️  
🔄 Recibiendo constantes actualizaciones y mejoras.  
🛠️ Enfocado en flexibilidad, escalabilidad y seguridad.

---
💡 *Este software está diseñado para adaptarse a cualquier tipo de negocio o institución que requiera una gestión eficiente de turnos.*
