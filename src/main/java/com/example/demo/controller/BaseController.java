package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.beans.ResultCodeEnum;
import com.example.demo.beans.SystemContstants;

public class BaseController {

    public JSONObject getSuccess() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(SystemContstants.CODE, ResultCodeEnum.SUCCESS.getCode());
        jsonObject.put(SystemContstants.MSG, ResultCodeEnum.SUCCESS.getMessage());
        return jsonObject;
    }

    public JSONObject getSuccess(Object data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(SystemContstants.DATA, data);
        jsonObject.put(SystemContstants.CODE, ResultCodeEnum.SUCCESS.getCode());
        jsonObject.put(SystemContstants.MSG, ResultCodeEnum.SUCCESS.getMessage());
        return jsonObject;
    }

    public JSONObject getSuccess(Object data, long total) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(SystemContstants.DATA, data);
        jsonObject.put(SystemContstants.TOTAL, total);
        jsonObject.put(SystemContstants.CODE, ResultCodeEnum.SUCCESS.getCode());
        jsonObject.put(SystemContstants.MSG, ResultCodeEnum.SUCCESS.getMessage());
        return jsonObject;
    }

    public JSONObject getSuccess(ResultCodeEnum resultCodeEnum) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(SystemContstants.CODE, resultCodeEnum.getCode());
        jsonObject.put(SystemContstants.MSG, resultCodeEnum.getMessage());
        return jsonObject;
    }
    public JSONObject getSuccess(ResultCodeEnum resultCodeEnum, Object data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(SystemContstants.DATA, data);
        jsonObject.put(SystemContstants.CODE, resultCodeEnum.getCode());
        jsonObject.put(SystemContstants.MSG, resultCodeEnum.getMessage());
        return jsonObject;
    }

    public JSONObject getFailure(ResultCodeEnum resultCodeEnum) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(SystemContstants.CODE, resultCodeEnum.getCode());
        jsonObject.put(SystemContstants.MSG, resultCodeEnum.getMessage());
        return jsonObject;
    }
}
