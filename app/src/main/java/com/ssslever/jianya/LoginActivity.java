package com.ssslever.jianya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;

/**
 * 登录界面
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button login;
    private EditText account;
    private EditText password;

    //获取用户名和登录密码
    private String acc;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //初始化
        init();
    }

    private void init() {
        login = findViewById(R.id.button_login);
        account = findViewById(R.id.login_account);
        password = findViewById(R.id.login_password);
        login = findViewById(R.id.button_login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //设置登录按钮的点击事件
            case R.id.button_login:
                acc = account.getText().toString();
                pass = password.getText().toString();
                if(acc.length() == 0 || pass.length() == 0){
                    Toast.makeText(getApplicationContext(),"请先把信息填完整",Toast.LENGTH_SHORT).show();
                }else {
                    AVUser.logInInBackground(acc, pass, new LogInCallback<AVUser>() {
                        @Override
                        public void done(AVUser avUser, AVException e) {
                            if (e == null) {
                                Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                                Log.d("login", "done: " + e.toString());
                            }
                        }
                    });
                }
                break;
        }
    }
}
