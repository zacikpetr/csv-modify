# CSV Modify – Task solution

>This example is Task solution, not the best solution and it covers all task requirements.

Spring Boot application uses REST API to modify CSV file in TMP directory. CSV file is only source of truth for
all systems, so it is not cached or moved into memory or database.

## API
To add a new record into CSV library, call:
```http request
GET http://localhost:8080/api/contact?firstName=Franta&lastName=Novák&email=franta.novak@email.cz
```
See `http/contact.http` in project structure.

>Note that GET should never be used in real world solution to insert records. GET should be used
>to obtain records. To insert new entry, you should use POST method instead.

## CSV
File named `contacts.csv` is stored at `System.getProperty("java.io.tmpdir")`
If there is no file, it will be created.

## Prerequisities
* Java 11 is needed to build and run application. Gradle is not required as it is provided embedded in application as wrapper.
