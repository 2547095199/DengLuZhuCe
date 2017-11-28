package gowuche.bwie.com.dengluzhuce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import gowuche.bwie.com.dengluzhuce.bean.DengLuBean;
import gowuche.bwie.com.dengluzhuce.persenter.DengLuPersenter;
import gowuche.bwie.com.dengluzhuce.view.DengLuView;

public class MainActivity extends AppCompatActivity implements DengLuView {

    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.mima)
    EditText mima;
    @BindView(R.id.denglu)
    Button denglu;
    @BindView(R.id.zhuce)
    Button zhuce;


    DengLuPersenter persenter = new DengLuPersenter(this, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                persenter.getData(phone.getText().toString(), mima.getText().toString());

            }
        });
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ZhuCeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.sdasd();
    }

    @Override
    public void ben(DengLuBean bean) {
        if (bean.getMsg().length() == 4){
            Toast.makeText(MainActivity.this, bean.getMsg(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, XiangQingActivity.class);
            startActivity(intent);
        }

        Toast.makeText(MainActivity.this, bean.getMsg(), Toast.LENGTH_SHORT).show();


    }
}
