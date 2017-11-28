package gowuche.bwie.com.dengluzhuce;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import gowuche.bwie.com.dengluzhuce.bean.ZhuCeBean;
import gowuche.bwie.com.dengluzhuce.persenter.ZhuCePersenter;
import gowuche.bwie.com.dengluzhuce.view.ZhuCeView;

public class ZhuCeActivity extends AppCompatActivity implements ZhuCeView {

    @BindView(R.id.fanhui)
    TextView fanhui;
    @BindView(R.id.phone2)
    EditText phone2;
    @BindView(R.id.mima2)
    EditText mima2;
    @BindView(R.id.zhuce2)
    Button zhuce2;

    ZhuCePersenter persenter = new ZhuCePersenter(this, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        ButterKnife.bind(this);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        zhuce2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ZhuCeActivity.this, phone2.getText().toString()+"       " + mima2.getText().toString(), Toast.LENGTH_SHORT).show();
                persenter.getData(phone2.getText().toString(), mima2.getText().toString());

            }
        });
    }

    @Override
    public void zhuce(ZhuCeBean bean) {
        if (mima2.length()<6){
            Toast.makeText(ZhuCeActivity.this, bean.getMsg(), Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(ZhuCeActivity.this, bean.getMsg(), Toast.LENGTH_SHORT).show();
            finish();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.sd();
    }
}
