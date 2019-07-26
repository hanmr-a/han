package com.fh.shop.brand.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Brand implements Serializable {

    private Integer id;

    private String brandName;

    private Date createDate;


}
