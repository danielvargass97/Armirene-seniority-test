# Armirene-seniority-test

# Guía de Instalación

Sigue estos pasos para configurar y ejecutar el proyecto:

1. [Instalar PostgreSQL e importar la base de datos](#instalar-postgresql-e-importar-la-base-de-datos)
2. Clonar el repositorio del backend e instalar las dependencias.
3. Configurar el archivo de propiedades para la conexión a la base de datos.
4. Ejecutar el backend y probar los endpoints.

# Instrucciones para Instalar PostgreSQL e Importar la Base de Datos

## Instalación de PostgreSQL

1. **Descargar PostgreSQL**:
   - Visita la [página de descarga de PostgreSQL](https://www.postgresql.org/download/).
   - Selecciona tu sistema operativo (por ejemplo, macOS) y sigue las instrucciones para instalarlo.

2. **Instalar PostgreSQL**:
   - Abre el archivo descargado y sigue las instrucciones del asistente de instalación.
   - Durante la instalación, se te pedirá que configures una contraseña para el usuario `postgres`. Recuerda esta contraseña, ya que la necesitarás más adelante.

3. **Verificar la Instalación**:
   - Abre la terminal y ejecuta el siguiente comando para verificar que PostgreSQL se ha instalado correctamente:
     ```bash
     psql --version
     ```

## Importar la Base de Datos

1. **Colocar el Archivo de Respaldo**:
   - Asegúrate de que el archivo de respaldo de la base de datos (`employees_backup.sql`) esté en una ubicación accesible. Por ejemplo, puedes colocarlo en tu carpeta de usuario.

2. **Abrir la Terminal**:
   - Abre la terminal en tu Mac.

3. **Conectarse a PostgreSQL**:
   - Ejecuta el siguiente comando para conectarte a PostgreSQL como el usuario `postgres`:
     ```bash
     psql -U postgres
     ```
   - Cuando se te pida, ingresa la contraseña que configuraste durante la instalación.

4. **Crear la Base de Datos**:
   - Una vez dentro de la consola de PostgreSQL, ejecuta el siguiente comando para crear la base de datos `employees`:
     ```sql
     CREATE DATABASE employees;
     ```

5. **Salir de PostgreSQL**:
   - Puedes salir de la consola de PostgreSQL escribiendo:
     ```sql
     \q
     ```

6. **Importar la Base de Datos**:
   - En la terminal, ejecuta el siguiente comando para importar la base de datos desde el archivo de respaldo:
     ```bash
     psql -U postgres -d employees -f /ruta/a/tu/archivo/employees_backup.sql
     ```
   - Asegúrate de reemplazar `/ruta/a/tu/archivo/employees_backup.sql` con la ruta completa al archivo de respaldo.

7. **Verificar la Importación**:
   - Vuelve a conectarte a PostgreSQL y verifica que la base de datos se haya importado correctamente:
     ```bash
     psql -U postgres -d employees
     ```
   - Una vez dentro, puedes listar las tablas con:
     ```sql
     \dt
     ```
