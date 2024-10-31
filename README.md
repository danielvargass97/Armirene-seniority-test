# Armirene-seniority-test
# Guía de Instalación

Sigue estos pasos para configurar y ejecutar el proyecto:

1. Instalar PostgreSQL e importar la base de datos
2. Clonar el repositorio del backend y ejecutarlo.
3. Clonar el repositorio del front y ejecutarlo.

# 1. Instrucciones para Instalar PostgreSQL e Importar la Base de Datos

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
   - Asegúrate de que el archivo de respaldo de la base de datos (`employees_backup.sql`) esté en una ubicación accesible. Este archivo esta en la carpeta raíz de este repositorio.

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
# 2. Clonar y Ejecutar el Proyecto de Spring Boot

1. **Clonar el repositorio:**
   Abre la terminal y ejecuta el siguiente comando para clonar el repositorio:
   ```bash
   git clone https://github.com/danielvargass97/Armirene-seniority-test.git
   ```
2. **Navegar al directorio del proyecto**: Cambia al directorio del proyecto clonado:
   ```
   cd <NOMBRE_DEL_DIRECTORIO_DEL_PROYECTO>
   ```
3. **Instalar dependencias**: Asegúrate de tener Maven instalado en tu máquina. Luego, ejecuta el siguiente comando para descargar las dependencias del proyecto:
   ```
   mvn clean install
   ```
4. **Configurar el archivo de propiedades**: Abre el archivo application.properties o application.yml en el directorio src/main/resources y ajusta la configuración de conexión a la base de datos según sea necesario (Si se realiza el numeral anterior no es necesario cambiar nada aqui).

5. **Ejecutar el proyecto**: Inicia la aplicación ejecutando el siguiente comando:
   ```
   mvn spring-boot:run
   ```
6. **Probar los endpoints**: Una vez que la aplicación esté en ejecución, puedes probar los endpoints utilizando herramientas como Postman o directamente en tu navegador. Hay una colección con las request organizadas en la raíz de este proyecto. (Armirene seniority test.postman_collection.json)

# 3. Clonar y Ejecutar el Proyecto de Flutter
Sigue las instrucciones en el readme de este repositorio https://github.com/ARMIRENE-Daniel-Vargas/rrhh-app
