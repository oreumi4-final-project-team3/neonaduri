package com.est.neonaduri.domain.userDetails.domain;

import com.est.neonaduri.domain.userDetails.dto.UserDetailsRequestDto;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.global.utils.IdGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "USER_DETAILS")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
    @Id
    @Column(name = "DETAIL_ID", length = 100, nullable = false)
    private String detailId;

    @OneToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private Users users;

    @Column(name = "USER_MBTI")
    private String userMbti;

    @Column(name = "USER_STYLE")
    private String userStyle;

    @Column(name = "USER_INTRO")
    private String userIntro;

    @Column(name = "QUESTION")
    private String question;

    @Column(name = "ANSWER")
    private String answer;

    public void update(UserDetailsRequestDto request){
        this.userMbti = request.getMbti();
        this.userStyle = request.getStyle();
        this.userIntro = request.getIntro();
    }

    @PrePersist
    public void prePersist(){
        this.detailId = IdGenerator.generateUserDetailsId();
    }
}
