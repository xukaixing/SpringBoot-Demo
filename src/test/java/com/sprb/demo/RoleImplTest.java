package com.sprb.demo;

import com.sprb.SprbDemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SprbDemoApplication.class})// 指定启动类
public class RoleImplTest
{
  @Autowired
  private Role role;

  @Test
  public void test()
  {
    role.create();
  }
}
