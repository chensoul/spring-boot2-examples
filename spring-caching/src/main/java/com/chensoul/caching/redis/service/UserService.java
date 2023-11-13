package com.chensoul.caching.redis.service;

import com.chensoul.caching.redis.model.User;
import com.chensoul.caching.redis.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public User getById(Long id) {
		return userRepository.getById(id);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

}
