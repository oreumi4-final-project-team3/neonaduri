package com.est.neonaduri.posts.domain;

import java.time.LocalDateTime;

import com.est.neonaduri.users.domain.Users;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="POSTS")
public class Posts {

	@Id
	@Column(name="POST_ID", length = 100 ,nullable = false)
	private String postId;

	@ManyToOne
	@JoinColumn(name="WRITER_ID", referencedColumnName = "USER_ID", nullable = false)
	private Users users;

	@Column(name="POST_TITLE",length = 50 ,nullable = false)
	private String postTitle;

	@Column(name="POST_CONTENT",length = 1000 ,nullable = false)
	private String postContent;

	@Column(name="POST_SPOTNAME",length = 30 ,nullable = false)
	private String postSpotName;

	@Column(name="COM_VIEW" ,nullable = false)
	private int comView;

	@Column(name="CREATED" ,nullable = false)
	private LocalDateTime created;

	@Column(name="MODIFIED")
	private LocalDateTime modified;

}
