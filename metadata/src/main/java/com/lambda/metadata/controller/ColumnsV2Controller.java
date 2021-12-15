package com.lambda.metadata.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lambda.metadata.entity.ColumnsV2;
import com.lambda.metadata.service.ColumnsV2Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (ColumnsV2)表控制层
 *
 * @author makejava
 * @since 2021-12-15 23:51:31
 */
@RestController
@RequestMapping("columnsV2")
public class ColumnsV2Controller extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ColumnsV2Service columnsV2Service;

    /**
     * 分页查询所有数据
     *
     * @param page      分页对象
     * @param columnsV2 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ColumnsV2> page, ColumnsV2 columnsV2) {
        return success(this.columnsV2Service.page(page, new QueryWrapper<>(columnsV2)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.columnsV2Service.getById(id));
    }

    /**
     * 新增数据
     *
     * @param columnsV2 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ColumnsV2 columnsV2) {
        return success(this.columnsV2Service.save(columnsV2));
    }

    /**
     * 修改数据
     *
     * @param columnsV2 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ColumnsV2 columnsV2) {
        return success(this.columnsV2Service.updateById(columnsV2));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.columnsV2Service.removeByIds(idList));
    }
}

