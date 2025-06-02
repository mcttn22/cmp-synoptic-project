[![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/en/)
[![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/)

# CMP Synoptic Project

## Installation

1. Create a personal access token:

    - Go to profile picture -> Settings -> Developer Settings -> Personal access tokens -> Tokens (classic) -> Generate new token -> Generate new token (classic)
    - Enter a note to remember it (eg: "repo")
    - Select the repo checkbox
    - Save the token with a password manager

2. Open a terminal and move to a location to clone the repository with the ```cd``` command

3. Clone the Repository with:

    - ```
      git clone https://{Your GitHub username}:{Your personal access token}@github.com/mcttn22/cmp-synoptic-project.git
      ```

4. Enter the project directory with:

    - ```
      cd cmp-synoptic-project
      ```

5. Configure your user details with:

    - ```
      git config user.name "{Your name}";
      git config user.email {Your email};
      ```

6. Create keystore for HTTPS with:
   - Use Git Bash
   - ```
     openssl req -x509 -newkey rsa:2048 -keyout keytmp.pem -out cert.pem -days 365 -nodes;
     openssl rsa -in keytmp.pem -out key.pem;
     openssl pkcs12 -export -out src/main/resources/keystore.p12 -inkey key.pem -in cert.pem
     ```
   - You will be prompted to fill in information for the certificate and a password for the key store, see the below demo:
     ![OpenSSL Demo](https://github.com/mcttn22/cmp-synoptic-project/blob/main/doc/openssl-demo.png?raw=true)

7. Add a src/main/resources/application.properties file with the following contents:
   - ```
     spring.application.name=synopticproject
     spring.datasource.url=jdbc:postgresql://localhost:5432/{Database Name}
     spring.datasource.username={Database Username}
     spring.datasource.password={Database Password}
     server.ssl.key-alias=1
     server.ssl.key-store=classpath:keystore.p12
     server.ssl.key-store-password={Keystore Password}
     server.ssl.key-store-type=PKCS12
     ```

## Usage

Ensure the PostgreSQL server is running and the database is setup (if not run the SQL in setup_database.sql)

Start the web server with:
- ```
  mvn spring-boot:run
  ```
- The website will then be hosted at ```https://localhost:8080```
  *Note: You will have to click through some options to accept the risk that we're self certificated*

## Development

Run tests with:
- ```
  mvn test
  ```

General:
- Use ```git status``` to see the current status of your local repository (changes, what branch you're on etc)
- Use ```git pull origin main``` to merge the origin's (the GitHub repository) main branch with your local one (make sure youre on the main branch first) (downloads most recent changes), should do this regularly

Adding new features:
- Create and enter a new branch with ```git checkout -b feature/{feature name}``` *- Note: use hyphens instead of spaces for feature name*
- After making a change, use ```git status``` to see what files are affected, then use ```git add {file1|dir1 file2|dir2 ...}``` to stage the changes
- Commit your staged changes with ```git commit -m "{message describing changes}"```
- Save these changes to the GitHub repository with ```git push -u origin feature/{feature name}```
- When a feature is implemented, go to the GitHub repository, select the branch -> Contribute -> Open pull request, fill in the details and then click Complete pull request

Extra:
- See what branches exist with ```git branch```
- Undo the last commit with ```git reset --soft HEAD~1```
- Solve merge conflicts by editing the conflicted files and removing one of the conflicting blocks
- You could use conventional commit messages like "feat: ..." or "chore: ..." etc, see [here](https://www.conventionalcommits.org/en/v1.0.0/) for more info

