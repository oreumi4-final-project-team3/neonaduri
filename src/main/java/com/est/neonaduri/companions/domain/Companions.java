package com.est.neonaduri.companions.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "POST_COMPANIONS")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Companions {

    @Id
    @Column(name = "COMPANION_ID", length = 100, nullable = false)
    private String companionId;

    @Column(name = "POST_ID", length = 100, nullable = false)
    private String postId;

    @Column(name = "WRITER_ID", length = 100, nullable = false)
    private String writerId;

    @Column(name = "ADDR1", length = 30, nullable = false)
    private String addr1;

    @Column(name = "ADDR2", length = 30, nullable = false)
    private String addr2;

    @Column(name = "ADDR3", length = 30, nullable = false)
    private String addr3;

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
