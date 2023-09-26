package com.example.LinkShortener.controller;

import com.example.LinkShortener.exception.BadRequestException;
import com.example.LinkShortener.model.LinkModel;
import com.example.LinkShortener.model.RequestModel;
import com.example.LinkShortener.service.LinkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/links")
public class LinkController {

    private LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/{alias}")
    public ResponseEntity<?> handleRedirect(@PathVariable String alias) throws URISyntaxException {
        LinkModel link = linkService.getLink(alias);
        System.out.println("Redirecting to: " + link.getUrl());
        URI uri = new URI(link.getUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping("/create-link")
    public ResponseEntity<?> createLink(@Valid @RequestBody RequestModel requestModel) {
        LinkModel linkModel = new LinkModel(requestModel.getAlias(), requestModel.getUrl());
        try {
            Optional<LinkModel> createdLink = linkService.createLink(linkModel);
            return ResponseEntity.ok(createdLink);
        } catch (BadRequestException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
