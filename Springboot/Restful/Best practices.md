Best practices for building RESTful resources 

1. Use Nouns for Resource Paths
2. Use HTTP Methods Correctly
3. Request Mapping
4. Versioning
4. Use of HTTP Response Codes
5. Content Negotiation
6. Pagination and Sorting
7. Error Handling @ControllerAdvice
8. Input Validation @Valid
9. Security
10. Documentation

BEST PRACTICES FOR USING RESPONSE CODES EFFECTIVELY:

200: Successful request, standard response for successful HTTP requests.
201: Resource created, successful creation of a new resource.
204: No content, successful request without returning any content.
400: Bad request, client error due to invalid syntax or parameters.
401: Unauthorized, authentication required or failed.
403: Forbidden, client lacks permission to access resource.
404: Not found, requested resource not found on the server.
500: Internal server error, server encountered an unexpected condition.
503: Service unavailable, server unable to handle the request temporarily.




HERE ARE SOME COMMON ATTACKS ON RESTFUL RESOURCES:

1. SQL Injection: Injecting malicious SQL queries through API parameters.

2. Cross-Site Scripting (XSS): Injecting malicious scripts into responses.

3. Cross-Site Request Forgery (CSRF): Executing unauthorized commands on behalf of a user.


4. XML External Entity (XXE) Injection: Exploiting vulnerable XML parsers.


5. JSON Hijacking: Stealing sensitive data by accessing JSON responses.

6. API Rate Limiting Bypass: Overwhelming API servers by bypassing rate limits.

7. Insecure Direct Object References (IDOR): Accessing unauthorized resources by manipulating identifiers.

8. Parameter Tampering: Altering API parameters to gain unauthorized access or escalate privileges.

9. Broken Authentication: Exploiting flaws in authentication mechanisms.

10. Denial of Service (DoS): Overloading API servers with excessive requests.
