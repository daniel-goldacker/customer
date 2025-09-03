# customer

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: [https://quarkus.io/](https://quarkus.io/).

## Project premise

* Execute command in Docker to install PostgreSQL:

```shell
docker run --rm -it -p 5432:5432 -e POSTGRES_PASSWORD=admin -e POSTGRES_USER=admin -e POSTGRES_DB=customerdb postgres
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell
./mvnw quarkus:dev
```

> ***NOTE:*** Quarkus now ships with a Dev UI, which is available in dev mode only at [http://localhost:8083/q/dev/](http://localhost:8083/q/dev/).

## Packaging and running the application

The application can be packaged using:

```shell
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an *über-jar* as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using:

```shell
java -jar target/quarkus-app/quarkus-run.jar
```

If you want to build an *über-jar*, execute:

```shell
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an *über-jar*, is now runnable using:

```shell
java -jar target/*-runner.jar
```

## Creating a native executable

You can create a native executable using:

```shell
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can build the native executable in a container:

```shell
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with:

```shell
./target/customer-1.0.0-SNAPSHOT-runner
```

If you want to learn more about building native executables, please consult [https://quarkus.io/guides/maven-tooling](https://quarkus.io/guides/maven-tooling).

## Building the Docker Image and Running with Docker Compose

You can build the application Docker image and run it together with the database using Docker Compose.

### 1. Build the Docker image

Execute the following command in the project root:

```shell
./mvnw clean package -Dquarkus.container-image.build=true -DskipTests
```

> ***NOTE:*** This will build the application Docker image without running the tests.

### 2. Run the application with Docker Compose

Once the image is built, start the containers:

```shell
docker-compose up
```

This will start both the `app` and `db` services defined in your `docker-compose.yml`.

* The app will be available at `http://localhost:8083`
* The database will be running on the network `docker-db-test` with:

  * **Username:** admin
  * **Password:** admin
  * **Database:** customerdb

### 3. Stop the containers

To stop and remove the containers:

```shell
docker-compose down
```

> ⚠️ If you want to remove the database volume as well, use `docker-compose down -v`.

## Related Guides

* REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it
* Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
* JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

[Related Hibernate with Panache section...](https://quarkus.io/guides/hibernate-orm-panache)

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
