package com.erguotou.service;

import com.erguotou.dao.BookDao;
import com.erguotou.pojo.Book;
import com.erguotou.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDao bookDAO;
    @Autowired
    CategoryService categoryService;

//    查询所有书籍，并对它们以id进行排序
    public List<Book> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return bookDAO.findAll(sort);
    }

    public void addOrUpdate(Book book) {
//        save() 方法的作用是，当主键存在时更新数据，当主键不存在时插入数据。
        bookDAO.save(book);
    }

//    删除书籍
    public void deleteById(int id) {
        bookDAO.deleteById(id);
    }
//    以cid进行查询书籍也就是作品分类
    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return bookDAO.findAllByCategory(category);
    }
//    以光健字来查询书籍
    public List<Book> SearchKey(String keywords){
        return bookDAO.findAllByTitleLikeOrAuthorLike('%'+keywords+'%', '%'+keywords+'%');
    }

}
