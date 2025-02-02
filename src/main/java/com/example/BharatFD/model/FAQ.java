package com.example.BharatFD.model;



import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "faqs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FAQ {
    @Id
    private String id;
    private String question;
    private String answer; // CKEditor formatted answer
    private String questionHi;
    private String questionBn;
}

