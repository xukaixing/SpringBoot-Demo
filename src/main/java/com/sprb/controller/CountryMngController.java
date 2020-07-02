package com.sprb.controller;

import com.sprb.domain.Country;
import com.sprb.service.CountryMngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @version V1.0
 * @className:ContryMngController
 * @descripion: TODO
 * @author:andy.ten@tom.com
 * @date:2020/7/1 11:55 上午
 */
@Controller
public class CountryMngController
{
  private final CountryMngService countryMngService;

  @Autowired
  public CountryMngController(CountryMngService countryMngService)
  {
    this.countryMngService = countryMngService;
  }

  @GetMapping("/country")
  public String showCountryAll(ModelMap model)
  {
    List<Country> list = countryMngService.findAll();
    model.addAttribute("countrys", list);
    return "countryIndex";
  }
}
