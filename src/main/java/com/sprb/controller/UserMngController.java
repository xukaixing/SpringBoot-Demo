package com.sprb.controller;

import com.sprb.entities.User;
import com.sprb.service.UserMngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

/**
 * @version V1.0
 * @className:UserMngController
 * @descripion: 用户管理控制
 * @author:andy.ten@tom.com
 * @date:2020/6/29 3:59 下午
 */
// @Controller注解，表明了这个类是一个控制器类
// 在Spring中@RestController的作用等同于@Controller + @ResponseBody;
// 返回json、字符串等格式数据不需要在方法前面加@ResponseBody注解了，
// 但使用@RestController这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面。

//@Controller
@RestController

// @RequestMapping注解是用来映射请求的，即指明可以处理哪些URL请求，该注解既可以用在类上，也可以用在方法上。
// 当使用@RequestMapping标记控制器类时，方法的请求地址是相对类的请求地址而言的；
// 当没有使用@RequestMapping标记类时，请求地址是http://localhost:8888/sprb/searchusers
@RequestMapping("/usermng")
public class UserMngController
{
  private UserMngService userMngService;

  @Autowired
  public void setUserMngService(UserMngService userMngService)
  {
    this.userMngService = userMngService;
  }

  //@RequestMapping("/sayhello")
  @PutMapping("/sayHello")
  public void sayHello()
  {
    System.out.println("sayHello!");
  }

  // @ResponseBody 表示该方法的返回结果直接写入 HTTP response body 中，不做页面跳转；
  //@RequestMapping("/searchusers")
  //@ResponseBody

  @PutMapping("/insertUser")
  public User insertUser(User user)
  {
    return userMngService.save(user);
  }

  @PostMapping("/updateUser")
  public User updateUser(User user)
  {
    return userMngService.save(user);
  }

  @GetMapping("/findUsersByPage")
  public Page<User> findUsersByPage(Integer page, HttpServletResponse response)
  {
    //跨域请求，*：允许所有域名的脚本访问该资源。
    //https://localhost:8888/sprb：允许指定域访问该资源
    response.setHeader("Access-Control-Allow-Origin", "*");
    if (page == null || page <= 0)
    {
      page = 0;
    } else
    {
      page -= 1;
    }
    return userMngService.findAll(page, 5);
  }

  @DeleteMapping("/delUser/{id}")
  public String delUser(@PathVariable Long id)
  {
    userMngService.delete(id);
    return "delete user sucesss";
  }

  @GetMapping("/findUserById/{id}")
  public Optional<User> findUserById(@PathVariable("id") Long id) throws Exception
  {
    return userMngService.findById(id);
  }

  @GetMapping("/findUserByUserName/{username}")
  public List<User> findUserByUserName(@PathVariable("username") String username)
  {
    System.out.println("------@PathVariable:" + username + "------");
    return userMngService.findByUserNameLike(username);
  }
}
