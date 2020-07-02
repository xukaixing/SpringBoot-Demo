package com.sprb.service;

import com.sprb.domain.Country;
import com.sprb.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryMngServiceImpl implements CountryMngService
{
  private CountryRepository countryMngRepository;

  @Autowired
  public void setCountryMngRepository(@Qualifier("countryMngRepository") CountryRepository countryMngRepository)
  {
    this.countryMngRepository = countryMngRepository;
  }

  public Optional<Country> findById(Long id)
  {
    return countryMngRepository.findById(id);
  }

  @Override
  public void delete(Long id)
  {
    countryMngRepository.deleteById(id);
  }

  @Override
  public Country save(Country country)
  {
    return countryMngRepository.save(country);
  }

  @Override
  public List<Country> findAll()
  {
    return countryMngRepository.findAll();
  }

  @Override
  public Country update(Country country)
  {
    return countryMngRepository.save(country);
  }

  @Override
  public List<Country> findByCountryName(String countryName)
  {
    return countryMngRepository.findByCountryName(countryName);
  }

  public List<Country> findByCountryNameLike(String countryName)
  {
    return (List<Country>) countryMngRepository.findByCountryNameLike(countryName);
  }
}
