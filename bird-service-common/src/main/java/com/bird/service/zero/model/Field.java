package com.bird.service.zero.model;

import com.baomidou.mybatisplus.annotations.TableName;
import com.bird.core.model.AbstractModel;

@TableName("zero_form_field")
public class Field extends AbstractModel {
    private String name;
    private String key;
    private String defaultValue;
    private String tips;
    private String groupName;
    private String validateRegular;
    private boolean isRequired;
    private Integer orderNo;
    private String fieldType;
    private Long formId;
    private String optionsKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getValidateRegular() {
        return validateRegular;
    }

    public void setValidateRegular(String validateRegular) {
        this.validateRegular = validateRegular;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getOptionsKey() {
        return optionsKey;
    }

    public void setOptionsKey(String optionsKey) {
        this.optionsKey = optionsKey;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }
}
