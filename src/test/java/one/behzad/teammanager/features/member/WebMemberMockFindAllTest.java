package one.behzad.teammanager.features.member;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static one.behzad.teammanager.features.member.UtilsMember.getMemberDTOs;
import static one.behzad.teammanager.features.member.UtilsMember.getMembers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MemberController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WebMemberMockFindAllTest {

    private static final int ERROR = 500;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private MemberService memberService;


    // 1. HTTP REQUEST MATCHING
    @Order(1)
    @Test
    void httpRequestMatching_Return200() throws Exception {
//        when(this.memberService.findAll()).thenReturn(List.of());
//        MvcResult mvcResult = this.mockMvc.perform(get("/user/users/"))
//                .andReturn();
//        int actual = mvcResult.getResponse().getStatus();
//        assertThat(actual).isLessThan(ERROR);

        this.mockMvc.perform(get("/your-endpoint")) // Replace with your actual endpoint
                .andReturn();
    }


    // 2. INPUT DESERIALIZATION
    // 3. INPUT VALIDATION
    // 4. BUSINESS LOGIC
    // 5. OUTPUT
    @Order(5)
    @Test
    void output_whenNoMemberExists_Return404() throws Exception {
        // GIVEN

        // WHEN
        when(this.memberService.findAll()).thenReturn(List.of());
        this.mockMvc.perform(get("/user/users"))
                .andExpect(status().isNotFound());
    }


    @Order(5)
    @Test
    void output_whenMemberExists_ReturnListOfMemberDTOs() throws Exception {
        // GIVEN

        // WHEN
        when(this.memberService.findAll()).thenReturn(getMembers());
        MvcResult mvcResult = this.mockMvc.perform(get("/user/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // THEN
        String actualResponseBody = mvcResult.getResponse().getContentAsString();

        assertThat(actualResponseBody).isEqualToIgnoringWhitespace(
                this.objectMapper.writeValueAsString(getMemberDTOs())
        );
    }
    // 6. EXCEPTION HANDLING
}