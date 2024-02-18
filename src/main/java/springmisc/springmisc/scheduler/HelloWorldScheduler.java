package springmisc.springmisc.scheduler;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class HelloWorldScheduler {

    @Bean
    public TaskScheduler taskScheduler2() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(5);
        threadPoolTaskScheduler.setThreadNamePrefix("jason");
        return threadPoolTaskScheduler;
    }


    // Spring will search for an associated scheduler definition:
    // either a unique TaskScheduler bean in the context,
    // or a TaskScheduler bean named "taskScheduler" otherwise;
    // the same lookup will also be performed for a ScheduledExecutorService bean
//    @Bean
//    public TaskScheduler taskScheduler() {
//        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
//        threadPoolTaskScheduler.setPoolSize(5);
//        threadPoolTaskScheduler.setThreadNamePrefix("jerome");
//        return threadPoolTaskScheduler;
//    }

//    @Scheduled(fixedRate = 1000)
    public void sayHelloWorld() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " : " + Instant.now());

    }
}
