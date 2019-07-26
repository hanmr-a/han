package com.fh.shop.brand.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class BrandVo implements Serializable {

    private Integer id;

    private String brandName;

    private String createDate;
}
