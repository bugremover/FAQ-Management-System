package com.example.BharatFD;

import com.example.BharatFD.controller.*;

import com.example.BharatFD.model.FAQ;
import com.example.BharatFD.service.FAQService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Collections;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class FAQControllerTest {

    private final MockMvc mockMvc;

    @Mock
    private FAQService faqService;

    @InjectMocks
    private FAQController faqController;

    public FAQControllerTest() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(faqController).build();
    }

    @Test
    void testGetFAQs() throws Exception {
        FAQ faq = new FAQ();
        faq.setId("1");
        faq.setQuestion("What is Spring Boot?");
        faq.setAnswer("Spring Boot is an open-source Java framework.");

        when(faqService.getAllFAQs()).thenReturn(Collections.singletonList(faq));

        mockMvc.perform(get("/api/faqs"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':'1','question':'What is Spring Boot?','answer':'Spring Boot is an open-source Java framework.'}]"));
    }

    @Test
    void testCreateFAQ() throws Exception {
        FAQ faq = new FAQ();
        faq.setId("1");
        faq.setQuestion("What is Spring Boot?");
        faq.setAnswer("Spring Boot is an open-source Java framework.");

        when(faqService.createFAQ(faq)).thenReturn(faq);

        mockMvc.perform(post("/api/faqs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(faq)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id':'1','question':'What is Spring Boot?','answer':'Spring Boot is an open-source Java framework.'}"));
    }
}

