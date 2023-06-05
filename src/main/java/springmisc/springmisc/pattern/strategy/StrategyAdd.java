package springmisc.springmisc.pattern.strategy;

import org.springframework.stereotype.Component;

@Component
public class StrategyAdd implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a + b;
    }

    @Override
    public StrategyName getStrategyName() {
        return StrategyName.STRATEGY_ADDITION;
    }
}
