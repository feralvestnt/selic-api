package com.anbima.selic.controller;

import com.anbima.selic.util.JacksonConverter;
import com.anbima.selic.util.Request;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SelicControllerTest {

    @Autowired
    private JacksonConverter jacksonConverter;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void deveRetornarHistoricoTotal() throws Exception {
        mockMvc.perform(get("/api/selic/historico"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(Request.getContentType()))
            .andExpect(jsonPath("$", hasSize(132)));
    }

    @Test
    public void deveRetornarAnosDisponiveis() throws Exception {
        mockMvc.perform(get("/api/selic/anos-disponiveis"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(Request.getContentType()))
                .andExpect(jsonPath("$", hasSize(11)));
    }

    @Test
    public void deveRetornarMesesDisponiveis() throws Exception {
        mockMvc.perform(get("/api/selic/meses-disponiveis"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(Request.getContentType()))
                .andExpect(jsonPath("$", hasSize(132)));
    }

    @Test
    public void deveRetornarMedias() throws Exception {
        mockMvc.perform(get("/api/selic/medias"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(Request.getContentType()))
                .andExpect(jsonPath("$", hasSize(11)));
    }
}
