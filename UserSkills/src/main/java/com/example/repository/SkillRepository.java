package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
