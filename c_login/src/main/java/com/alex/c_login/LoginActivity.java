package com.alex.c_login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alex.c_platform.constant.RouterActivityPath;
import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = RouterActivityPath.Login.PAGER_Login)
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}