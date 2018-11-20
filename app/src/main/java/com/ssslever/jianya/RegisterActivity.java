package com.ssslever.jianya;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;

/**
 * 注册界面
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText account;
    private EditText password;
    private EditText email;
    private Button register;

    //获取用户的用户名、密码和邮箱
    private String acc;
    private String pass;
    private String mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //初始化
        init();
    }

    private void init() {
        account = findViewById(R.id.register_account);
        password = findViewById(R.id.register_password);
        email = findViewById(R.id.register_youxiang);
        register = findViewById(R.id.button_register);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //设置注册按钮的点击事件
            case R.id.button_register:
                acc = account.getText().toString();
                pass = password.getText().toString();
                mail = email.getText().toString();
                if (acc.length() == 0 || pass.length() == 0 || mail.length() == 0) {
                    Toast.makeText(getApplicationContext(), "请先把信息填写完整", Toast.LENGTH_SHORT).show();
                    Log.d("register", "done: " + acc + "," + pass + "," + mail);
                } else {
                    AVUser user = new AVUser();// 新建 AVUser 对象实例
                    user.setUsername(acc);// 设置用户名
                    user.setPassword(pass);// 设置密码
                    user.setEmail(mail);// 设置邮箱
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(AVException e) {
                            if (e == null) {
                                // 注册成功
                                Toast.makeText(getApplicationContext(),"注册成功", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                // 失败的原因可能有多种，常见的是用户名已经存在。
                                Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_SHORT).show();
                                Log.d("register", "done: " + e.toString());
                            }
                        }
                    });
                }
                break;
        }
    }
}
