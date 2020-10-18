package com.dangdang.bookmall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dangdang.bookmall.product.entity.BookdetailEntity;
import com.dangdang.bookmall.product.service.BookdetailService;
import com.dangdang.common.utils.PageUtils;
import com.dangdang.common.utils.R;



/**
 * 
 *
 * @author zengyuzhi
 * @email shbyku@gmail.com
 * @date 2020-10-17 19:56:33
 */
@RestController
@RequestMapping("product/bookdetail")
public class BookdetailController {
    @Autowired
    private BookdetailService bookdetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:bookdetail:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bookdetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:bookdetail:info")
    public R info(@PathVariable("id") Long id){
		BookdetailEntity bookdetail = bookdetailService.getById(id);

        return R.ok().put("bookdetail", bookdetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:bookdetail:save")
    public R save(@RequestBody BookdetailEntity bookdetail){
		bookdetailService.save(bookdetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:bookdetail:update")
    public R update(@RequestBody BookdetailEntity bookdetail){
		bookdetailService.updateById(bookdetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:bookdetail:delete")
    public R delete(@RequestBody Long[] ids){
		bookdetailService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}