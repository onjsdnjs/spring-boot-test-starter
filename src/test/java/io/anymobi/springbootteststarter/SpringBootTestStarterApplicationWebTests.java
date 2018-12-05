package io.anymobi.springbootteststarter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class) //Controller 단위로 테스트하고 일부 웹 관련 빈만 등록된다(@Service, @Repository.. 등 @Component 빈들은 등록 안된다)
public class SpringBootTestStarterApplicationWebTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @MockBean
    TestService mockTestService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {

        when(mockTestService.getName()).thenReturn("anymobi");

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello anymobi"))
                .andDo(print());

        assertThat(outputCapture.toString()).contains("hello");
    }

}
