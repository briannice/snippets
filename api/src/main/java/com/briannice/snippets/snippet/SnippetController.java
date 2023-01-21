package com.briannice.snippets.snippet;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/snippets")
@RequiredArgsConstructor
public class SnippetController {

    private final SnippetService snippetService;

    @GetMapping
    public ResponseEntity<List<Snippet>> getAllSnippets() {
        var snippets = snippetService.getAllSnippets();
        return ResponseEntity.ok().body(snippets);
    }

}
