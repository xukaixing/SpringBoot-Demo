package com.sprb.service;

import com.sprb.domain.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CountryMngService
{
  Optional<Country> findById(Long id);

  void delete(Long id);

  Country save(Country user);

  List<Country> findAll();

  Country update(Country Country);

  List<Country> findByCountryName(String countryName);

  List<Country> findByCountryNameLike(String countryName);
}
