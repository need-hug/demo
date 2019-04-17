package com.soft.demo.util;

/** 响应实体
 * @Auther: lps
 * DateTime: 2019/4/16 16:57
 * @Version: 1.0
 */
public class MsgObj<T> implements java.io.Serializable {

    /**
     * 响应状态吗
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private T result;

    public MsgObj() {
        setCode(200);
        setMsg("成功");
    }

    public MsgObj(T result) {
        setCode(200);
        setMsg("成功");
        this.result = result;
    }

    public MsgObj(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public MsgObj(Integer code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
