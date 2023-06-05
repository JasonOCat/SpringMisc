package springmisc.springmisc.pattern.strategy;

public interface Strategy {
    int execute(int a, int b);

    StrategyName getStrategyName();

}
