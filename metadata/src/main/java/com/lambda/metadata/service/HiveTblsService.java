package com.lambda.metadata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lambda.metadata.dto.DllResult;
import com.lambda.metadata.entity.Tbls;

import java.io.Serializable;

/**
 * (Tbls)表服务接口
 *
 * @author makejava
 * @since 2021-12-15 23:44:05
 */
public interface HiveTblsService extends IService<Tbls> {

    DllResult getDdl(String dbname, String tbname);
}

