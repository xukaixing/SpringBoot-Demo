package com.sprb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version V1.0
 * @className:UserMngController
 * @descripion: 用户管理控制
 * @author:andy.ten@tom.com
 * @date:2020/6/29 3:59 下午
 */
// 在Spring中@RestController的作用等同于@Controller + @ResponseBody;
// @Controller注解，表明了这个类是一个控制器类
@RestController
// @RequestMapping注解是用来映射请求的，即指明可以处理哪些URL请求，该注解既可以用在类上，也可以用在方法上。
// 当使用@RequestMapping标记控制器类时，方法的请求地址是相对类的请求地址而言的；
// 当没有使用@RequestMapping标记类时，请求地址是http://localhost:8888/sprb/searchusers
@RequestMapping("/usermng")
public class UserMngController
{
  @RequestMapping("/sayhello")
  public void sayHello()
  {
    System.out.println("sayHello!");
  }

  // @ResponseBody 表示该方法的返回结果直接写入 HTTP response body 中，不做页面跳转；
  @RequestMapping("/searchusers")
  @ResponseBody
  public String searchUserList()
  {
    // 不跳转页面，输出返回值；一般通过ajax请求获取json数据采用这种方式
    return "users list";
  }
}
