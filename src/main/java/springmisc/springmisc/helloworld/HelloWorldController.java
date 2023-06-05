package springmisc.springmisc.helloworld;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/hello-world")
@RequiredArgsConstructor
@Slf4j
public class HelloWorldController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld() {
        return "Hello world";
    }
}
