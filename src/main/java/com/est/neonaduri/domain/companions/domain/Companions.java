package com.est.neonaduri.domain.companions.domain;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.global.config.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "COMPANIONS")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Companions extends BaseTimeEntity {
    @Id
    @Column(name = "COMPANION_ID", length = 100, nullable = false)
    private String companionId;

    @OneToOne
    @JoinColumn(name = "POST_ID", nullable = false)
    private Posts posts;

    @Column(name = "COM_STATUS")
    private Boolean comStatus;

    @Column(name = "COM_RECRUIT")
    private Integer comRecruit;

    @Column(name = "COM_WISH", nullable = false)
    private Integer comWish;

    @Column(name = "COM_START", nullable = false)
    private LocalDateTime comStart;

    @Column(name = "COM_END", nullable = false)
    private LocalDateTime comEnd;
}
