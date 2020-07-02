package com.sprb.repository;

import com.sprb.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @version V1.0
 * @className:CountryMngRepository
 * @descripion: TODO
 * @author:andy.ten@tom.com
 * @date:2020/7/1 11:56 上午
 */
@Repository("countryMngRepository")
public interface CountryRepository extends JpaRepository<Country, Long>
{
  List<Country> findByCountryName(String countryName);

  @Query(name = "findByCountryNameLike", value = "select * from tm_country where country_name like %:countryname% ", nativeQuery = true)
  List<Country> findByCountryNameLike(@Param("countryname") String countryname);

  @Modifying
  @Transactional
  @Query(name = "deleteByCountryCode", value = "delete from tm_country where country_code = :countrycode ", nativeQuery = true)
  void deleteByCountryCode(@Param("countrycode") String countrycode);
}
