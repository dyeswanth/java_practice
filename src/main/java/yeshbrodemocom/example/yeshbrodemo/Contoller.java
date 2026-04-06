package yeshbrodemocom.example.yeshbrodemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Contoller {
    @GetMapping("/test")
    ResponseEntity<String> getDetils(){
        return ResponseEntity.ok("hello");
    }

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName());
    }
}
