package com.ssslever.jianya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    private Button login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //初始化
        init();
    }

    private void init() {
        login = findViewById(R.id.button_choose_login);
        register = findViewById(R.id.button_choose_register);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //设置登录和注册两个按钮的点击事件
            case R.id.button_choose_login:
                Intent intent1 = new Intent(FirstActivity.this,LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.button_choose_register:
                Intent intent2 = new Intent(FirstActivity.this,RegisterActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
