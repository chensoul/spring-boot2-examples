package com.chensoul.caching.allkeys.boot;

import com.chensoul.allkeys.AllKeysConfig;
import com.chensoul.allkeys.SlowServiceWithCache;
import com.github.benmanes.caffeine.cache.Cache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = AllKeysConfig.class)
public class GetAllCacheKeysIntegrationTest {

    @Autowired
    private SlowServiceWithCache slowServiceWithCache;
    @Autowired
    private CacheManager cacheManager;

    @Test
    public void givenCaffeineCacheCachingSlowCalls_whenCacheManagerProperlyCasted_thenAllKeysAreAccessible() {
        slowServiceWithCache.save("first", "some-value-first");
        slowServiceWithCache.save("second", "other-value-second");

        Cache<Object, Object> caffeine = getNativeCaffeineCacheForSlowService();

        assertThat(caffeine.asMap().keySet()).containsOnly("first", "second");
    }

    private Cache<Object, Object> getNativeCaffeineCacheForSlowService() {
        CaffeineCacheManager caffeineCacheManager = (CaffeineCacheManager) cacheManager;
        CaffeineCache cache = (CaffeineCache) caffeineCacheManager.getCache("slowServiceCache");
        return cache.getNativeCache();
    }
}
