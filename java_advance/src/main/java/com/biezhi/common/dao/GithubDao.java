package com.biezhi.common.dao;

import com.biezhi.common.model.Github;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GithubDao extends JpaRepository<Github, Long> {
}
