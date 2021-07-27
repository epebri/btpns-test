# technical test btpns

- Entity Relationship Diagram

![ERD](/img/erd.png)

- Class Diagram

![Class Diagram](/img/class-diagram.png)

- Api Specification [[link]](https://documenter.getpostman.com/view/4795674/TzsZsUEk)


- How to build apps as image container.

1. Build apps as jar file.

please run this command before build apps as image container.

```./mvnw clean install```

2. Build apps

```docker build --tag spring-api-backend:0.0.1 .```


- Build apps with docker compose

you can build easily container with this command

```docker-compose up --build```

