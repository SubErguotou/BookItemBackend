package com.erguotou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Component
@Entity(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    public int id;
    public String username;
    public String password;
}
