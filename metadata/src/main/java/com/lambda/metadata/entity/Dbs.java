package com.lambda.metadata.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (Dbs)表实体类
 *
 * @author makejava
 * @since 2021-12-15 23:51:06
 */
@SuppressWarnings("serial")
public class Dbs extends Model<Dbs> {

    private Long dbId;

    @TableField("`desc`")
    private String desc;

    private String dbLocationUri;

    private String name;

    private String ownerName;

    private String ownerType;


    public Long getDbId() {
        return dbId;
    }

    public void setDbId(Long dbId) {
        this.dbId = dbId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDbLocationUri() {
        return dbLocationUri;
    }

    public void setDbLocationUri(String dbLocationUri) {
        this.dbLocationUri = dbLocationUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.dbId;
    }
}

