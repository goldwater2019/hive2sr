package com.lambda.metadata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lambda.metadata.dao.DbsDao;
import com.lambda.metadata.entity.Dbs;
import com.lambda.metadata.service.DbsService;
import org.springframework.stereotype.Service;

/**
 * (Dbs)表服务实现类
 *
 * @author makejava
 * @since 2021-12-15 23:51:06
 */
@Service("dbsService")
public class DbsServiceImpl extends ServiceImpl<DbsDao, Dbs> implements DbsService {

}

