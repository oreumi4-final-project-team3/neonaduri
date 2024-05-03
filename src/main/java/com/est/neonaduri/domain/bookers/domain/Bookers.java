package com.est.neonaduri.domain.bookers.domain;

import com.est.neonaduri.domain.companions.domain.Companions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "BOOKERS")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bookers {
    @Id
    @Column(name = "BOOKER_ID", length = 100, nullable = false)
    private String bookerId;

    @ManyToOne
    @JoinColumn(name = "COMPANION_ID", nullable = false)
    private Companions companions;
}