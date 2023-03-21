package com.kosa.myapp.domain;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SequenceGenerator(
		name="SEQ_GENERATOR",
		sequenceName="SEQ_MEMBER",
		initialValue=1,
		allocationSize=1)
@Entity
@Table(name="tb_member")
@Getter
@Setter
public class MemberDto {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GENERATOR")
	private int member_id;
	
	@Column(name="user_id", length=40, nullable=false)
	private String user_id;
	
	@Column(name="password", length=40, nullable=false)
	private String password;
	
	@Column(name="user_name", length=40, nullable=false)
	private String user_name;
	
	@Column(name="email", length=40, nullable=false)
	private String email;
	
	@Column(name="phone", length=40, nullable=false)
	private String phone;
	
	private LocalDateTime regdate=LocalDateTime.now();
}
