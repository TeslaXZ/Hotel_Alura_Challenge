# Hotel Alura - Aplicación de Gestión de Reservas y Huéspedes

Este es un proyecto de muestra de una aplicación de gestión de reservas y huéspedes desarrollada con Java utilizando el framework JPA (Java Persistence API) y una base de datos SQL.

## Clases y Funcionalidades Principales

### `Huesped`

- **Package:** `com.latam.alura.hotel.modelo`
- **Descripción:** Clase que representa a un huésped. Contiene atributos como nombre, apellido, fecha de nacimiento, nacionalidad, teléfono y una relación con la entidad `Reserva`.

### `Reserva`

- **Package:** `com.latam.alura.hotel.modelo`
- **Descripción:** Clase que representa una reserva. Contiene atributos como fecha de ingreso, fecha de salida, valor y forma de pago. También tiene una relación con la entidad `Huesped` usando la anotación `@OneToMany`.

### `Usuario`

- **Package:** `com.latam.alura.hotel.modelo`
- **Descripción:** Clase que representa a un usuario del sistema. Contiene atributos como nombre, usuario, contraseña y una relación con la entidad `NivelDeAcceso`.

### `NivelDeAcceso`

- **Package:** `com.latam.alura.hotel.modelo`
- **Descripción:** Clase que representa el nivel de acceso de un usuario. Contiene un atributo `rol` para describir el nivel.

### `HuespedDAO`

- **Package:** `com.latam.alura.hotel.dao`
- **Descripción:** Clase encargada de realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la entidad `Huesped`. Proporciona métodos para guardar, listar, modificar, eliminar y buscar huéspedes por número de reserva o apellido.

### `ReservaDAO`

- **Package:** `com.latam.alura.hotel.dao`
- **Descripción:** Clase encargada de realizar operaciones CRUD en la entidad `Reserva`. Proporciona métodos para guardar, listar, modificar, eliminar y buscar reservas por apellido de huésped o por su ID.

### `NivelDeAccesoDAO`

- **Package:** `com.latam.alura.hotel.dao`
- **Descripción:** Clase encargada de realizar operaciones CRUD en la entidad `NivelDeAcceso`. Proporciona métodos para listar niveles de acceso y ejecutar una consulta especial para crear registros iniciales si es la primera ejecución.

### `UsuarioDAO`

- **Package:** `com.latam.alura.hotel.dao`
- **Descripción:** Clase encargada de realizar operaciones relacionadas con la entidad `Usuario`. Proporciona métodos para crear nuevos usuarios, autenticar usuarios y verificar si es la primera vez que se ejecuta la aplicación.

### `JPAutils`

- **Package:** `com.latam.alura.hotel.utils`
- **Descripción:** Clase utilitaria para obtener un `EntityManager` de JPA. Facilita la conexión con la base de datos.

## Controladores

### `HuespedController`

- **Package:** `com.latam.alura.hotel.controller`
- **Descripción:** Controlador que gestiona las operaciones relacionadas con la entidad `Huesped`, como guardar, listar, modificar, eliminar y buscar por número de reserva o apellido.

### `ReservaController`

- **Package:** `com.latam.alura.hotel.controller`
- **Descripción:** Controlador que gestiona las operaciones relacionadas con la entidad `Reserva`, como guardar, listar, modificar, eliminar y buscar por apellido de huésped o por su ID.

### `NivelDeAccesoController`

- **Package:** `com.latam.alura.hotel.controller`
- **Descripción:** Controlador que gestiona las operaciones relacionadas con la entidad `NivelDeAcceso`, como listar niveles y ejecutar una consulta especial para crear registros iniciales si es la primera ejecución.

### `UsuarioController`

- **Package:** `com.latam.alura.hotel.controller`
- **Descripción:** Controlador que gestiona las operaciones relacionadas con la entidad `Usuario`, como crear nuevos usuarios, autenticar usuarios y verificar si es la primera vez que se ejecuta la aplicación.

¡Disfruta explorando y utilizando esta aplicación de gestión de reservas y huéspedes!
