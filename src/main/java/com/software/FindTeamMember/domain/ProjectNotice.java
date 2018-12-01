package com.software.FindTeamMember.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * created by wangzhi 2018-12-01 20:02
 **/
@Data
@Entity
@Table(name = "project_notice")
public class ProjectNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "text")
    private String content;

    @Column(name = "create_time")
    private Timestamp createTime;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
