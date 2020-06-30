package com.sprb.demo;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Optional;

/**
 * @version V1.0
 * @className:OptionalImplTest
 * @descripion: Optional测试类
 * @author:andy.ten@tom.com
 * @date:2020/6/29 7:24 下午
 */
public class OptionalImplTest
{
  @Test
  public void whenCreateOfNullableOptional_thenOk()
  {
    String name = "John";
    // 通过of方法所构造出的Optional对象
    // 当value值为空时，会报NullPointerException异常
    // 当value值不为空时，正常构造Optional对象
    Optional<String> opt = Optional.of(name);
    // 通过ofNullable方法构造Optional的对象
    // 如果value为空，那么返回empty方法构建的Optional对象（一个Optional中value为空的Optional对象）,
    // 也就是说ofNullable支持空值得创建
    Optional<String> opt1 = Optional.ofNullable(name);
    //get方法就是返回Optional中的value属性
    TestCase.assertEquals("John", opt.get());
    // isPresent方法判断Optional中的value是否为空，不为空返回true；
    // ifPresent方法是在Optional中value不为空的情况下做一些操作。
    // orElse和orElseGet以及orElseThrow都是处理Optional值为空的情况，如果传入的value为空，进行操作，orElseThrow在value为空的情况抛出异常
  }
}
