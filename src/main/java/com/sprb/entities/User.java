package com.sprb.entities;

import lombok.*;

import javax.persistence.*;

/**
 * @ClassName:User
 * @Descripion: User实体类
 * @Author:andy.ten@tom.com
 * @Date:2020/6/22 6:30 下午
 * @Version V1.0
 */
// @Entity(name="EntityName") entity的name属性来表明对应数据库表的表名，默认为当前类名
// 如果定义了Entity的name属性，就不能定义@Table，反之，定义了@Table，就不需要@Entity的name属性
@Entity
// 当实体类与其映射的数据库表名不同名时需要使用 @Table注解说明,@Table注解的常用选项是 name，用于指明数据库的表名
//　　　　　　@Table注解还有两个选项 catalog 和 schema 用于设置表所属的数据库目录或模式，通常为数据库名
// @Table(name = "xwj_user", schema = "test")
// 如果缺省@Table注解，则class字段名即表中的字段名，所以需要@Column注解来改变class中字段名与db中表的字段名的映射规则
@Table(name = "tm_user", schema = "sprbdemo")
// @Getter/@Setter: Lombok注解，作用类上，生成所有成员变量的getter/setter方法；作用于成员变量上，生成该成员变量的getter/setter方法。可以设定访问权限及是否懒加载等。
// el.@Getter(value = AccessLevel.PUBLIC):getter方法访问权限为publick
// @Getter
// @Setter
// lombok的@Data注解，除了能自动生成全部属性的set、get方法以外，还生成了ToString、equals等方法
@Data
// @ToString：作用于类，覆盖默认的toString()方法，可以通过of属性限定显示某些字段，通过exclude属性排除某些字段。
// @ToString(of = {"userId","userName",exclude={passWord}}
@ToString(exclude = {"passWord"})
public class User
{
  // @Id 必须，@Id 定义了映射到数据库表的主键的属性，一个实体只能有一个属性被映射为主键
  @Id
  // @GeneratedValue(strategy=GenerationType，generator="") 可选，strategy: 表示主键生成策略，有 AUTO、INDENTITY、SEQUENCE 和 TABLE 4 种，分别表示让 ORM 框架自动选择，generator: 表示主键生成器的名称。
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // @NonNull：主要作用于成员变量和参数中，标识不能为空，否则抛出空指针异常。
  @NonNull
  private Long userId; //userId将自动转换为：user_id

  // @Column注释定义了将成员属性映射到关系表中的哪一列和该列的结构信息，属性如下：
//    　　1）name：映射的列名。如：映射tbl_user表的name列，可以在name属性的上面或getName方法上面加入；
//    　　2）unique：是否唯一；
//    　　3）nullable：是否允许为空；
//    　　4）length：对于字符型列，length属性指定列的最大字符长度；
//    　　5）insertable：是否允许插入；
//    　　6）updatetable：是否允许更新；
//    　　7）columnDefinition：定义建表时创建此列的DDL；
//    　　8）secondaryTable：从表名。如果此列不建在主表上（默认是主表），该属性定义该列所在从表的名字
  @Column(nullable = false, unique = true, length = 60)
  // 对应自动生成列名：user_name
  private String userName;

  @Column(name = "password", nullable = false)
  private String passWord;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = true, unique = true)
  private String nickName;

  @Getter
  @Setter
  @Column(name = "reg_time", nullable = false)
  private String regTime;

  public User(String userName, String passWord, String email, String nickName, String regTime)
  {
    this.userName = userName;
    this.passWord = passWord;
    this.email = email;
    this.nickName = nickName;
    this.regTime = regTime;
  }

  public User()
  {
  }
  // getter, setter
}
