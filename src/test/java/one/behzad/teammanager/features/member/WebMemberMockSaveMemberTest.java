package one.behzad.teammanager.features.member;

import com.fasterxml.jackson.databind.ObjectMapper;
import one.behzad.teammanager.DTOs.MemberDTO;
import one.behzad.teammanager.models.Member;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static one.behzad.teammanager.features.member.utils.createMemberDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MemberController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WebMemberMockSaveMemberTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MemberService memberService;


    // 1. HTTP REQUEST MATCHING
    @Order(1)
    @ParameterizedTest
    @ValueSource(strings = {"{}", "{ }", "{ \"invalid\":\"invalid\" }"})
    void httpRequestMatching_whenValidJsonReturn_Return201(String validInput) throws Exception {

        System.out.println(("http"));
        this.mockMvc.perform(post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validInput))
                .andExpect(status().isCreated());
    }


    @Order(2)
    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "{", "}", "{ invalid:invalid }"})
    void httpRequestMatching_whenInvalidJsonReturn_Return400(String invalidInput) throws Exception {

        this.mockMvc.perform(post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidInput))
                .andExpect(status().isBadRequest());
    }


    // 2. INPUT DESERIALIZATION
    @Order(3)
    @Test
    void inputDeserialization_whenValidMemberDTO_mappedCorrectlyToMember() throws Exception {
        this.mockMvc.perform(post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(createMemberDTO())))
                .andExpect(status().isCreated());
    }


    // 3. INPUT VALIDATION
    // 4. BUSINESS LOGIC
    @Order(4)
    @Test
    void logic_whenValidInput_serviceReceivedCorrectMember() throws Exception {
        System.out.println("logic");
        MemberDTO memberDTO = createMemberDTO();

        this.mockMvc.perform(post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(memberDTO)))
                .andExpect(status().isCreated());

        ArgumentCaptor<Member> memberCaptor = ArgumentCaptor.forClass(Member.class);
        verify(this.memberService, times(1)).save(memberCaptor.capture());
        assertThat(memberCaptor.getValue().getSurName()).isEqualTo(memberDTO.getSurName());
        assertThat(memberCaptor.getValue().getLastName()).isEqualTo(memberDTO.getLastName());
    }


    // 5. OUTPUT
    @Order(5)
    @Test
    void output_whenValidInput_returnMappedMemberDTO() throws Exception {
        MemberDTO memberDTO = createMemberDTO();

        MvcResult mvcResult = this.mockMvc.perform(post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(memberDTO)))
                .andReturn();

        String actualResponseBody = mvcResult.getResponse().getContentAsString();

        assertThat(actualResponseBody).isEqualToIgnoringWhitespace(
                this.objectMapper.writeValueAsString(memberDTO));
    }

    // 6. EXCEPTION HANDLING
}