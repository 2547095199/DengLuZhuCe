package gowuche.bwie.com.dengluzhuce.persenter;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;

import gowuche.bwie.com.dengluzhuce.bean.DengLuBean;
import gowuche.bwie.com.dengluzhuce.model.MyDengLuModel;
import gowuche.bwie.com.dengluzhuce.okhttp.OnUiCallback;
import gowuche.bwie.com.dengluzhuce.view.DengLuView;
import okhttp3.Call;

/**
 * Created by CZ on 2017/11/28.
 */
public class DengLuPersenter {
    DengLuView view;
    Context context;
    private final MyDengLuModel model;

    public DengLuPersenter(DengLuView view, Context context) {
        this.view = view;
        this.context = context;
        model = new MyDengLuModel();
    }
    public void  getData(String phone,String mima){
        model.get(phone, mima, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                DengLuBean bean = gson.fromJson(result, DengLuBean.class);
                view.ben(bean);
            }
        });
    }
    public void sdasd(){
        this.view = null;
    }
}
