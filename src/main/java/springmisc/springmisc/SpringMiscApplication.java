package springmisc.springmisc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import springmisc.springmisc.scheduler.HelloWorldScheduler;

import java.util.concurrent.ScheduledExecutorService;

@SpringBootApplication
@EnableScheduling
public class SpringMiscApplication {

    @Autowired
    HelloWorldScheduler helloWorldScheduler;

    public static void main(String[] args) {
        SpringApplication.run(SpringMiscApplication.class, args);
    }

    @Bean
    public ScheduledExecutorService executorService() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.initialize();
        return scheduler.getScheduledExecutor();
    }

    @Component
    public class CommandLineRunnerImpl implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
//            System.out.println("In CommandLineRunnerImpl ");

//            helloWorldScheduler.sayHelloWorld();
        }
    }

}
