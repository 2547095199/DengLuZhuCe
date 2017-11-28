package gowuche.bwie.com.dengluzhuce.model;

import java.util.HashMap;

import gowuche.bwie.com.dengluzhuce.okhttp.OkHttp3Utils;
import okhttp3.Callback;

/**
 * Created by CZ on 2017/11/28.
 */
public class MyDengLuModel implements DengLuModeol {
    @Override
    public void get(String phone, String mima, Callback callback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile", phone);
        map.put("password",mima);
        OkHttp3Utils.doPost("http://120.27.23.105/user/login",map,callback);
    }
}
