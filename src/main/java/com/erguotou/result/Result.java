package com.erguotou.result;

import lombok.Data;
import org.springframework.stereotype.Component;

//这个类是为了构建response，主要是响应码
@Data
public class Result {
//    响应码
    private int code;

    public Result(int code){
        this.code = code;
    }

}
