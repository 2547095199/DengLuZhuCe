package gowuche.bwie.com.dengluzhuce.persenter;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;

import gowuche.bwie.com.dengluzhuce.bean.ZhuCeBean;
import gowuche.bwie.com.dengluzhuce.model.MyZhuCeModel;
import gowuche.bwie.com.dengluzhuce.okhttp.OnUiCallback;
import gowuche.bwie.com.dengluzhuce.view.ZhuCeView;
import okhttp3.Call;

/**
 * Created by CZ on 2017/11/28.
 */
public class ZhuCePersenter {
    ZhuCeView view;
    Context context;
    private final MyZhuCeModel model;

    public ZhuCePersenter(ZhuCeView view, Context context) {
        this.view = view;
        this.context = context;
        model = new MyZhuCeModel();
    }
    public void  getData(String phone2,String mima2){
        model.getlogin(phone2, mima2, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ZhuCeBean bean = gson.fromJson(result, ZhuCeBean.class);
                view.zhuce(bean);
            }
        });
    }
    public void sd(){
        this.view = null;
    }
}
