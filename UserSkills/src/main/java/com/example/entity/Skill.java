package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "skills")
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "skill_id")
	private Integer skillId;

	@Column(name = "skill_name")
	private String skillName;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "skills", cascade = CascadeType.ALL)
	private List<User> users;

}
