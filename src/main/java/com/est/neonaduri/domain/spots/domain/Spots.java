package com.est.neonaduri.domain.spots.domain;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.global.config.BaseTimeEntity;
import com.est.neonaduri.global.utils.IdGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="SPOTS")
public class Spots extends BaseTimeEntity {

	@Id
	@Column(name="SPOT_ID", length = 100 ,nullable = false)
	private String spotId;

	@OneToOne
	@JoinColumn(name = "POST_ID", nullable = false)
	private Posts posts;

	@Column(name="SPOT_TYPE",nullable = false)
	private Long spotType;

	@Column(name="SPOT_IMG", length = 255 ,nullable = false)
	private String spotImg;

	@Column(name="MAP_Y",nullable = false)
	private double mapY;

	@Column(name="MAP_X",nullable = false)
	private double mapX;


	@PrePersist
	public void prePersist(){
		this.spotId= IdGenerator.generateSpotId(getSpotId());
	}

}
