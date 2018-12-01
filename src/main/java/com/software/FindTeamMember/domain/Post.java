package com.software.FindTeamMember.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * created by wangzhi 2018-12-01 18:16
 **/
@Data
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "text")
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @Column(name = "create_time")
    private Timestamp createTime;
}
