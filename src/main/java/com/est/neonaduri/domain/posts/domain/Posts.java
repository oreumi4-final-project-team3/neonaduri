package com.est.neonaduri.domain.posts.domain;

import java.time.LocalDateTime;
import com.est.neonaduri.domain.users.domain.Users;
import com.est.neonaduri.global.config.BaseTimeEntity;
import com.est.neonaduri.global.utils.IdGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="POSTS")
public class Posts extends BaseTimeEntity {
	@Id
	@Column(name="POST_ID", length = 100 ,nullable = false)
	private String postId;

	@ManyToOne
	@JoinColumn(name="WRITER_ID", referencedColumnName = "USER_ID", nullable = false)
	private Users users;

	@Column(name="POST_CATEGORY",length = 20, nullable = false)
	private String postCategory;

	@Column(name="POST_TITLE",length = 50 ,nullable = false)
	private String postTitle;

	@Column(name="POST_CONTENT",length = 3000 ,nullable = false)
	private String postContent;

	@Column(name="POST_VIEW" ,nullable = false)
	private Integer postView;

	@Column(name="AREA_CODE")
	private Integer areaCode;

	@Column(name="SPOTNAME",length = 30 ,nullable = false)
	private String spotName;

	@Column(name="ADDR", length = 50)
	private String address;

	@CreatedDate
	@Column(name="CREATED" ,nullable = false)
	private LocalDateTime created;

	@Column(name="MODIFIED")
	private LocalDateTime modified;

	//Default 초기화
	@PrePersist
	public void prePersist(){
		this.postId = IdGenerator.generatePostId(this.postCategory);
		this.postView = this.postView == null ? 0 : this.postView;
	}

	public void update(String title, String content){
		this.postTitle = title;
		this.postContent = content;
	}
}
