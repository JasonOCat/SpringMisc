package springmisc.springmisc.pattern.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
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
        int strategyFactoryNumberOfStrategy = underTest.getStrategies()
                .size();

        //when
        //the initialization of the context create StartegyFactory and put all Strategies inside its map "strategy"

        //then
        assertThat(numberOfStrategies).isEqualTo(strategyFactoryNumberOfStrategy);
        var a = List.of(
                1,
                2,
                3
        );
        var list = a.stream()
                .map(x -> x + 2)
                .filter(x -> x % 2 != 0)
                .toList();
        System.out.println(list);
    }

    @Test
    void canFindStrategyByName() {
        // given
        Class<?> strategyAddClass = StrategyAdd.class;

        // when
        Strategy strategy = underTest.findStrategy(StrategyName.STRATEGY_ADDITION)
                .orElseThrow(() -> new IllegalArgumentException("Strategy doesn't exist."));


        // then
        assertThat(strategy.getClass()).isEqualTo(strategyAddClass);
    }


    public int foo1(int i) {
        return i;
    }

}
