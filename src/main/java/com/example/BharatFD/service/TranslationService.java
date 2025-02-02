package com.example.BharatFD.service;



import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import org.springframework.stereotype.Service;

@Service
public class TranslationService {
    private final Translate translate = TranslateOptions.getDefaultInstance().getService();

    public String translateText(String text, String targetLang) {
        Translation translation = translate.translate(text, Translate.TranslateOption.targetLanguage(targetLang));
        return translation.getTranslatedText();
    }
}
