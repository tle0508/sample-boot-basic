package th.mfu.boot;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController

public class HelloController {

    @GetMapping("/hello")
    public String hello(){
    
      return "Hello World";
    }

    
}
