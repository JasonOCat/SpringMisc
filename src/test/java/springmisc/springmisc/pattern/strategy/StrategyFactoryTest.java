package springmisc.springmisc.pattern.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class StrategyFactoryTest {

    @Spy // use the real method set.put in StategyFactory
    Set<Strategy> strategies = Set.of(new StrategyAdd());

    StrategyFactory underTest = new StrategyFactory(strategies);

    @Test
    void duringInitialization_strategyFactory_shouldCreateMapOfStrategies() {
        //given
        int numberOfStrategies = strategies.size();
        int strategyFactoryNumberOfStrategy = underTest.getStrategies().size();

        //when
        //the initialization of the context create StartegyFactory and put all Strategies inside its map "strategy"

        //then
        assertThat(numberOfStrategies).isEqualTo(strategyFactoryNumberOfStrategy);
    }

    @Test
    void canFindStrategyByName() {
        // given
        Class<?> strategyAddClass = StrategyAdd.class;

        // when
        Strategy strategy = underTest.findStrategy(StrategyName.STRATEGY_ADDITION);

        // then
        assertThat(strategy.getClass()).isEqualTo(strategyAddClass);
    }


}
