package giocattolandia.cotroller;

import giocattolandia.utils.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ToysControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldCreateNewUser() throws Exception {
        String jsonResource = TestUtils.getJsonResource("/utils/request_users.json");
        ResultActions resultActions = mockMvc.perform(post("/toys/insertNewToys").contentType(APPLICATION_JSON).content(jsonResource));
        getResultActions(resultActions);
    }

    private ResultActions getResultActions(ResultActions resultActions) throws Exception {
        return resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productName", is("Nemo")))
                .andExpect(jsonPath("$.stockQuantity", is(20)))
                .andExpect(jsonPath("$.avaragePrice", is(15)))
                .andExpect(jsonPath("$.actualPrice", is(15)))
                .andExpect(jsonPath("$.barCode", is(9878458)));
    }

}

