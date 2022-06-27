package com.example.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.SkillRepository;
import com.example.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SkillRepository skillRepository;

	@Override
	public List<User> fetchUserList() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public List<User> insertListUser(List<User> user) {
		log.info("user {}", user);
		return userRepository.saveAll(user);
	}

	@Override
	public User updateUser(User user, int id) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAllByskillId(int id) {
		List<Integer> Skills = userRepository.findBySkillSkillId(id);
		if (!Objects.isNull(Skills)) {
			List<User> userList = userRepository.findBySkillId(Skills);
			return userList;
		}
		return null;
	}

	@Override
	public List<User> findAllByskillName(String skillName) {
		return userRepository.getBySkillsSkillName(skillName);
	}

	@Override
	public Page<User> getUserPagination(Integer pageNumber, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return userRepository.findAll(pageable);
	}

}
