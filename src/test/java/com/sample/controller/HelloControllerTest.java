package com.sample.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    void sayHello() throws Exception {
        String requestBody = "{\"name\" : \"John\"}";

       MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/sayHello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(requestBody)

        ).andReturn();

       assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    void sayHelloWithException() throws Exception {

        String requestBody = "{\"name\" : \"John\"}";

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/sayHelloWithException")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(requestBody)

        ).andReturn();

        assertEquals(HttpStatus.GATEWAY_TIMEOUT.value(), result.getResponse().getStatus());
    }
}