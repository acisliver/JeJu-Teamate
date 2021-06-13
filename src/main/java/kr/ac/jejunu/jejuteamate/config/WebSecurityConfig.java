package kr.ac.jejunu.jejuteamate.config;


import kr.ac.jejunu.jejuteamate.config.security.jwt.JwtAccessDeniedHandler;
import kr.ac.jejunu.jejuteamate.config.security.jwt.JwtAuthenticationEntryPoint;
import kr.ac.jejunu.jejuteamate.config.security.jwt.JwtAuthenticationFilter;
import kr.ac.jejunu.jejuteamate.config.security.jwt.JwtAuthotizationFilter;
import kr.ac.jejunu.jejuteamate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CorsConfig corsConfig;

    @Autowired
    private UserRepository userRepository;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //security필터보다 MyFilter3를 우선 필터링
        //http.addFilterBefore(new MyFilter3(), SecurityContextPersistenceFilter.class);

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(corsConfig.corsFilter()) //@CorsOrigin(인증x), 시큐리티필터에 등록 인증(o)
                .csrf().disable()
                .formLogin().disable() //form태그로 정보를 넘겨받아 로그인을 하지 않는다. jwt기본
                .httpBasic().disable()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthotizationFilter(authenticationManager(),userRepository))
                .authorizeRequests()
                .antMatchers("/api/user/**")
                .access("hasRole(RoleType.USER) or hasRole(RoleType.ADMIN)")
                .antMatchers("/api/admin/**")
                .access("hasRole(RoleType.ADMIN)")
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .anyRequest().permitAll()

                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new JwtAuthenticationEntryPoint())
                .accessDeniedHandler(new JwtAccessDeniedHandler());
    }
}
