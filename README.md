#ArticlesApi:

Narzędzia:

java - jdk1.8.0_172

maven - 3.3.9

Docker - Version 18.03.1-ce-win65 (17513)  (build na linux)

-------------------------------------------------------------
#Uruchamianie projektu:

1..
instalacja pluginu do lomboka:
IntelliJ:
`https://plugins.jetbrains.com/plugin/6317-lombok-plugin`

2..
`mvn clean install` w katalogu z pom.xml

3.. Stworzenie domyślnej konfiguracji springboot (wskazać pl.dragdrop.articles.Application)

-------------------------------------------------------------
#Tworzenie instancji na dockerze:

1.. Najlepiej najpierw pobrać openjdk:8-jdk-alpine na dokerze
, tworzymy dockerowy obraz - katalog z Dockerfile:
`mvn install dockerfile:build`

2..Uruchamiamy obraz: `docker run -p 8888:8888 <id obrazu>`

-------------------------------------------------------------
#Dokumentacja REST:
`localhost:8888/swagger-ui.html`