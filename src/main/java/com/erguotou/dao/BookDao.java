package com.erguotou.dao;

import com.erguotou.pojo.Book;
import com.erguotou.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {
//    category 对象的 id 属性作为 cid 进行了查询
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}
