package com.sprb.service;

import com.sprb.domain.User;
import com.sprb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @version V1.0
 * @className:UserMngServiceImpl
 * @descripion: 用户管理服务类
 * @author:andy.ten@tom.com
 * @date:2020/6/29 6:36 下午
 */

@Service
public class UserMngServiceImpl implements UserMngService
{
  // filed注入，不推荐该方式，可以使用@Resource注解
  // @Autowired
  // private UserMngDao userMngDao;

  // setter注入，非强制依赖的类可以使用setter方式
  // private UserMngDao userMngDao;
  // @Autowired
  // public void setUserMngDao(UserMngDao userMngDao)
  // {
  //   this.userMngDao = userMngDao;
  // }

  // 构造器方式注入；强制依赖的类使用构造器方式注入，如果需要注入的bean很多，构造函数方式不适用
  private final UserRepository userMngDao;

  @Autowired
  public UserMngServiceImpl(@Qualifier("userRepository") UserRepository sUserMngDao)
  {
    this.userMngDao = sUserMngDao;
  }

  public Optional<User> findById(Long id)
  {
    return userMngDao.findById(id);
  }

  @Override
  public void delete(Long id)
  {
    userMngDao.deleteByUserId(id);
  }

  @Override
  public User save(User user)
  {
    return userMngDao.save(user);
  }

  @Override
  public Page<User> findAll(int page, int pagesize)
  {
    Pageable pageable = PageRequest.of(page, pagesize);
    return userMngDao.findAll(pageable);
  }

  public List<User> findAll()
  {
    return userMngDao.findAll();
  }

  @Override
  public User update(User user)
  {
    return userMngDao.save(user);
  }

  @Override
  public List<User> findByUserName(String userName)
  {
    return userMngDao.findByUserName(userName);
  }

  public List<User> findByUserNameLike(String userName)
  {
    return (List<User>) userMngDao.findByUserNameLike(userName);
  }
}
