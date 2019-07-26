package com.fh.shop.brand.biz;

import com.fh.shop.brand.common.ResponseEnum;
import com.fh.shop.brand.mapper.IBrandMapper;
import com.fh.shop.brand.po.Brand;
import com.fh.shop.brand.vo.BrandVo;
import com.fh.shop.util.DateUtil;
import com.fh.shop.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("brandService")
@Transactional(rollbackFor = Exception.class)
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private IBrandMapper brandMapper;

    @Override
    public ServerResponse addBrand(Brand brand) {
        brandMapper.addBrand(brand);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse deleteBrand(Integer id) {
        brandMapper.deleteBrand(id);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse findBrand(Integer id) {
        Brand brand = brandMapper.findBrand(id);
        if (null == brand){
            return ServerResponse.error(ResponseEnum.BRAND_IS_NULL);
        }
        BrandVo brandVo = buildVo(brand);
        return ServerResponse.success(brandVo);
    }

    @Override
    public ServerResponse updateBrand(Brand brand) {
        brandMapper.updateBrand(brand);
        return ServerResponse.success();
    }

    @Override
    @Transactional(readOnly = true)
    public ServerResponse findBrandList() {
       List<Brand> brandList = brandMapper.findBrandList();
        List<BrandVo> brandVos = converBrandVoList(brandList);
        return ServerResponse.success(brandVos);
    }

    private List<BrandVo> converBrandVoList(List<Brand> brands){
        List<BrandVo> brandVos=new ArrayList<>();
        for (Brand brand : brands) {
            brandVos.add(buildVo(brand));
        }
        return brandVos;
    }
    private BrandVo buildVo(Brand brand) {
        BrandVo brandVo=new BrandVo();
        brandVo.setId(brand.getId());
        brandVo.setBrandName(brand.getBrandName());
        brandVo.setCreateDate(DateUtil.date2str(brand.getCreateDate(),DateUtil.Y_M_D));
        return brandVo;
    }
}
