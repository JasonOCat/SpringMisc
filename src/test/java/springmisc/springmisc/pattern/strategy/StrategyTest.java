package springmisc.springmisc.pattern.strategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StrategyTest {

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
