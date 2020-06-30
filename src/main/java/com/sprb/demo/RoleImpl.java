package com.sprb.demo;

import org.springframework.stereotype.Component;

/**
 * @ClassName:RoleImpl
 * @Descripion: TODO
 * @Author:andy.ten@tom.com
 * @Date:2020/6/24 3:51 下午
 * @Version V1.0
 */
@Component
public class RoleImpl implements Role
{
  public RoleImpl()
  {

    System.out.println("role:hello");
  }

  @Override
  public void create()
  {
    System.out.println("create");
  }
}
