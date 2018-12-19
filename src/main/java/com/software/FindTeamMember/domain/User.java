package com.software.FindTeamMember.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * created by wangzhi 2018-12-01 16:38
 **/
@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "user_name")
    private String userName;

    private String password;

    private String email;

    /**
     * 个人简介
     */
    @Column(columnDefinition = "text")
    private String resume;

    @ManyToMany
    @JsonIgnore
    private List<User> attention;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="author")
    @JsonIgnore
    private List<Theme> themes;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Post> posts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserSkill> userSkills;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_need")
    private List<Skill> needSkills;

    @ManyToMany(mappedBy = "members")
    @JsonIgnore
    private List<Project> projects;
}
