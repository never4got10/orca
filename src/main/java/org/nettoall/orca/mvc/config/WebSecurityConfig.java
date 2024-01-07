package org.nettoall.orca.mvc.config;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFileChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/", "/home","/hellorest").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin((form) -> form
//                        .loginPage("/login")     // login path 정의 - MvcConfig addViewControllers 로 정의됨
//                        .permitAll()
//                )
//                .logout(LogoutConfigurer::permitAll);
//
//        return http.build();
//    }

    /**
     * 메모리에 로그인할 사용자 한명에 대해 정의
     *
     * @return UserDetailsService
     */
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}
