package springmisc.springmisc.pattern.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StrategyService {

    private final StrategyFactory strategyFactory;

    public int doStrategyAdd (){
        Strategy strategy = strategyFactory.findStrategy(StrategyName.STRATEGY_ADDITION);
        return strategy.execute(4, 6);


    }
}
