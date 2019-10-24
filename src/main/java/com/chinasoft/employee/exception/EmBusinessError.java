package com.chinasoft.employee.exception;


public enum EmBusinessError implements CommonError {

    //10001通用错误类型
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    //10002未知错误
    UNKNOW_ERROR(10002,"未知异常，操作失败"),
    //20000开头为用户信息相关错误定义 
    USER_NOT_EXIT(20001,"用户不存在"),
    USER_PASSWORD_ERROR(20002,"用户名密码错误"),
    USER_OPERATE_ERROR(20003,"用户操作异常"),
    EMPLOYEE_ERROR(30001,"查询员工信息异常"),
    BENCHPOOL_ERROR(30002,"数据库操作资源池信息表异常"),
    PMO_EMPLOYEE_ERROR(30003,"数据库操作资源池和员工管理表异常"),
    EXPORT_ERROR(60003,"数据库导出异常！"),
    DB_IMPORT_ERROR(80001,"数据库导入异常！"),
    OA_LOGIN_ERROR(70001,"OA系统登录异常！"),
    EMPLOYEE_UPLOAD(50003,"员工信息编辑操作，数据库发生异常"),
    NO_EHR(90001,"该EHR不存在，请先确保在OA系统中录入该员工,EHR:"),
    ;
	
	private int errCode;
	
	private String errMsg;
  
	private EmBusinessError(int errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }


    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
