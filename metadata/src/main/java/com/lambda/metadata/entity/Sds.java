package com.lambda.metadata.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (Sds)表实体类
 *
 * @author makejava
 * @since 2021-12-15 23:50:23
 */
@SuppressWarnings("serial")
public class Sds extends Model<Sds> {

    private Long sdId;

    private Long cdId;

    private String inputFormat;

    private String isCompressed;

    private String isStoredassubdirectories;

    private String location;

    private Integer numBuckets;

    private String outputFormat;

    private Long serdeId;


    public Long getSdId() {
        return sdId;
    }

    public void setSdId(Long sdId) {
        this.sdId = sdId;
    }

    public Long getCdId() {
        return cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }

    public String getInputFormat() {
        return inputFormat;
    }

    public void setInputFormat(String inputFormat) {
        this.inputFormat = inputFormat;
    }

    public String getIsCompressed() {
        return isCompressed;
    }

    public void setIsCompressed(String isCompressed) {
        this.isCompressed = isCompressed;
    }

    public String getIsStoredassubdirectories() {
        return isStoredassubdirectories;
    }

    public void setIsStoredassubdirectories(String isStoredassubdirectories) {
        this.isStoredassubdirectories = isStoredassubdirectories;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getNumBuckets() {
        return numBuckets;
    }

    public void setNumBuckets(Integer numBuckets) {
        this.numBuckets = numBuckets;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public Long getSerdeId() {
        return serdeId;
    }

    public void setSerdeId(Long serdeId) {
        this.serdeId = serdeId;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.sdId;
    }
}

