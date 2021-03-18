package com.biezhi.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "github")
public class Github {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String href;

    private String author;

    private String language;

    private Integer stars;

    private String intro;

    private String topics;

    private String createTime;

    private String module;

    @Transient
    private Optional<Github> github;

    public Github(Long id) {
        this.id = id;
    }

}
