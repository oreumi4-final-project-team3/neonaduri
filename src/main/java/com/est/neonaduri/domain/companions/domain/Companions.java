package com.est.neonaduri.domain.companions.domain;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.global.utils.IdGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "COMPANIONS")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Companions {
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
    private LocalDate comStart;

    @Column(name = "COM_END", nullable = false)
    private LocalDate comEnd;

    @Column(name = "COM_RESERVE", nullable = false)
    private Integer comReserve;

    @PrePersist
    public void prePersist(){
        this.companionId = IdGenerator.generateCompanionId();
        //this.comStatus = this.comStatus == null ? false : this.comStatus;
        this.comStatus = true;
        this.comWish = this.comWish == null ? 0 : this.comWish;
        this.comReserve = this.comReserve == null ? 0 : this.comReserve;
    }

    public void updateBook(Integer reserved){
        this.comReserve = reserved;
        if(this.comReserve == this.comRecruit){
            this.comStatus = false;
        }
    }

    public void updateWishList(Integer wished){
        this.comWish = wished;
    }
}