package com.lambda.metadata.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (ColumnsV2)表实体类
 *
 * @author makejava
 * @since 2021-12-15 23:51:31
 */
@SuppressWarnings("serial")
public class ColumnsV2 extends Model<ColumnsV2> {

    private Long cdId;

    private String comment;

    private String columnName;

    private String typeName;

    private Integer integerIdx;


    public Long getCdId() {
        return cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getIntegerIdx() {
        return integerIdx;
    }

    public void setIntegerIdx(Integer integerIdx) {
        this.integerIdx = integerIdx;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.cdId;
    }
}

