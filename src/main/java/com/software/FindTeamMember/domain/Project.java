package com.software.FindTeamMember.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * created by wangzhi 2018-12-01 18:59
 **/
@Data
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @ManyToMany
    @JoinTable(name = "project_member")
    private List<User> members;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<ProjectNotice> notices;
}
