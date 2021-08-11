package com.demo.base.controller;

import com.demo.base.service.PmsProductService;
import com.demo.base.vo.PmsProductParam;
import com.demo.security.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(value = "value:PmsProductController", tags = "商品管理")
@RequestMapping("/product")
public class PmsProductController {

    private PmsProductService productService;
    @Autowired
    public void PmsProductController(PmsProductService productService){
        this.productService = productService;
    }
    @ApiOperation("创建商品")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody PmsProductParam pmsProductParam){
        int count = productService.create(pmsProductParam);
        if(count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }
}
