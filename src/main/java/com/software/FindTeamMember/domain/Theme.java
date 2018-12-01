package com.software.FindTeamMember.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * created by wangzhi 2018-12-01 17:07
 **/
@Data
@Table(name = "theme")
@Entity
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @OneToMany(mappedBy = "theme")
    @JsonIgnore
    private List<Post> posts;

    @OneToMany(mappedBy = "theme")
    @JsonIgnore
    private List<Project> projects;

    @OneToMany(mappedBy = "theme")
    @JsonIgnore
    private List<ThemeNotice> notices;
}
