package th.mfu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello/")
    String hello() {
        return "Hello World" ;
    }

    @GetMapping("/sum/{x}/{y}")
    int sum(@PathVariable int x ,@PathVariable int y) {
        return x+y;
    }
    
    @GetMapping("/hi/{name}")
    public String hi(String name) {
        return "Hello "+name;
    }

   
}
