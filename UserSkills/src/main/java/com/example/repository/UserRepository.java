package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "select user_id from user_skill  where skill_id=:id", nativeQuery = true)
	List<Integer> findBySkillSkillId(int id);

	@Query(value = "select * from user where user_id IN (:skills)", nativeQuery = true)
	List<User> findBySkillId(List<Integer> skills);

	@Query("select u from User u join u.skills s where s.skillName=:skillName")
	List<User> getBySkillsSkillName(@Param("skillName") String skillName);

}
