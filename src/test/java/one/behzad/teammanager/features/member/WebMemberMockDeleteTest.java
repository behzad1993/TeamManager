package one.behzad.teammanager.features.member;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MemberController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WebMemberMockDeleteTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;


    // 1. HTTP REQUEST MATCHING
    @Order(1)
    @ParameterizedTest
    @ValueSource(longs = {1, 99, 999999, 999999999, -1, 0})
    void httpRequestMatching_whenValidId_Return200(long id) throws Exception {
        this.mockMvc.perform(delete("/user/delete/" + id))
                .andExpect(status().isOk());

        verify(this.memberService, times(1)).delete(id);
    }


    @Order(1)
    @Test
    void httpRequestMatching_whenNoId_Return404() throws Exception {
        this.mockMvc.perform(delete("/user/delete/"))
                .andExpect(status().isNotFound());

        verify(this.memberService, times(0)).delete(anyLong());
    }

    @Order(1)
    @ParameterizedTest
    @ValueSource(strings = {"9999999999", "-9999999999"})
    void httpRequestMatching_whenInvalidId_Return200(long id) throws Exception {
        this.mockMvc.perform(delete("/user/delete/" + id))
                .andExpect(status().isOk());

        verify(this.memberService, times(1)).delete(id);
    }


    // 2. INPUT DESERIALIZATION
    // 3. INPUT VALIDATION
    // 4. BUSINESS LOGIC
    // 5. OUTPUT
    // 6. EXCEPTION HANDLING
}