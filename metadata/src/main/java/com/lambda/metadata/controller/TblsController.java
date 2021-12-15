package com.lambda.metadata.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lambda.metadata.dto.DllResult;
import com.lambda.metadata.entity.Tbls;
import com.lambda.metadata.service.HiveTblsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Tbls)表控制层
 *
 * @author makejava
 * @since 2021-12-15 23:44:05
 */
@RestController
@RequestMapping("tbls")
public class TblsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private HiveTblsService hiveTblsService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tbls 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Tbls> page, Tbls tbls) {
        return success(this.hiveTblsService.page(page, new QueryWrapper<>(tbls)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.hiveTblsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tbls 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Tbls tbls) {
        return success(this.hiveTblsService.save(tbls));
    }

    /**
     * 修改数据
     *
     * @param tbls 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Tbls tbls) {
        return success(this.hiveTblsService.updateById(tbls));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.hiveTblsService.removeByIds(idList));
    }
    @GetMapping("ddl/{dbname}/{tbname}")
    public R<DllResult> getDdl(@PathVariable String dbname,
                               @PathVariable String tbname) {

        return success(this.hiveTblsService.getDdl(dbname, tbname));
    }
}

