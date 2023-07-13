package how.to.jacoco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CountController.class)
class CountControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    private static int expectedValue = 0;

    @BeforeEach
    void init() {
        System.out.println("expectedValue=" + expectedValue);
    }

    @Test
    void current() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expectedValue)));
    }

    @Test
    void increase() throws Exception {
        mockMvc.perform(put("/increase"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(++expectedValue)));
    }

    @Test
    void decrease() throws Exception {
        mockMvc.perform(put("/decrease"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(--expectedValue)));
    }
}
