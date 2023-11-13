package com.chensoul.caching.redis;

import com.chensoul.caching.redis.config.CacheingRedisConfig;
import com.chensoul.caching.redis.model.User;
import com.chensoul.caching.redis.repository.UserRepository;
import com.chensoul.caching.redis.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Import({CacheingRedisConfig.class, UserService.class})
@ExtendWith(SpringExtension.class)
@ImportAutoConfiguration(classes = {CacheAutoConfiguration.class, RedisAutoConfiguration.class})
@EnableCaching
class UserServiceCachingIntegrationTest {
	final Long id = 1L;

	@MockBean
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private CacheManager cacheManager;

	@Test
	void givenRedisCaching_whenFindItemById_thenItemReturnedFromCache() {
		User user = new User("admin");
		user.setId(id);
		userService.save(user);

		given(userRepository.findById(id))
			.willReturn(Optional.of(user));

		User userCacheMiss = userService.getById(id);
		User userCacheHit = userService.getById(id);

		assertThat(userCacheMiss).isEqualTo(user);
		assertThat(userCacheHit).isEqualTo(user);

		verify(userRepository, times(1)).findById(id);
		assertThat(userFromCache()).isEqualTo(user);
	}

	private Object userFromCache() {
		return cacheManager.getCache("userCache").get(id).get();
	}

	@TestConfiguration
	static class EmbeddedRedisConfiguration {

		private final RedisServer redisServer;

		public EmbeddedRedisConfiguration() {
			this.redisServer = new RedisServer();
		}

		@PostConstruct
		public void startRedis() {
			redisServer.start();
		}

		@PreDestroy
		public void stopRedis() {
			this.redisServer.stop();
		}
	}

}
