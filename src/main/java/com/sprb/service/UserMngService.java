package com.sprb.service;

import com.sprb.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserMngService
{
  Optional<User> findById(Long id);

  void delete(Long id);

  User save(User user);

  Page<User> findAll(int page, int pagesize);

  User update(User user);

  List<User> findByUserName(String userName);

  List<User> findByUserNameLike(String userName);
}
