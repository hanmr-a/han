package com.fh.shop.brand.common;

import com.fh.shop.util.IEnum;

public enum ResponseEnum implements IEnum {
   BRAND_IS_NULL(2000,"品牌不存在");

    private int code;

    private String message;

    private ResponseEnum(int code,String message){
            this.code=code;
            this.message=message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
