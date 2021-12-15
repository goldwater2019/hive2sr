package com.lambda.metadata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lambda.metadata.dao.ColumnsV2Dao;
import com.lambda.metadata.entity.ColumnsV2;
import com.lambda.metadata.service.ColumnsV2Service;
import org.springframework.stereotype.Service;

/**
 * (ColumnsV2)表服务实现类
 *
 * @author makejava
 * @since 2021-12-15 23:51:31
 */
@Service("columnsV2Service")
public class ColumnsV2ServiceImpl extends ServiceImpl<ColumnsV2Dao, ColumnsV2> implements ColumnsV2Service {

}

