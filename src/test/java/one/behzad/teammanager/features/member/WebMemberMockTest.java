package one.behzad.teammanager.features.member;

import com.fasterxml.jackson.databind.ObjectMapper;
import one.behzad.teammanager.DTOs.MemberDTO;
import one.behzad.teammanager.models.Member;
import org.junit.jupiter.api.Test;
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
class WebMemberMockTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MemberService memberService;


    // 1. HTTP REQUEST MATCHING
    @ParameterizedTest
    @ValueSource(strings = {"{}", "{ }", "{ \"invalid\":\"invalid\" }"})
    void save_whenValidJsonReturn_Return201(String validInput) throws Exception {

        this.mockMvc.perform(post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validInput))
                .andExpect(status().isCreated());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "{", "}", "{ invalid:invalid }"})
    void save_whenInvalidJsonReturn_Return400(String invalidInput) throws Exception {

        this.mockMvc.perform(post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidInput))
                .andExpect(status().isBadRequest());
    }

    // 2. INPUT DESERIALIZATION
    @Test
    void save_whenValidMemberDTO_deserializationIsCorrect() throws Exception {
        MemberDTO memberDTO = createMemberDTO();
//        memberDTO.setSurName(null);

        String content = this.objectMapper.writeValueAsString(memberDTO);
        System.out.println(content);
        content = "{\"surName\":null,\"lastName\":\"b\",\"email\":null,\"phoneNr\":null,\"birthday\":null}\n";
        System.out.println(content);
        this.mockMvc.perform(post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isCreated());
    }

    // 3. INPUT VALIDATION
    // 4. BUSINESS LOGIC
    @Test
    void whenValidInput_thenMapsToMember() throws Exception {
        MemberDTO memberDTO = createMemberDTO();

        this.mockMvc.perform(post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(memberDTO)))
                .andExpect(status().isCreated());

        ArgumentCaptor<Member> memberCaptor = ArgumentCaptor.forClass(Member.class);
        verify(this.memberService, times(1)).save(memberCaptor.capture());
        assertThat(memberCaptor.getValue().getSurName()).isEqualTo("a");
        assertThat(memberCaptor.getValue().getLastName()).isEqualTo("b");
    }


    // 5. OUTPUT
    @Test
    void whenValidInput_thenReturnsMemberDTO() throws Exception {
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