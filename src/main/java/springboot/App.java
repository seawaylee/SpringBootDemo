package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author NikoBelic
 * @create 31/01/2017 00:51
 */
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class App
{
    public static void main(String[] args) throws InterruptedException
    {
        SpringApplication.run(App.class,args);
    }
}
