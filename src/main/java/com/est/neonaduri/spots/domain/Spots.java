package com.est.neonaduri.spots.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="SPOTS")
public class Spots {

	@Id
	@Column(name="SPOT_ID", length = 100 ,nullable = false)
	private String spotId;

	@Column(name="AREA_CODE",nullable = false)
	private int areaCode;

	@Column(name="SPOT_TYPE",nullable = false)
	private int spotType;

	@Column(name="SPOT_IMG", length = 255 ,nullable = false)
	private String spotImg;

	@Column(name="MAP_Y",nullable = false)
	private double mapY;

	@Column(name="MAP_X",nullable = false)
	private double mapX;

	@Column(name="SPOT_NAME", length = 255 ,nullable = false)
	private String spotName;

	@Column(name="DISTANCE",nullable = false)
	private double distance;

	@Column(name="SPOT_OVERVIEW", length = 500 ,nullable = false)
	private String spotOverview;

	@Column(name="SPOT_ADDR", length = 50 ,nullable = false)
	private String spotAddr;

}