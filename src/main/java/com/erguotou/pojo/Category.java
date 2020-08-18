package com.erguotou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "category")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    int id;
    String name;
}
