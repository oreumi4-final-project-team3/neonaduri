package com.est.neonaduri.domain.bookers.domain;

import com.est.neonaduri.domain.companions.domain.Companions;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.global.utils.IdGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "BOOKERS")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bookers {
    @Id
    @Column(name = "BOOKER_ID", length = 100, nullable = false)
    private String bookerId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "COMPANION_ID", nullable = false)
    private Companions companions;

    @PrePersist
    public void prePersist(){
        this.bookerId = IdGenerator.generateBookerId();
    }
}
