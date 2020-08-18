package com.erguotou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Book {
    @Id
    @GeneratedValue(
//            标记主键由数据库自动生成
            strategy = GenerationType.IDENTITY
    )
//    属性或方法级别的注解，用于指定持久化属性映射到数据库表的列。
    @Column(name = "id")
    int id;

//    表示一个多对一的映射,该注解标注的属性通常是数据库表的外键
    @ManyToOne
//    @JoinColumn和@Column类似,介量描述的不是一个简单字段,而一一个关联字段,例如.描述一个@ManyToOne的字段.
    @JoinColumn(name = "cid")
    private Category category;

    String cover;
    String title;
    String author;
    String date;
    String press;
    String abs;

}
