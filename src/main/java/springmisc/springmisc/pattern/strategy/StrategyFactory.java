package springmisc.springmisc.pattern.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Component
public class StrategyFactory {
    private Map<StrategyName, Strategy> strategies;

    @Autowired
    public StrategyFactory(Set<Strategy> strategySet) {
        createStrategy(strategySet);
    }

    public Optional<Strategy> findStrategy(StrategyName strategyName) {
        return Optional.ofNullable(strategies.get(strategyName));
    }
    private void createStrategy(Set<Strategy> strategySet) {
        strategies = new HashMap<>();
        strategySet.forEach(
                strategy -> strategies.put(strategy.getStrategyName(), strategy)
        );
    }

    public Map<StrategyName, Strategy> getStrategies() {
        return strategies;
    }
}