package com.biezhi.c03.service.impl;

import com.biezhi.c03.service.GithubPredicate;
import com.biezhi.common.model.Github;

public class GithubLanguagePredicate implements GithubPredicate {

    private String language;

    public GithubLanguagePredicate(String language) {
        this.language = language;
    }

    @Override
    public boolean condition(Github github) {
        return language.equals(github.getLanguage());
    }

}
