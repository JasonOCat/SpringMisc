package springmisc.springmisc.pattern.strategy.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import springmisc.springmisc.pattern.strategy.StrategyFactory;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
public class ExampleIT {

    @Autowired
    private StrategyFactory strategyFactory;

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:5.0.10");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }


    @Test
    void integrationTestOnStrategyFactory() {
        assertThat(strategyFactory.getStrategies().size()).isEqualTo(1);
    }

}
