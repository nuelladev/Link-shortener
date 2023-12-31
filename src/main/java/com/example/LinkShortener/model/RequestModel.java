package com.example.LinkShortener.model;

import jakarta.validation.constraints.NotNull;

public class RequestModel {

    @NotNull
    private String alias;
    @NotNull
    private String url;

    public RequestModel(final String alias, final String url) {
        this.alias = alias;
        this.url = url;
    }

    public String getAlias() {
        return alias;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "RedirectCreationRequest{" +
                "alias='" + alias + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}