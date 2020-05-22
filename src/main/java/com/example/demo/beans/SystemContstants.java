package com.example.demo.beans;


public interface SystemContstants {
    /***
     * 响应吗
     */
    String CODE = "code";
    /***
     * 响应信息
     */
    String MSG = "message";
    /***
     * 响应数据
     */
    String DATA = "data";
    /***
     * 用户登录凭证key
     */
    String SPRING_SESSION_CONTEXT = "SPRING_SESSION_CONTEXT";
    /***
     * token
     */
    String ACCESS_TOKEN = "access_token";
    /***
     * jwt bearer
     */
    String BEARER = "Bearer;";
    /**
     * 总条数
     */
    String TOTAL = "total";
    /**
     * 操作员注册短信模板ID
     */
    String OPER_REGISTER_TEMP_ID = "TMP02";
    /**
     * 操作员修改短信模板ID
     */
    String OPER_UPDATE_TEMP_ID = "TMP03";
    /***
     * 登录短信模板ID
     */
    String MESSAGE_LOGIN_TEMP_ID = "TMP04";
    /***
     * 短信发送成功状态
     */
    String MESSAGE_SEND_STATUS = "00";
    /****
     * 密码错误次数显示KEY
     */
    String PASSWORD_WRONG_TIMES_COUNTER = "PASSWORD_WRONG_TIMES_COUNTER_";
    /***
     * 登录方式：01-密码登录
     */
    String LOGIN_TYPE = "01";
}
