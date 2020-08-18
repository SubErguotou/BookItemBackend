package com.erguotou.service;

import com.erguotou.dao.CategoryDao;
import com.erguotou.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    public List<Category> list(){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return categoryDao.findAll(sort);
    }
    public Category get(int id){
//        根据id获取category，去除null串
        Category category = categoryDao.findById(id).orElse(null);
        return category;
    }
}
