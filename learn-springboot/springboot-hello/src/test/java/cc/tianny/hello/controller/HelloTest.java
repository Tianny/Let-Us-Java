package cc.tianny.hello.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/7/7
 * Time: 6:19 上午
 * Description: No Description
 */
@SpringBootTest
public class HelloTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void getHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/hello?name=Tianny").
                accept(MediaType.APPLICATION_JSON)).andDo(print());
    }

}
