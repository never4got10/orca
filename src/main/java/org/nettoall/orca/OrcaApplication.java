package org.nettoall.orca;

import org.nettoall.orca.mvc.service.StorageProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableScheduling
@EnableConfigurationProperties(StorageProperties.class)
public class OrcaApplication {

    private final Logger log = LoggerFactory.getLogger(OrcaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OrcaApplication.class, args);
    }

    /**
     * 간단하게 JPA 데이터 저장, 조회 테스트
     * @param repository
     * @return
     */
//    @Bean
//    public CommandLineRunner demo(CustomerRepository repository) {
//        return (args) -> {
//            // customer 저장
//            repository.save(new Customer("Jack", "Bauer"));
//            repository.save(new Customer("Chloe", "O'Brian"));
//            repository.save(new Customer("Kim", "Bauer"));
//            repository.save(new Customer("David", "Palmer"));
//            repository.save(new Customer("Michelle", "Dessler"));
//
//            // 모든 customer 가져오기
//            log.info("Customers found with findAll(): ");
//            log.info("--------------------------------");
//            repository.findAll().forEach(customer -> {
//                log.info(customer.toString());
//            });
//            log.info("");
//
//            // id 로 개별 customer 조회
//            Customer customer = repository.findById(1L);
//            log.info("Customer found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(customer.toString());
//            log.info("");
//
//            // 성으로 customer 조회
//            log.info("Customer found with findByLastName('Bauer'):");
//            log.info("--------------------------------");
//            repository.findByLastName("Bauer").forEach(bauer -> {
//                log.info(bauer.toString());
//            });
//            log.info("");
//        };
//    }

    /**
     * contextn에 등록된 bean 출력
     * @param ctx
     * @return
     */
//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//        };
//    }

}
