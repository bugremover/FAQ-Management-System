package com.example.BharatFD;

import com.example.BharatFD.service.*;

import com.example.BharatFD.model.FAQ;
import com.example.BharatFD.repository.FAQRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FAQServiceTest {

    @Mock
    private FAQRepository faqRepository;

    @InjectMocks
    private FAQService faqService;

    private FAQ sampleFAQ;

    @BeforeEach
    void setUp() {
        sampleFAQ = new FAQ();
        sampleFAQ.setId("1");
        sampleFAQ.setQuestion("What is Spring Boot?");
        sampleFAQ.setAnswer("Spring Boot is an open-source Java framework.");
    }

    @Test
    void testCreateFAQ() {
        when(faqRepository.save(sampleFAQ)).thenReturn(sampleFAQ);
        FAQ createdFAQ = faqService.createFAQ(sampleFAQ);
        assertNotNull(createdFAQ);
        assertEquals("1", createdFAQ.getId());
        assertEquals("What is Spring Boot?", createdFAQ.getQuestion());
    }

    @Test
    void testGetAllFAQs() {
        when(faqRepository.findAll()).thenReturn(Arrays.asList(sampleFAQ));
        List<FAQ> faqs = faqService.getAllFAQs();
        assertEquals(1, faqs.size());
        assertEquals("What is Spring Boot?", faqs.get(0).getQuestion());
    }
}
