package com.lambda.metadata.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lambda.metadata.entity.Dbs;
import com.lambda.metadata.service.DbsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Dbs)表控制层
 *
 * @author makejava
 * @since 2021-12-15 23:51:05
 */
@RestController
@RequestMapping("dbs")
public class DbsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private DbsService dbsService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param dbs  查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Dbs> page, Dbs dbs) {
        return success(this.dbsService.page(page, new QueryWrapper<>(dbs)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.dbsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param dbs 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Dbs dbs) {
        return success(this.dbsService.save(dbs));
    }

    /**
     * 修改数据
     *
     * @param dbs 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Dbs dbs) {
        return success(this.dbsService.updateById(dbs));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.dbsService.removeByIds(idList));
    }
}

