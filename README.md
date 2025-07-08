[![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/en/)
[![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/)
[![PostgreSQL](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)

# CMP Synoptic Project

Group project designed and developed for Engineering for People Design Challenge. This project aims to facilitate an increase in access to sanitation resources in a third-world setting, by implementing an Internet of Things toilet monitoring system reporting on condition and compost toilet capacity utilisation.

## Installation

1. Download the Repository with:
    - ```
      git clone https://github.com/mcttn22/cmp-synoptic-project.git
      ```
    - Or by downloading as a ZIP file

2. Enter the project directory with:
    - ```
      cd cmp-synoptic-project
      ```

3. Create a keystore for HTTPS with the following:
   - ```
     openssl req -x509 -newkey rsa:2048 -keyout keytmp.pem -out cert.pem -days 365 -nodes;
     openssl rsa -in keytmp.pem -out key.pem;
     openssl pkcs12 -export -out src/main/resources/keystore.p12 -inkey key.pem -in cert.pem
     ```
   - You will be prompted to fill in information for the certificate and a password for the keystore. See the below demo:
     ![OpenSSL Demo](https://github.com/mcttn22/cmp-synoptic-project/blob/main/doc/openssl-demo.png?raw=true)

4. Setup the database with:
   - ```psql -U postgres postgres```
   - Once in the command line interface, enter ```\i SQL_DDL.sql```
   - Then enter ```COMMIT;``` to commit the changes
   - Then enter ```\q``` to exit the command line interface

5. Add a file called application.properties to src/main/resources/, with the following contents:
   - ```
     spring.application.name=synopticproject
     server.port=8443
     spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
     spring.datasource.username=postgres
     spring.datasource.password={Database Password}
     server.ssl.key-alias=1
     server.ssl.key-store=classpath:keystore.p12
     server.ssl.key-store-password={Keystore Password}
     server.ssl.key-store-type=PKCS12
     ```

## Usage

Start the web server with:
- ```
  mvn spring-boot:run
  ```
- The website will then be hosted at ```https://localhost:8443```
  *Note: You will have to click through some options to accept the risk that we're self certificated*

## Development

Run tests with:
- ```
  mvn test
  ```

