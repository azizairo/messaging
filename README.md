# messaging - test project

Minmal [Spring Boot](http://projects.spring.io/spring-boot/) apss that use Kafka for communication

## Requirements
1. Java 17
2. Maven
3. Docker

## Configuring messaging-reciever

This service use GMAIL SMTP for sending email, so you have to configure your own username and password for your account in application.yml file.  

Properties to configure(Note that you have to use applcation password insted of using regular password):

```yml
mail:
  host: smtp.gmail.com
  port: 587
  username: username
  password: password
  to: recepient
```

## Running services locally

To run services locally you should do following steps:  
1. Clonse repository like so:

```shell
git clone https://github.com/azizairo/messaging.git
```
2. Move to directory where you cloned repository
3. Run command:

```shell   
docker-compose up -d
```

## Services Description

### Service for sending messages

Url: ```http://localhost:8080/api/v1/messages```  
Method: ```POST```  
Content-Type: ```application/xml```  

Request Body:  
```xml
<SendMessageRequest>
    <Sender>sender@gmail.com</Sender>
    <Message>message body 4</Message>
</SendMessageRequest>
```

### Service for get list of sent messages

Url: ```http://localhost:8080/api/v1/messages/{sender}```  
Method: ```GET```  
Content-Type: ```application/xml``` 

sender - is a path var. If not exists, return last 10 records.

### Service for get list of response for sent emails

Url: ```http://localhost:8081/api/v1/logs```  
Method: ```GET```  
Content-Type: ```application/json``` 
