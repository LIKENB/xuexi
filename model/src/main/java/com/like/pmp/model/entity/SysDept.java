package com.like.pmp.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 部门管理
 * </p>
 *
 * @author like
 * @since 2022-04-26
 */
@TableName("sys_dept")
public class SysDept implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dept_id", type = IdType.AUTO)
    private Long deptId;

    /**
     * 上级部门ID，一级部门为0
     */
    @NotNull(message = "父级部门必填!")
    private Long parentId;

    /**
     * 部门名称
     */
    @NotNull(message = "部门名称不能为空！")
    private String name;


    /**
     *上级部门名称
     */
    @TableField(exist = false)//表示数据库中没有此字段
    private String parentName;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    @TableLogic//表示逻辑删除
    private Integer delFlag;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }


    @Override
    public String toString() {
        return "SysDept{" +
            "deptId=" + deptId +
            ", parentId=" + parentId +
            ", name=" + name +
            ", orderNum=" + orderNum +
            ", delFlag=" + delFlag +
        "}";
    }
}
