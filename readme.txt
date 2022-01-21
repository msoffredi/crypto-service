Assumptions

1. While my input numbers can be float numbers within the Java double data type
   limits, I'm assuming they wong't be bigger than Java int data type limits 
   (-2,147,483,648 to 2,147,483,647)


Decisions

1. Leave average and standard deviation output as a standard Java double data types. 
   It could be formatted into a fixed number of specific number of decimals later.
2. Keeping API endpoints simple for the sake of time (following API Names on requirements)
3. Output will be a JSON object
4. API will be a standard REST API
5. Not a lot of work on the error handling and validations
6. I did not validated the upper limit for input numbers


Notes & References

1. To solve the standard deviation in an incremental way I did a bit of a research and 
   ended up implementing a solution based on Welford's variance algorithm
2. For the symmetric encryption I adapted the AES implementation from 
   https://howtodoinjava.com/java/java-security/java-aes-encryption-example/
3. Since dropwizard implements a multi-threaded API, I went with a thread-safe singleton
   for the mean and standard deviation calculations (to safely carry over some results)
4. The encryption key is in the configuration file (config.yml) but should be moved to
   a secured store (secret manager like Vault).
5. The errors output could be standardized
6. All endpoints should be under a strong SSL
7. API should be documented using a standard API documentation (like OpenAPI 3.0)
8. I included an exported simple Postman collection (v2.0) for testing endpoints 
   locally. It's in /extras folder.
9. Some more strict validations should be added for API input parameters
   (for example the max number allowed). Found ways to do this but did not feel
   confident enough to try it out given the time constrains and my lack of 
   experience with Java (and Java libraries).
10.PushAndRecalculate and PushRecalculateAndEncrypt share some core operation of pushing 
   and recalculating, and could be extracted for consistency. 


Building and running the application

The application requires Java 1.8+ and Maven 4.0+.
Build the application package with the following command in your cli: 

mvn package


Run the application with the following cli command: 

java -jar target/crypto-service-1.0-SNAPSHOT.jar server config.yml


Accessing application endpoints locally

To access the endpoints locally you need to use an application or tool that allows you 
to make standard API calls (POST requests) like curl or Postman. All three endpoints will 
use JSON as the standard input and out format, so a standard 'Content-Type: application/json' 
is required (and submitted with responses).

All endpoints are accessible locally at: http://localhost:8080


PushAndRecalculate endpoint

API endpoint for testing: http://localhost:8080/push-and-recalculate
Method: POST
Body (parameters in JSON): number as an integer (e.g. { "number": 123 })

Example with curl:

curl -X POST http://localhost:8080/push-and-recalculate \
    -d '{"number":123}' \
    -H "Content-Type: application/json"


Output:

{
    "avg": 123.0,
    "stdDev": 0.0
}


PushRecalculateAndEncrypt endpoint

API endpoint for testing: http://localhost:8080/push-recalculate-and-encrypt
Method: POST
Body (parameters in JSON): number as an integer (e.g. { "number": 123 })

Example with curl:

curl -X POST http://localhost:8080/push-recalculate-and-encrypt \
    -d '{"number":4}' \
    -H "Content-Type: application/json"


Output:

{
    "encryptedAvg": "W7+AeY5oqQgkfMYYPw6/FQ==",
    "encryptedStdDev": "MHRlun3faPuO8ua+Gc0z/g=="
}


Decrypt endpoint

API endpoint for testing: http://localhost:8080/decrypt
Method: POST
Body (parameters in JSON): encryptedNumber as a string 
(e.g. { "encryptedNumber": "W7+AeY5oqQgkfMYYPw6/FQ==" })

Example with curl:

curl -X POST http://localhost:8080/decrypt \
    -d '{"encryptedNumber":"W7+AeY5oqQgkfMYYPw6/FQ=="}' \
    -H "Content-Type: application/json"


Output:

{
    "number": 4.0
}

Note: Decrypt output will always be float number (double in Java)
