package com.example.demo.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ResultCodeEnum {
    SUCCESS("000000", "交易成功"),
    MENU_IS_NULL("000001", "菜单信息为空"),
    USER_LOGIN_SUCCESS("100000", "登录成功"),
    USER_NEED_AUTHORITIES("100001", "用户未登录"),
    USER_LOGIN_FAILED("100002", "账号或密码错误"),
    USER_NO_ACCESS("100003", "无权限访问资源"),
    USER_LOGOUT_SUCCESS("100004", "退出成功"),
    TOKEN_IS_BLACKLIST("100005", "此token已经失效"),
    LOGIN_IS_OVERDUE("100006", "登录已失效"),
    INSERT_ERROR("100007", "保存失败"),
    UPDATE_ERROR("100008", "修改失败"),
    SMS_SEND_ERROR("100009", "验证码发送失败"),
    SMS_CHECK_ERROR("100010", "验证码错误"),
    MER_CODE_EMPTY("100011", "商户号不能为空"),
    PHONE_NO_EMPTY("100012", "手机号不能为空"),
    PHONE_NO_EXIST("100013", "该手机号已被使用"),
    ACCT_NAME_EMPTY("100014", "姓名不能为空"),
    RESET_PASSWORD_ERROR("100015", "重置密码失败"),
    ACCOUNT_LOCKED("100016", "账户被锁定"),
    MESSAGE_TEMPLATE_IS_NOT_EXSIST("100017", "短信模板不存在"),
    USER_IS_NOT_REGISTER("100018", "用户尚未注册，请核实后再试"),
    PRAM_NOT_ID("100019", "下载文件编号未传入"),
    THE_MERCHANT_FILE_NOT_EXIST("100020", "请求下载的对账文件不存在"),
    SMS_CODE_INVALID("100021", "短信验证码已过期"),
    NEWPASSWORD_MATCH_OLDPASSWORD("100022", "新密码不能与原密码一样"),
    MER_CODE_AND_NAME_EMPTY("100022", "商户号与商户名称不能同时为空"),
    SUB_MER_CODE_ERROR("100023", "主子商户关系不存在"),
    MER_INFO_IS_EMPTY("100024", "商户信息不存在"),
    SESSION_IS_TIMEOUT("100025", "登录已失效，请退出后重新登录"),
    MESSAGE_SEND_OVER_LIMIT("100026", "短信发送超出次数限制"),
    USER_HAS_LOGIN("100027", "不允许重复登录"),
    UPLOAD_FILE_IS_EMPTY("100028", "上传文件为空"),
    SYSTEM_VAR_MISSING("999995", "系统环境变量缺失"),
    NUMBER_PARAMS("999996", "数字转换异常"),
    NULL_POINT("999997", "空指针异常"),
    ILLEGAL_PARAMS("999998", "参数类型错误"),
    PROV_OR_CITY_EMPTY("100029","支行省份和城市不能为空"),
    SYSTEM_ERROR("999999", "系统处理异常");

    private String code;

    private String message;
}
