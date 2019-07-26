package com.fh.shop.brand.mapper;

import com.fh.shop.brand.po.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IBrandMapper {

    @Insert("insert into t_brand (brandName,createDate) values (#{brandName},#{createDate})")
    void addBrand(Brand brand);

    @Delete("delete from t_brand where id =#{id}")
    void deleteBrand(Integer id);

    @Select("select id,brandName,createDate from t_brand where id =#{id}")
    Brand findBrand(Integer id);

    @Update("update t_brand set brandName =#{brandName},createDate=#{createDate} where id=#{id}")
    void updateBrand(Brand brand);

    @Results({
          @Result(column = "id",property = "id"),
          @Result(column = "brandName",property = "brandName"),
          @Result(column = "createDate",property = "createDate"),
    })
    @Select("select id,brandName,createDate from t_brand")
    List<Brand> findBrandList();
}
