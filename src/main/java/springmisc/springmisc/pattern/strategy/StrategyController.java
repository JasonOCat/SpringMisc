package springmisc.springmisc.pattern.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/strategy/pattern")
@RequiredArgsConstructor
@Slf4j
public class StrategyController {

    private final StrategyService strategyService;

    @GetMapping
    public int doStrategyAdd() {
        return strategyService.doStrategyAdd();
    }
}
