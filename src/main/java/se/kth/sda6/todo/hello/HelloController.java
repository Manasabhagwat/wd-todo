package se.kth.sda6.todo.hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello() {
        return  "Hello world";
    }

    @RequestMapping("/hello-person/{name}")
    public String helloPerson(@PathVariable String name) {
        return "Hello " + name;
    }

    @RequestMapping("/hello-person-age")
    public String helloPersonAge(@RequestParam String name,@RequestParam Integer age) {
        return "Hello " + name + " your age is " + age;
    }
}
