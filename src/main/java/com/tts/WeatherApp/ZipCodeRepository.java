package com.tts.WeatherApp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipCodeRepository extends CrudRepository<ZipCode, Long> {
	List<ZipCode> findAll();
	List<ZipCode> findTop10ByOrderByCreatedAtDesc();
	ZipCode findByzipCode(String zipCode);

}