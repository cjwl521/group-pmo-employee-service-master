package com.chinasoft.employee.exception;

// 包装器业务异常类实现
public class BusinessException extends Exception implements CommonError {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private CommonError commonError;

    //直接接受EmBusinessError的传参用于构造业务异常
    public BusinessException (CommonError commonError){
        super();
        this.commonError = commonError;
    }

    //间接接受EmBusinessError的传参用于构造业务异常
    public BusinessException (CommonError commonError,String errMsg){
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }

    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
       this.setErrMsg(errMsg);
       return this;
    }
}
