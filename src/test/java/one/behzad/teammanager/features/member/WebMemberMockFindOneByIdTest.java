package one.behzad.teammanager.features.member;

import com.fasterxml.jackson.databind.ObjectMapper;
import one.behzad.teammanager.models.Member;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static one.behzad.teammanager.features.member.UtilsMember.createMember;
import static one.behzad.teammanager.features.member.UtilsMember.createMemberDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MemberController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WebMemberMockFindOneByIdTest {

    private static final long ID = 1L;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private MemberService memberService;


    // 1. HTTP REQUEST MATCHING
    @Order(1)
    @Test
    void httpRequestMatching_whenValidJson_Return200() throws Exception {
        when(this.memberService.findOneById(anyLong())).thenReturn(Optional.of(createMember()));
        this.mockMvc.perform(get("/user/" + ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Order(1)
    @Test
    void httpRequestMatching_whenValidJsonButNotFound_Return404() throws Exception {
        when(this.memberService.findOneById(anyLong())).thenReturn(Optional.empty());
        this.mockMvc.perform(get("/user/" + ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Order(1)
    @ParameterizedTest
    @ValueSource(strings = {"  ", "{", "}", "ONE", "1L"})
    void httpRequestMatching_whenInvalidId_Return400(String invalidInput) throws Exception {
        System.out.println("SEND: " + invalidInput);
        verify(this.memberService, times(0)).findOneById(anyLong());
        this.mockMvc.perform(get("/user/" + invalidInput)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }


    // 2. INPUT DESERIALIZATION
    // 3. INPUT VALIDATION
    // 4. BUSINESS LOGIC
    // 5. OUTPUT
    @Order(5)
    @Test
    void output_whenMemberExists_thenReturnsMappedMemberDTO() throws Exception {
        // GIVEN
        Member member = createMember();
        String expected = this.objectMapper.writeValueAsString(createMemberDTO());

        // WHEN
        when(this.memberService.findOneById(anyLong())).thenReturn(Optional.of(member));
        MvcResult mvcResult = this.mockMvc.perform(get("/user/" + ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String actual = mvcResult.getResponse().getContentAsString();

        // THEN
        verify(this.memberService, times(1)).findOneById(ID);
        assertThat(actual).isEqualToIgnoringWhitespace(expected);

    }
    // 6. EXCEPTION HANDLING
}