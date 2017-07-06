package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by farouk on 4/30/17.
 */

@RestController
public class GreetingController {

    private final String template = "Hello, %s";
    private final AtomicLong greeting_counter = new AtomicLong();
    private final AtomicLong beans_counter = new AtomicLong();

    @Autowired
    private ApplicationContext ctx;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name",defaultValue = "Universe!") String name){
        return new Greeting(greeting_counter.incrementAndGet(),String.format(template, name));
    }

    @RequestMapping("/beans")
    public Bean displayBeans(@RequestParam(value="name",defaultValue = "World!")String name){
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        return new Bean(beans_counter.incrementAndGet(),beanNames);

    }



}
