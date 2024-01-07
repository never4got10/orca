# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.6/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.6/gradle-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.7.6/reference/htmlsingle/#using.devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.6/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring for RabbitMQ](https://docs.spring.io/spring-boot/docs/2.7.14/reference/htmlsingle/index.html#messaging.amqp)
* [Spring web](https://docs.spring.io/spring-boot/docs/2.7.14/reference/htmlsingle/index.html#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Scheduling Tasks](https://spring.io/guides/gs/scheduling-tasks/)
* [Consuming a RESTful Web Service](https://spring.io/guides/gs/consuming-rest/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Uploading Files](https://spring.io/guides/gs/uploading-files/)
* [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)
* [Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)
* [Validating Form Input](https://spring.io/guides/gs/validating-form-input/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Messaging with JMS](https://spring.io/guides/gs/messaging-jms/)
* [Creating a Batch Service](https://spring.io/guides/gs/batch-processing/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Converting a Spring Boot JAR Application to a WAR](https://spring.io/guides/gs/convert-jar-to-war/)
* [Creating Asynchronous Methods](https://spring.io/guides/gs/async-method/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Building a Hypermedia-Driven RESTful Web Service](https://spring.io/guides/gs/rest-hateoas/)
* 
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### 설명 & Setting
#### Securing a Web Application
- Dependency
  - implementation : org.springframework.boot:spring-boot-starter-web
  - implementation : org.springframework.boot:spring-boot-starter-thymeleaf
  - implementation : org.springframework.boot:spring-boot-starter-security
  - implementation : org.thymeleaf.extras:thymeleaf-extras-springsecurity6:3.1.1.RELEASE
  - testImplementation : org.springframework.security:spring-security-test
- Web Security config 정의 
  - @EnableWebSecurity 선언 : Spring Security Web 을 활성화 및 Spring MVC integration 지원
  - Web Security Configuration의 bean 노출 시킴
  - SecurityFilterChain Bean 은 Secured와 그렇지 않는 URL Path 를 정의 
  - login 페이지에서 오류가 발생하면 '/login?error' 로 logout이 되면 '/login?logout' 로 보내짐
  - hello.html 에 로그인한 사용자 이름과 logout 정보를 표시
- #### Testing the Web Layer
- Controller Test 에서 @SpringBootTest 를 선언하면 Context가 load 되며 @Autowired 정의한 HelloController에 자동 주입됨
- Spring Test는 tests 들 간에 Application  Context가 캐싱이 됨.
- 따라서 동일한 구성을 가진 여러 번의 테스트 케이스나 테스트 케이스의 여러 개의 메소드가 있을 경우, 한 번의 어플리케이션 기동으로 다 커버됨
- @DirtiesContext 어노테이션으로 캐쉬를 제어할 수 있음 
- 테스트
  - ApplicationContext에서 Controller 상태를 조회 : HomeControllerTest
  - 연결을 하고 HTTP 요청을 송신하고 응답을 수신받는 테스트도 진행 가능 : HttpRequestTest
  - 서버 기동을 안 하고 mock 객체를 사용하여 테스트 하는 방법
  - @WebMvcTest 로 WebLayer 만 테스트 하는 방법도 사용

#### Messaging with redis
- Redis 설치 : redis는 Windows 에서 WSL2 에 Redis Server 설치 지원(linux/unix 호환)
  - 간단한 테스트를 위해 https://github.com/microsoftarchive/redis/releases 에서 제공하는 윈도우 설치본 사용
  - redis-server로 실행 port 6376 으로 서비스
- Redis 서버 종료
  - redis-cli 실행 후 shutdown 입력
- Spring Boot Dependency 추가
  - implementation : org.springframework.boot:spring-boot-starter-data-redis
- Redis 에 메시지를 전송하고 수신하는 컴포넌트는 Spring Data Redis 에서 지원
  - A connection Factory
  - A message Listener Container
  - A Redis Template
- Redis Template 로 message 전송, message를 수신 받기 위해 Receiver와 함꼐 Message Listener Container 를 등록
- Connection Factory는 Redis Template 와 Message Listener Container를 Redis Server와 연결하도록 해줌
- Spring Boot의 기본 RedisConnectionFactory는 JedisConnectionFactory의 인스턴스임

#### Messaging with RabbitMQ
- RabbitMQ 설치
  - chobo install rabbitmq -y --install-arguments="'/DIR=D:\devtools\server\rabbitmq'"
  - 설치 결과 --install-arguments 적용 안 됨(C:\Program Files\RabbitMQ Server 경로에 설치됨)
  - Windows 에서 설치 즉시 service 시작됨(Default port 5672)
- Spring Boot Dependency
  - implementation : org.springframework.boot:spring-boot-starter-amqp
  - testImplementation : org.springframework.amqp:spring-rabbit-test
- RabbitTemplate은 RabbitMQ에 메시지를 송수신할 수 있도록 해줌
- 그러나, RabbitTemplate을 사용하여 송수신하지 않고 수신시는 MessageListenerContainer 를 구현하여 설정
- 구현 순서
  1. Queue 정의
  2. exchange 정의
  3. Queue 와 exchange 바인딩
  4. ListenerContainer 정의 
  5. ListenerAdapter 설정
- Listener를 테스트하기 위해 메시지를 전송하는 Component 구현 (Application 구동시 실행하도록 CommandLineRunner 를 구현하고 class 에 @Component 정의 )
- 메시지 전송시 queue가 아닌 exchage 로 송신 
  - 개념 : AMQP Producer는 직접 queue에 메시지를 보내지 않고 exchange로 보냄. exchange는 하나의 queue 또는 여러 개의 queue로 전송
- exchange와 queue 를 'foo.bat.$' 이라는 routing key로 바인딩함. 이는 'foo.bar' 로 시작되는 routing key 를 가진 모든 메시지는 바인딩된 queue로 라운팅됨

#### Messaging with JMS
- Spring Boot Dependency
  - implementation : org.springframework.boot:spring-boot-starter-artemis
  - implementation : org.springframework.boot:spring-boot-starter-json
  - runtimeOnly : org.apache.activemq:artemis-jakarta-server
- JmsReceiver 정의
  - annotation @JmsListener 정의
  - background 에서 JmsListenerContainer 생성됨
- JMS Config 정의
  - JmsListenerContainerFactory 및 JmsListenerContainerFactoryConfigurer 정의
- JMS Sending 정의
  - CommandLineRunner 를 사용하여 SpringBootApplication 구동시 실행하도록 구현
  - JmsTemplate 를 사용하여 JMS destination에 Mail 전송
- 기본 MessageConverter를 기본 유형(String, Map, Serializable)만 변환할 수 있고 Mail 같은 객체는 Serializable 할 수 없음 
  - Jackson을 사용하여 text 형식으로 Mail 내용을 JSON 으로 Serialize하기 위해 message converter를 정의하고 이를 JMSTemplate과 JmsListenerContainerFactory 연결
  - Json Converter를 사용하기 위해 spring-boot-starter-json dependency가 필요
- JMSTemplate과 ConnectionFactory는 Spring Boot 에 의해 자동 생성됨
- JMS infrastructure 가 사용 가능할 때 JmsListener 정의된 메소드를 자동으로 발견함 - @EnableJms를 추가할 필요 없음

#### Handling Form Submission
- Spring Boot Dependency
  - Spring Web, Thymeleaf
- GET, POST 등으로 Form Submit 처리 예제

#### Managing Transaction
- Spring Boot Dependency
  - implementation : org.springframework.boot:spring-boot-starter-data-jdbc
- @TRansactional 을 선언한 메소드 정의 - 여러 개를 입력하는 쿼리문에서 하나라도 실패하면 전체 롤백 처리
- src/main/resources/schema.sql : 테이블 정의 DDL
- Spring Boot Application 구동시 데이터 입력하는 CommandLineRunner 구현
  - 정상 데이터 입력, 예외 데이터 입력 - transaction rollback 발생하도록 구현
- BookingService의 메소드의 @Transactional 이 있고 없고 차이가 큼
  - @Transactional 있는 경우, 여러 개 입력시 하나라도 오류가 발생하면 전체 rollback 처리
  - @Trasactional 없는 경우, 여러 개 입력시 하나가 오류가 발생하면 오류가 발생한 건만 오류 처리, 나머지 건은 정상 입력

#### Converting a Spring Boot JAR Application to a WAR
- gradle plugin 에 id 'war' 추가
- Spring Boot Dependency
  - providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
- gradle bootWar로 실행 (war 로 Build 시에는 plain.war 가 생성됨)

#### Building a Hypermedia-Driven RESTful Web Service
- HATEOAS : Hypermedia As The Engine Of Application State( 하이퍼미디어를 어플리케이션의 상태를 관리하기 위한 메커니즘으로 사용)
- REST API를 사용하는 클라이언트가 전적으로 서버와 동적인 상호 작용이 가능하도록 하는 것을 의미
- 요청에 필요한 URI를 응답에 포함시켜 반환하는 것도 가능
- REST API : Representational State Transfer API (웹 어플리케이션이 제공하는 각각의 데이터를 리소스, 즉 자원으로 간주하고 각각의 자원에 고유한 URI를 할당함으로써 이를 표현하는 API를 정의하기 위한 소프트웨어 아키텍처 스타일)
- 잘 설계된 REST API를 구현하기 위한 단계 : The Swamp of POX -> Resources -> Http Verbs -> Hypermedia Controls
- 설계 3레벨 : HATEOAS 라는 용어가 도입됨. 리소스에 하이퍼미디어를 도입. 이를 통해 가능한 작업에 대해 알려 주는 응답에 링크를 배치할 수 있으므로 API를 통해 탐색할 수 있는 가능성이 추가됨
- Spring Boot Dependency
  - implementation : org.springframework.boot:spring-boot-starter-hateoas
- HETEOAS 구현
  - RepresentationModel 을 상속 받아 구현(GoodMorning.java)
  - 메소드를 가르키는 링크 생성과 이를 RepresentationModel에 추가하는 방법 : WebMvcLinkBuilder의 linkTo() 와 metodOn() 는 controller의 메소드를 검사해서 메소드가 매핑되는 URI를 정확하게 매핑
  - withSelfRel()을 호출하면 GoodMorning의 Representation Model에 추가하는 link 인스턴스 생성

#### Caching Data with Spring
- Spring Boot Dependency
  - implementation : org.springframework.boot:spring-boot-starter-cache
- cache 구현
  - @Cacheable("books") 로 캐싱 기능 추가
  - SpringBootApplication 에 @EbanelCaching 추가하여 캐싱 기능 활성화

#### Creating Asynchronous Methods
- Service 클래스에서 비동기로 실행할 메소드에 @Async annotation 붙임 -> Service를 호출하는 Thread와는 분리된 Thread로 수행
- RestTemplate 으로 원격 호출하고 그 결과 Account 를 CompletableFuture에 감싸서 반환
- 메소드의 반환은 CompletableFuture 로 반환
- Creating a local instance of the GitHubLookupService class does NOT allow the find User method to run asynchronously. It must be created inside a @Configuration class or picked up by @ComponentScan의 의미?
- @Async를 활성화하기 위해서는 SpringApplication에 @EnableAsync annotation 정의
- 추가로 Thread Pool 생성 (생성하지 않아도 Default Pool 을 사용)
- CommandLineRunner 을 상속받는 테스트 로직 구현