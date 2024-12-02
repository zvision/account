package com.alaf.account.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "m_konto")
@AllArgsConstructor
@NoArgsConstructor
public @Data class Account {

	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "uid", nullable = false)
	private String uid;

	@Column(name = "pwd", nullable = false)
	private String pwd;

}
