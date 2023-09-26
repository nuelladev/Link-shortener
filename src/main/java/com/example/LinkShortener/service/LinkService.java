package com.example.LinkShortener.service;

import com.example.LinkShortener.exception.BadRequestException;
import com.example.LinkShortener.exception.NotFoundException;
import com.example.LinkShortener.model.LinkModel;
import com.example.LinkShortener.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService {
    private final LinkRepository linkRepository;

    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Optional<LinkModel> createLink(LinkModel linkModel) {
        if (linkRepository.existsByAlias(linkModel.getAlias())) {
            throw new BadRequestException("Alias already exists");
        }
        System.out.println("Link Creation Request " + linkModel.toString());

        LinkModel postSaveLink = linkRepository.save(linkModel);
        System.out.println("Link Created: " + postSaveLink);

        return Optional.ofNullable(postSaveLink);
    }

    public LinkModel getLink(String alias) {
        LinkModel link = linkRepository.findByAlias(alias) // Corrected to use String parameter
                .orElseThrow(() -> new NotFoundException("Alias not found. Try creating it."));
        return link;
    }
}
