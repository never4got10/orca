# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.6/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.6/gradle-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.7.6/reference/htmlsingle/#using.devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.6/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### 설명
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