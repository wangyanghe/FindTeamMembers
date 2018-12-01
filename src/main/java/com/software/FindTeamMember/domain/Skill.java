package com.software.FindTeamMember.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * created by wangzhi 2018-12-01 17:28
 **/
@Data
@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


}
