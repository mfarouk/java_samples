package hello;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by farouk on 4/30/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ApplicationContext ctx;

    @Before
    public void incrementCounter(){
        counter.incrementAndGet();
    }

    @Test
    public void getGreeting() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":"+counter+",\"content\":\"Hello, Universe!\"}"));
    }

    @Test
    public void getBeans() throws Exception{
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        mvc.perform(MockMvcRequestBuilders.get("/beans").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":"+counter+",\"content\":" + Arrays.toString(beanNames) +"}"));

    }
}
