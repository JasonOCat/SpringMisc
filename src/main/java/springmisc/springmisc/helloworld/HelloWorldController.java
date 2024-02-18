package springmisc.springmisc.helloworld;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

@RestController
@RequestMapping("/v1/hello-world")
//@RequiredArgsConstructor
@Slf4j
public class HelloWorldController {


    @Value("classpath:jason.txt")
    Resource resource;

    @GetMapping()
    public String helloWorld() {
        return "Hello world";
    }

    @PostMapping("jason")
    public ResponseEntity<Resource> testJason() throws IOException {
//        Resource resource = new ClassPathResource("jason.pdf");
//        byte [] array = resource.getContentAsByteArray();
//        System.out.println(array);
//        return new ClassPathResource("jason.pdf").getContentAsByteArray();
        byte [] byteArr = new ClassPathResource("jason.pdf").getContentAsByteArray();
        Resource resource = new ByteArrayResource(byteArr);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld(@RequestParam("file") MultipartFile file) throws IOException {

        System.out.println(file);

        byte [] bytes = file.getBytes();
        //System.out.println(Base64.getEncoder().encodeToString(bytes));

        Resource resource = new ByteArrayResource(bytes);

        byte [] transform = resource.getContentAsByteArray();



        return "Hello world";
    }
}
