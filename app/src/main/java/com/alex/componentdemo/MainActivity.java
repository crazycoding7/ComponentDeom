package com.alex.componentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alex.c_platform.constant.RouterActivityPath;
import com.alex.c_platform.service.IAccountService;
import com.alex.c_platform.service.ServiceFactory;
import com.alibaba.android.arouter.launcher.ARouter;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        findViewById(R.id.btn_main_jump_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(RouterActivityPath.Home.PAGER_Home).navigation();
            }
        });

        findViewById(R.id.btn_main_jump_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(RouterActivityPath.Login.PAGER_Login).navigation();
            }
        });

        findViewById(R.id.btn_get_login_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IAccountService accountService = ServiceFactory.getInstance().getAccountService();
                Toast.makeText(MainActivity.this,"login data: " + accountService.getUserInfo().getId() + " " + accountService.getUserInfo().getName(),Toast.LENGTH_LONG).show();
            }
        });

    }
}