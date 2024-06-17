package one.behzad.teammanager.features.member;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MemberController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WebMemberMockPatchTest {

    private final static long ID = 1;
    private final String path = "/user/patch/";

    @Captor
    private ArgumentCaptor<Map<String, String>> argCaptor;


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private MemberService memberService;

    // 1. HTTP REQUEST MATCHING
    @Order(1)
    @Test
    void httpRequest_patchSucceed_returnOk() throws Exception {
        String body = this.objectMapper.writeValueAsString(Map.of("key", "value"));
        when(this.memberService.update(anyLong(), anyMap())).thenReturn(true);
        this.mockMvc.perform(patch("/user/patch/" + ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }


    @Order(1)
    @Test
    void httpRequest_patchFails_returnBadRequest() throws Exception {
        String body = this.objectMapper.writeValueAsString(Map.of("key", "value"));
        when(this.memberService.update(anyLong(), anyMap())).thenReturn(false);
        this.mockMvc.perform(patch("/user/patch/" + ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest());
    }


    @Order(1)
    @Test
    void inputDeserialization_whenInvalidMap_returnBadRequest() throws Exception {
        this.mockMvc.perform(patch("/user/patch/" + ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Map.of("key", "value").toString()))
                .andExpect(status().isBadRequest());
    }


    // 2. INPUT DESERIALIZATION
    // 3. INPUT VALIDATION
    // 4. BUSINESS LOGIC
    @Order(4)
    @Test
    void logic_mapShouldBeSendUneditedToService() throws Exception {
        Map<String, String> map = Map.of("key", "value");
        String body = this.objectMapper.writeValueAsString(map);

        when(this.memberService.update(anyLong(), anyMap())).thenReturn(true);
        ArgumentCaptor<Long> longCaptor = ArgumentCaptor.forClass(Long.class);

        this.mockMvc.perform(patch("/user/patch/" + ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());

        verify(this.memberService, times(1)).update(longCaptor.capture(), this.argCaptor.capture());

        assertThat(longCaptor.getValue()).isEqualTo(ID);
        assertThat(this.argCaptor.getValue()).isEqualTo(map);
    }


    // 5. OUTPUT
    // 6. EXCEPTION HANDLING
}