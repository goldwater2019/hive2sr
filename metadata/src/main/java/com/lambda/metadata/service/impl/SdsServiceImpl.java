package com.lambda.metadata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lambda.metadata.dao.SdsDao;
import com.lambda.metadata.entity.Sds;
import com.lambda.metadata.service.SdsService;
import org.springframework.stereotype.Service;

/**
 * (Sds)表服务实现类
 *
 * @author makejava
 * @since 2021-12-15 23:50:23
 */
@Service("sdsService")
public class SdsServiceImpl extends ServiceImpl<SdsDao, Sds> implements SdsService {

}

