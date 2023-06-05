package springmisc.springmisc.pattern.strategy;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
public class StrategyTest {

    @Autowired
    private Set<Strategy> strategies;

    @Autowired
    private StrategyFactory strategyFactory;

    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:5.0.10");

    static {
        mongoDBContainer.start();
    }

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Test
    void strategyFactoryShouldHaveAMapWithAllStrategies() {
        //given
        int numberOfStrategies = strategies.size();
        int strategyFactoryNumberOfStrategy = strategyFactory.getStrategies().size();

        //when
        //initialization create StartegyFactory and put all Strategies inside its map "strategy"s

        //then
        assertThat(strategies.size()).isEqualTo(strategyFactoryNumberOfStrategy);

    }
    @Test
    void strategyAddShouldReturnAddition() {
        //given
        Strategy strategyAdd = new StrategyAdd();
        int a = 1;
        int b = 2;
        int expected = 3;

        //when
        int result = strategyAdd.execute(a, b);

        //then
        assertThat(result).isEqualTo(expected);
    }



}
