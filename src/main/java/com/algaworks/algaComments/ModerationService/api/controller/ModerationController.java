package com.algaworks.algaComments.ModerationService.api.controller;

import com.algaworks.algaComments.ModerationService.api.model.ModerationInput;
import com.algaworks.algaComments.ModerationService.api.model.ModerationOutput;
import com.algaworks.algaComments.ModerationService.domain.service.ModerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/moderate")
@RequiredArgsConstructor
public class ModerationController {

    private final ModerationService moderationService;

    @PostMapping
    public ModerationOutput moderate(@RequestBody ModerationInput request) {
        return moderationService.moderate(request);
    }
}
