package ru.mai.articlestore.controller.stub;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.mai.articlestore.dto.request.stub.StubRequest;
import ru.mai.articlestore.dto.response.stub.StubResponse;
import ru.mai.articlestore.service.stub.StubService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = StubController.class)
public class StubControllerTest {
    private final static String NAME = "Ivan";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StubService stubService;

    private StubRequest stubRequest;
    private StubResponse expectedStubResponse;
    private ObjectMapper mapper;

    @BeforeEach
    void setup() {
        stubRequest = new StubRequest(NAME);
        expectedStubResponse = new StubResponse(NAME);
        mapper = new ObjectMapper();
    }

    @Test
    public void testHelloGet() throws Exception {
        when(stubService.helloForGet(NAME)).thenReturn(expectedStubResponse);

        mockMvc
                .perform(get("/hello/get").param("name", NAME))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedStubResponse)));
    }

    @Test
    public void testHelloGetWithPathVariable() throws Exception {
        when(stubService.helloForGet(NAME)).thenReturn(expectedStubResponse);

        mockMvc
                .perform(get("/hello/get/%s".formatted(NAME)))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedStubResponse)));
    }

    @Test
    public void testHelloPost() throws Exception {
        when(stubService.helloForPost(stubRequest)).thenReturn(expectedStubResponse);

        mockMvc
                .perform(
                        post("/hello/post")
                                .content(mapper.writeValueAsString(stubRequest))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedStubResponse)));
    }

}
