# kafka-quarkus Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the Docker

Necessary to have docker and docker compose installed on the machine!

Run the command to upload the docker:

docker-compose up -d

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

mvn quarkus:dev


## Running application with Postman

Run a POST on Postman with the URL: localhost:8081/kafka , with the model JSON:

{
    "year":1994, 
    "title":"title"
}
