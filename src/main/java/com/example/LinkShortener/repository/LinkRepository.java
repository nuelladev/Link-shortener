package com.example.LinkShortener.repository;

import com.example.LinkShortener.model.LinkModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LinkRepository extends JpaRepository<LinkModel, Long> {
    Optional<LinkModel> findByAlias(String alias);
    Boolean existsByAlias(String alias);
}
