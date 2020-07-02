package com.sprb.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

/**
 * @version V1.0
 * @className:Country
 * @descripion: TODO
 * @author:andy.ten@tom.com
 * @date:2020/7/1 11:52 上午
 */
@Entity
@Table(name = "tm_country", schema = "sprbdemo")
@Data
public class Country
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long countryId;
  @NonNull
  private String countryName;
  @NonNull
  private String countryCode;

  public Country()
  {
  }
}
