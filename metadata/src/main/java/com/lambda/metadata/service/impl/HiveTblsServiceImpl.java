package com.lambda.metadata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lambda.metadata.dao.ColumnsV2Dao;
import com.lambda.metadata.dao.DbsDao;
import com.lambda.metadata.dao.SdsDao;
import com.lambda.metadata.dao.TblsDao;
import com.lambda.metadata.dto.DllResult;
import com.lambda.metadata.entity.ColumnsV2;
import com.lambda.metadata.entity.Dbs;
import com.lambda.metadata.entity.Sds;
import com.lambda.metadata.entity.Tbls;
import com.lambda.metadata.service.HiveTblsService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Tbls)表服务实现类
 *
 * @author makejava
 * @since 2021-12-15 23:44:05
 */
@Log
@Service("tblsService")
public class HiveTblsServiceImpl extends ServiceImpl<TblsDao, Tbls> implements HiveTblsService {

    @Resource
    public DbsDao dbsDao;

    @Resource
    public TblsDao tblsDao;

    @Resource
    public SdsDao sdsDao;

    @Resource
    public ColumnsV2Dao columnsV2Dao;

    /**
     *
     * @param dbname
     * @param tbname
     * @return
     */
    @Override
    public DllResult getDdl(String dbname, String tbname) {
        log.info("dbname: " + dbname +", tbname: " + tbname);
        List<Dbs> dbsList = dbsDao.selectList(new LambdaQueryWrapper<Dbs>()
                .eq(Dbs::getName, dbname));
        // Assert.isTrue(dbsList.size() > 0, String.format("dbname: %s 不存在", dbname));
        if (dbsList.size() == 0) {
            return DllResult.builder()
                    .message(String.format("dbname: %s 不存在", dbname))
                    .dll("")
                    .build();
        }
        Dbs dbs = dbsList.get(0);
        List<Tbls> tblsList = tblsDao.selectList(new LambdaQueryWrapper<Tbls>()
                .eq(Tbls::getDbId, dbs.getDbId())
                .eq(Tbls::getTblName, tbname));
        // Assert.isTrue(tblsList.size() > 0, String.format("tbname: %s 不存在", tbname));
        if (tblsList.size() == 0) {
            return DllResult.builder()
                    .message(String.format("tbname: %s 不存在", tbname))
                    .dll("")
                    .build();
        }
        Tbls tbls = tblsList.get(0);
        List<Sds> sdsList = sdsDao.selectList(new LambdaQueryWrapper<Sds>()
                .eq(Sds::getSdId, tbls.getSdId())
        );
        // Assert.isTrue(sdsList.size() > 0, "sdId 错误");
        if (sdsList.size() == 0) {
            return DllResult.builder()
                    .message("sdId 错误")
                    .dll("")
                    .build();
        }
        Sds sds = sdsList.get(0);
        List<ColumnsV2> columnsV2s = columnsV2Dao.selectList(new LambdaQueryWrapper<ColumnsV2>()
                .eq(ColumnsV2::getCdId, sds.getCdId())
        );

        String ddl = "create table ods_lb_hs_opt_ewb  " +
                "(  ";
        for (ColumnsV2 columnsV2 : columnsV2s) {
            String columnName = columnsV2.getColumnName();
            String typeName = columnsV2.getTypeName();
            String comment = columnsV2.getComment();
            if (comment == null || comment.length() == 0) {
                ddl = ddl + String.format("    %s                 %s         not null,  ", columnName, typeName);
            } else {
                ddl = ddl + String.format("    %s                 %s         not null         comment '%s',  ", columnName, typeName, comment);
            }
        }
        ddl = ddl.substring(0, ddl.length()-3);
                ddl = ddl + ")  ";
        return DllResult.builder()
                .message("获取成功")
                .dll(ddl)
                .build();
    }
}

