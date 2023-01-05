# attornatus-test

## Get Started

1. Clone the repository

    * _SSH_

        ```bash
        git clone git@github.com:LucasVmigotto/attornatus-test.git
        ```

    * _HTTPS_

        ```bash
        git clone https://github.com/LucasVmigotto/attornatus-test.git
        ```

    * GitHub CLI

        ```bash
        gh repo clone LucasVmigotto/attornatus-test

2. Copy and rename `.env.sample` to `.env`

    > Customize the values as needed

3. Customize, if needed, the values in `src/main/resources/application.properties`

4. Prepare and initialize the [Docker](https://www.docker.com/) environment

    1. Start the API Docker Compose Service

        ```bash
        docker compose run --rm at-api bash
        ```

    2. Once inside the container, install the [Maven](https://maven.apache.org/) dependencies

        ```bash
        ./mvnw dependency:go-offline
        ```

    3. Exit the container

        ```bash
        exit
        ```

5. Start the services

    * [H2 Database](https://www.h2database.com/html/main.html)

        ```bash
        docker compose up [-d] at-h2
        ```

    * _API_

        ```bash
        docker compose up [-d] at-api
        ```

    > Use the `-d` flag to run the containers in detach mode
        ```

* You can use the [Postman](https://www.postman.com/) collection in `docs/postman.json` to test and see the request body payload structure.
