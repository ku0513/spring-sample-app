package com.test.sampleapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("SampleControllerクラスのテスト")
public class SampleControllerTest {
    @Nested
    class listのURLにアクセスされた時のテスト {
        @Test
        void listのURLにアクセスされた時にidが1とnameがtestを返却する() throws Exception {
            ObjectMapper mapper = new ObjectMapper();
            MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new SampleController()).build();

            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/list")).andReturn();
            ListItem listItemResponse = mapper.readValue(result.getResponse().getContentAsString(), ListItem.class);

            assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
            assertEquals(1, listItemResponse.getId());
            assertEquals("test", listItemResponse.getName());
        }
    }
}
