# microservices-security
![Diagram](/Cloud%20Security%20Diagram.png)

Some points that I think worth looking at

# Auth-Server
* Simple OAuth2 Server that support custom UserDetails
# Gateway ( Zuul Proxy ) 
* Bean `OAuth2RestOperations` is needed [to support refresh token](https://stackoverflow.com/questions/44668345/enableoauth2sso-does-not-check-if-token-has-expired) .
* Custom Ribbon Server Filter that is needed to specify specific zones [for development purpose](https://stackoverflow.com/questions/44881018/set-a-list-of-acceped-zones-in-eureka)
* strip-prefix for the ui service should be set to false to support loading static resources wihtout any problem
# UI Service
* Support custom Principle
* server.context-path is mandatory to support static resources
# Task
* This represent a task like spring-cloud-task or spring-batch that is run either by cron or task launcher
* Bean `OAuth2FeignRequestInterceptor` is needed to inject Authorization header in feign requests
* It uses client_credentials as it is M2M 