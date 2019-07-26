package com.fh.shop.brand.biz;

import com.fh.shop.brand.po.Brand;
import com.fh.shop.brand.vo.BrandVo;
import com.fh.shop.util.ServerResponse;

public interface IBrandService {

    ServerResponse addBrand(Brand brand);

    ServerResponse deleteBrand(Integer id);

    ServerResponse findBrand(Integer id);

    ServerResponse updateBrand(Brand brand);

    ServerResponse findBrandList();
}
