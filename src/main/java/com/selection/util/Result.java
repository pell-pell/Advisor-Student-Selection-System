package com.selection.util;

/**
 * 返回json攻擂
 * @author Administrator
 * @version 1.0
 * @data 2019-04-24 15:52
 */
public class Result {

    public Result() {

	}

	public Result(boolean success, String msg, Integer msgcode, Object data) {
		super();
		this.success = success;
		this.msg = msg;
		this.msgcode = msgcode;
		this.data = data;
	}

	public Result(boolean success, String msg, Integer msgcode) {
		super();
		this.success = success;
		this.msg = msg;
		this.msgcode = msgcode;
	}

	/** 用于前端返回. */
	public static Result reOk(String msg) {
		return new Result(true,msg,0);
	}

	/** 用于前端返回. */
	public static Result reOk(String msg,Object obj) {
		return new Result(true,msg,0,obj);
	}

	/** 用于前端返回. */
	public static Result reError(String msg) {
		return new Result(false,msg,1);
	}


	//判断请求是否成功字符串
    private boolean success;
	//返回消息内容
	private String msg;
    //返回 响应业务状态码，001-查询成功；002-系统查询异常；003-请求参数错误；004-验证码错误 005-请求参数错误   006-密码错误
	private Integer msgcode;
	//返回对象
	private Object data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getMsgcode() {
		return msgcode;
	}

	public void setMsgcode(Integer msgcode) {
		this.msgcode = msgcode;
	}

}
