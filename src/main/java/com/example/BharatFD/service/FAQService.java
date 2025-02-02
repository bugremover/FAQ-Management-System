package com.example.BharatFD.service;



import com.example.BharatFD.model.FAQ;
import com.example.BharatFD.repository.FAQRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FAQService {
    private final FAQRepository faqRepository;
    private final TranslationService translationService;

    public FAQService(FAQRepository faqRepository, TranslationService translationService) {
        this.faqRepository = faqRepository;
        this.translationService = translationService;
    }

    public FAQ createFAQ(FAQ faq) {
        faq.setQuestionHi(translationService.translateText(faq.getQuestion(), "hi"));
        faq.setQuestionBn(translationService.translateText(faq.getQuestion(), "bn"));
        return faqRepository.save(faq);
    }

    @Cacheable(value = "faqs")
    public List<FAQ> getAllFAQs() {
        return faqRepository.findAll();
    }
}
