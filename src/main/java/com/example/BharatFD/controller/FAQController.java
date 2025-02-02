package com.example.BharatFD.controller;



import com.example.BharatFD.model.FAQ;
import com.example.BharatFD.service.FAQService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faqs")
public class FAQController {
    private final FAQService faqService;

    public FAQController(FAQService faqService) {
        this.faqService = faqService;
    }

    @GetMapping
    public List<FAQ> getFAQs(@RequestParam(required = false, defaultValue = "en") String lang) {
        return faqService.getAllFAQs();
    }

    @PostMapping
    public FAQ createFAQ(@RequestBody FAQ faq) {
        return faqService.createFAQ(faq);
    }
}

