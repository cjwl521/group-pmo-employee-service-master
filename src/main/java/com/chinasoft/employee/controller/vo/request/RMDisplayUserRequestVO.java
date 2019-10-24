package com.chinasoft.employee.controller.vo.request;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

/**
 * 我的员工 入参查询
 * @author wang
 *
 */
@Data
@ToString
public class RMDisplayUserRequestVO{
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户组类型
     */
    private String userType;
    /**
     * 用户部门信息
     */
    private String csdeptId;
    /**
     * 用户名或EHR编号
     */
//    @Size(min=1)
    private String staffNameOrIdOrEhrOrLOB;
    /**
     * 过滤查询部门
     */
    private Integer filterCsdeptId;
    /**
     * 过滤查询事业部
     */
    private Integer filterCsbuId;
    /**
     * 过滤查询业务线
     */
    private Integer filterCsblId;
    /**
     * 过滤查询RM
     */
    private String filterRmUserId;
    /**
     * 过滤查询RM
     */
    private Integer engagementType;
    /**
     * 员工状态
     */
    private String resourceStatus;
    /**
     * 页数
     */
    @NotNull
    private int page=1;
    /**
     * 每页条数
     */
    private int pageSize;
}
