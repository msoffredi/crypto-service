Assumptions

1. Input numbers are within Java int data type (-2,147,483,648 to 2,147,483,647)

Decisions

1. Leave deviation output as a standard Java double data type. It could be formatted 
into a fixed number of decimals later.
2. Keeping API endpoints simple for the sake of time (following API Names on requirements)
3. Output will be a JSON object
4. API will be a standard REST API

Notes & References

1. To solve the standard deviation in an incremental way I did a bit of research and 
ended up implementing a solution based on Welford's variance algorithm
2. For the Symmetric Encryption I Adapted the AES implementation from 
https://howtodoinjava.com/java/java-security/java-aes-encryption-example/
3. Since dropwizard implements a multi-thread API, I went with a thread-safe singleton
for the mean and standard deviation calculations

Running instructions

The application requires Java 1.8+ and Maven 4.0+.

Build the application package with the following command in your cli: 

mvn package


Run the application with the following cli command: 

java -jar target/crypto-service-1.0-SNAPSHOT.jar server config.yml


Testing the application

To test the application you need to use an application or tool that will allow you to make 
standard API calls (POST requests) like curl or Postman. All three endpoints will use JSON 
as the standard input and out format, so a standard 'Content-Type: application/json' is 
required (and submitted with responses).

All endpoints are accessible locally at: http://localhost:8080


PushAndRecalculate endpoint

API endpoint for testing: http://localhost:8080/push-and-recalculate
Method: POST
Body (parameters in JSON): number as an integer (e.g. { "number": 123 })

Example with curl:

curl -X POST http://localhost:8080/push-and-recalculate -d '{"number":123}' -H "Content-Type: application/json"


Output:

{"avg":123.0,"dev":0.0}

