package com.lambda.metadata.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lambda.metadata.entity.Sds;
import com.lambda.metadata.service.SdsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Sds)表控制层
 *
 * @author makejava
 * @since 2021-12-15 23:50:22
 */
@RestController
@RequestMapping("sds")
public class SdsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SdsService sdsService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param sds  查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Sds> page, Sds sds) {
        return success(this.sdsService.page(page, new QueryWrapper<>(sds)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sdsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sds 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Sds sds) {
        return success(this.sdsService.save(sds));
    }

    /**
     * 修改数据
     *
     * @param sds 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Sds sds) {
        return success(this.sdsService.updateById(sds));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sdsService.removeByIds(idList));
    }
}

