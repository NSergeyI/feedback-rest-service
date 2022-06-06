package com.example.restservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IpControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void ipShouldReturnIP() throws Exception {

        this.mockMvc.perform(get("/ip"))
                .andDo(print()).andExpect(status().isOk())
//                .andExpect(jsonPath("$.ip").value("0:0:0:0:0:0:0:1"));
                .andExpect(jsonPath("$.ip").value("127.0.0.1"));
    }

}
