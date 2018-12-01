package com.software.FindTeamMember.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * created by wangzhi 2018-12-01 18:24
 **/
@Entity
@Table(name = "user_skill")
@Data
public class UserSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    /**
     * 对技能的熟悉程度
     */
    private int Familiarity;
}
