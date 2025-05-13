package com.algaworks.algaComments.ModerationService.domain.service;

import com.algaworks.algaComments.ModerationService.api.model.ModerationInput;
import com.algaworks.algaComments.ModerationService.api.model.ModerationOutput;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ModerationService {

    private static final List<String> BANNED_WORD = List.of("ódio", "xingamento", "PT", "php");

    public ModerationOutput moderate(ModerationInput request) {
        String text = request.getText().toLowerCase();

        Set<String> bannedWordsFound = new HashSet<>();

        for (String word : BANNED_WORD) {
            if (text.contains(word.toLowerCase())) {
                bannedWordsFound.add(word);
            }
        }

        if (!bannedWordsFound.isEmpty()) {
            return  ModerationOutput.builder()
                    .approved(false)
                    .reason("Contém palavras proibidas: " + bannedWordsFound)
                    .build();
        }

        return ModerationOutput.builder()
                .approved(true)
                .reason("Comentário aprovado!")
                .build();
    }

}
