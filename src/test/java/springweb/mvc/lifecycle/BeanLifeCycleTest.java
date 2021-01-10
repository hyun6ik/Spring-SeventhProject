package springweb.mvc.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void lifeCycleTest() throws Exception {
        //given
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        //when
        NetworkClient networkClient = ac.getBean(NetworkClient.class);
        ac.close();
        //then

    }

    @Configuration
    static class LifeCycleConfig{
//        @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
