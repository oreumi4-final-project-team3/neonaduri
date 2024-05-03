package com.est.neonaduri.domain.userDetails.domain;

import com.est.neonaduri.domain.users.domain.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "USER_DETAILS")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
    @Id
    @Column(name = "DETAIL_ID", length = 100, nullable = false)
    private String wishId;

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
}
