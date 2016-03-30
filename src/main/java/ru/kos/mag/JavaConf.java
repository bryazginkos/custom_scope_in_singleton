package ru.kos.mag;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by brjazgin on 30.03.2016.
 */
@Configuration
public class JavaConf {

    @Bean
    @Scope(value = "customScope")
    public SomeService someService() {
        return new SomeService();
    }

    @Bean(name = "someSingleton")
    public SomeSingleton someSingleton() {
        return new SomeSingleton() {
            @Override
            public SomeService getSomeService() {
                return someService();
            }
        };
    }


}
