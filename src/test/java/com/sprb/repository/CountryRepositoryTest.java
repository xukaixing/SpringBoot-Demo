package com.sprb.repository;

import com.sprb.SprbDemoApplication;
import com.sprb.domain.Country;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SprbDemoApplication.class})
@Slf4j
public class CountryRepositoryTest
{
  //private static final Logger logger = LoggerFactory.getLogger(CountryRepositoryTest.class);

  @Resource
  CountryRepository countryRepository;

  @Before
  public void createCountry()
  {
    countryRepository.deleteByCountryCode("86");
    Country country = new Country();
    country.setCountryCode("86");
    country.setCountryName("中国");
    countryRepository.save(country);
    assert country.getCountryId() > 0 : "create error";
  }

  @Test
  public void getCountryAll()
  {
    Optional<List<Country>> opt = Optional.of(countryRepository.findAll());

    for (Country country : opt.get())
    {
      log.info("------ country name = {}", country.getCountryName() + " ------");
    }
  }
}
