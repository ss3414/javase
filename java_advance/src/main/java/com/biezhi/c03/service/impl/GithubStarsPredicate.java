package com.biezhi.c03.service.impl;

import com.biezhi.c03.service.GithubPredicate;
import com.biezhi.common.model.Github;

public class GithubStarsPredicate implements GithubPredicate {

    private Integer stars;

    public GithubStarsPredicate(Integer stars) {
        this.stars = stars;
    }

    @Override
    public boolean condition(Github github) {
        return github.getStars() >= stars;
    }

}
