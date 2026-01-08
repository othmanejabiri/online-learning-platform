package ma.onlinelearning.auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {

        return new InMemoryUserDetailsManager(

                User.withUsername("admin@onlinelearning.com")
                        .password(encoder.encode("admin123"))
                        .roles("ADMIN")
                        .build(),

                User.withUsername("prof@onlinelearning.com")
                        .password(encoder.encode("prof123"))
                        .roles("PROF")
                        .build(),

                User.withUsername("etu@onlinelearning.com")
                        .password(encoder.encode("etu123"))
                        .roles("ETU")
                        .build()
        );
    }
}
