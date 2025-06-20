package za.ac.uj.meal_distribution_system;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MealDistributionSystemApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        // Basic test to verify context loads
        mockMvc.perform(get("/"))
//        mockMvc.perform(get("/api/health"))
                .andExpect(status().isOk());
    }
}


