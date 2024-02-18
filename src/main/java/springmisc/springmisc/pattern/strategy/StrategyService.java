package springmisc.springmisc.pattern.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StrategyService {

    private final StrategyFactory strategyFactory;

    public int doStrategyAdd (){
        return strategyFactory.findStrategy(StrategyName.STRATEGY_ADDITION)
                .map(strategy -> strategy.execute(4, 6))
                .orElseThrow(() -> new IllegalArgumentException("Strategy doesn't exist."));
    }
}
