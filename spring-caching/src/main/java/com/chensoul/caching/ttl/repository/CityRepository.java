package com.chensoul.caching.ttl.repository;

import com.chensoul.caching.ttl.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {}
