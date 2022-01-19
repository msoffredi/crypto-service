Assumptions

1. Input numbers are within Java int data type (-2,147,483,648 to 2,147,483,647)

Decisions

1. Leave deviation output as a standard Java double data type. It could be formatted into a fixed number of decimals later.
2. Keeping API endpoints simple for the sake of time (following API Names on requirements)
3. Output will be a JSON object
4. API will be a standard REST API

Running instructions

The application requires Java 1.8+ and Maven 4.0+

Build the application package with: mvn package

Run the application with: java -jar target/crypto-service-1.0-SNAPSHOT.jar server config.yml
