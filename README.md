<h1 align="center">AMV</h1>
Dette er en prosjektoppgave i IS-200-1 og IS-201-1 (Programmeringsprosjekt). Vi har fått i oppgave å lage et leie-system for ansatte i Andersen Mekaniske Verksted (AMV). Prosjeket skal resultere i en web-applikasjon som skal kjøre internt hos AMV.

### Oppsett

##### Kompilerer kildekoden til tomcat docker container:
|Bash (Mac/Linux)|Powershell (Windows)|
|--------------------|--------------------|
|`docker run --rm -it --name mavenbuild -v maven-repo:/root/.m2 -v "$(pwd)":/usr/src/mymaven -w /usr/src/mymaven maven mvn clean install` | `docker run --rm -it --name mavenbuild -v maven-repo:/root/.m2 -v "%cd%":/usr/src/mymaven -w /usr/src/mymaven maven mvn clean install`|


##### 2. Bygg prosjektet og start docker container med web-applikasjonen:
`docker image build -t trym/tomcat .`    
`docker container run --rm -it -d --name tomcat --publish 8081:8080 trym/tomcat`

##### 3. Start mariadb container:

|Bash (Mac and Linux)|Powershell (Windows)|
|--------------------|--------------------|
|`docker run --rm --name mariadb -p 3308:3306/tcp -v "$(pwd)/database":/var/lib/mysql -e MYSQL_ROOT_PASSWORD=12345 -d mariadb:10.5.11`|`docker run --rm --name mariadb -p 3308:3306/tcp -v "%cd%\database":/var/lib/mysql -e MYSQL_ROOT_PASSWORD=12345 -d mariadb:10.5.11`|

##### 4. Gå inn i database og opprett en database for prosjektet:
`docker exec -it mariadb mysql -p`