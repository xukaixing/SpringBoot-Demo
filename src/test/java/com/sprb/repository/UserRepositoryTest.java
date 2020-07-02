package com.sprb.repository;

import com.sprb.SprbDemoApplication;
import com.sprb.domain.User;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName:UserRepositoryTest
 * @Descripion: 测试类
 * @Author:andy.ten @tom.com
 * @Date:2020 /6/233:35 下午
 * @Version V1.0
 */
// 当一个类用@RunWith注释或继承一个用@RunWith注释的类时，JUnit将调用它所引用的类来运行该类中的测试而不是开发者去在junit内部去构建它。我们在开发过程中使用这个特性。
@RunWith(SpringRunner.class)
// 将SpringBoot主类中导入的bean或实体全都包含进来。
// 使用@SpringBootTest时并没有像@ContextConfiguration一样显示指定locations或classes属性，
// 原因在于@SpringBootTest注解会自动检索程序的配置文件，检索顺序是从当前包开始，
// 逐级向上查找被@SpringBootApplication或@SpringBootConfiguration注解的类。
@SpringBootTest(classes = {SprbDemoApplication.class})// 指定启动类
// 引入配置类，表明在测试单元可以使用JpaConfig扫描到到的所有bean即所有实体。
// @ContextConfiguration(classes = {JpaConfig.class, SprbDemoApplication.class})
// @Slf4j:在任意类上添加注解@Slf4j，可以在本类中任意方法内用log.打印日志了
@Slf4j
public class UserRepositoryTest
{
  // @resource:byName查找，如果byName查找不到，则通过byType
  // 当一个接口只有一个实现类，推荐使用@Autowired，默认byType注入，不一定 真的byType，可以修改为byName，@Resource同理；
  // 当一个接口有多个实现类，推荐使用@Resource，默认byName注入；
  // autowired require=ture 时，表示解析被标记的字段或方法，一定有对应的bean存在。
  // autowired require=false 时，表示解析被标记的字段或方法，没有对应的bean存在不会报错。
  // @Autowired(required = true)
  // @Qualifier("userRepository")
  // @Resource(name = "userRepository")
  @Resource
  private UserRepository userRepository;

  @Test
  public void test()
  {
    System.out.println("userRepository test starting...");
    Date data = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formattedDate = dateFormat.format(data);

    userRepository.deleteAll();

    userRepository.save(new User("aa", "aa123456", "aa@126.com", "aa", formattedDate));
    userRepository.save(new User("bb", "bb123456", "bb@126.com", "bb", formattedDate));
    userRepository.save(new User("cc", "cc123456", "cc@126.com", "cc", formattedDate));

    System.out.println("-----UserInfo-----" + userRepository.findByUserName("cc").toString());

    //断言判断
    TestCase.assertEquals(3, userRepository.findAll().size());
    TestCase.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "bb@126.com").getNickName());

    //Optional<List<User>> opt = Optional.of(Optional.ofNullable(userRepository.findByUserName("aa")).orElse(userRepository.findAll()));
    Optional<List<User>> opt = Optional.ofNullable(userRepository.findByUserName("aa"));
    opt.ifPresent(u -> userRepository.delete((User) u.get(0)));
  }
}
