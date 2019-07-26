package com.fh.shop.brand.controller;

import com.fh.shop.brand.biz.IBrandService;
import com.fh.shop.brand.po.Brand;
import com.fh.shop.util.ServerResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/brands")
@CrossOrigin("http://localhost:8085")
public class BrandController {
    @Resource(name = "brandService")
    private IBrandService brandService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ServerResponse addBrand(@RequestBody Brand brand){
        ServerResponse serverResponse = brandService.addBrand(brand);
        return serverResponse;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ServerResponse deleteBrand(@PathVariable Integer id) {
        return brandService.deleteBrand(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ServerResponse<Brand> findBrand(@PathVariable Integer id) {
        ServerResponse brand = brandService.findBrand(id);
        return brand;
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ServerResponse updateBrand(@RequestBody Brand brand) {
        return brandService.updateBrand(brand);
    }

    @GetMapping("/list")
    public ServerResponse list(){
        return brandService.findBrandList();
    }
}
