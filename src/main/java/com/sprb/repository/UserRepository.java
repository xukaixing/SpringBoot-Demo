package com.sprb.repository;

import com.sprb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

// 其实默认的spring中的Bean id 为 userRepository(首字母小写)
// @Repository是@Component的派生，所以@Repository注解的类，通过@Autowired也可以从容器中查找
// 实现DAO访问，用于标注数据访问层，也可以说用于标注数据访问组件，即DAO组件
// JPA会在工程启动的时候自动实例化JPA接口仓库，便于注入的时候引用
// @Repository参数表明把这个bean命名为：userRepository，实际有2个名字的bean，一个是userRepository，另一个是默认的userMngDao
@Repository("userRepository")
// extends JpaRepository<实体类, 主键类型>
public interface UserRepository extends JpaRepository<User, Long>
{
  // JPA 可以根据接口方法名来实现数据库操作，主要的语法是 findXXBy、readAXXBy、queryXXBy、countXXBy、getXXBy 后面跟属性名称，利用这个功能仅需要在定义的 Repository 中添加对应的方法名即可，使用时 Spring Boot 会自动帮我们实现.
  // 也可以加一些关键字 And、or：
  User findByUserNameOrEmail(String userName, String email);

  // 匹配的列名必须遵循camelCase方式
  List<User> findByUserName(String userName);

  User findByUserId(Long id);

  void deleteByUserId(Long id);

  Long countByUserName(String userName);

  List<User> findByEmailLike(String email);

  User findByUserNameIgnoreCase(String userName);

  List<User> findByUserNameOrderByEmailDesc(String email);

  // @Query注解用来自定义SQL语句，name是方法名，
  // nativeQuery = true时，可以执行原生sql语句，所谓原生sql，也就是说这段sql拷贝到数据库中，然后把参数值给一下就能运行了。
  // value是自定义的SQL语句。
  // @Param用来参数绑定
  @Query(name = "findByUserNameLike", value = "select * from tm_user where user_name like %:username% ", nativeQuery = true)
  List<User> findByUserNameLike(@Param("username") String username);

  //使用delete和update，必须使用@Modifying和@Transactional，告诉jpa这是更新操作
  @Modifying
  @Transactional
  @Query(name = "deleteByUserName", value = "delete from tm_user where user_name = :username ", nativeQuery = true)
  void deleteByUserNames(@Param("username") String username);

  //Page<User> findALL(Pageable pageable);
}
