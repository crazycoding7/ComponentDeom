package com.alex.componentdemo;

import android.app.Application;

import com.alex.c_platform.base.AppConfig;
import com.alex.c_platform.service.IAccountService;
import com.alex.c_platform.service.ServiceFactory;
import com.alibaba.android.arouter.launcher.ARouter;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(this); // As early as possible, it is recommended to initialize in the Application


        initServiceFactory();
    }

    /**
     * 初始化组件暴露出来的接口(反射)
     */
    private void initServiceFactory() {
        for (String moduleApp : AppConfig.moduleApps) {
            try {
                Class clazz = Class.forName(moduleApp);
                IAccountService accountService = (IAccountService) clazz.newInstance();
                ServiceFactory.getInstance().setAccountService(accountService);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

        }
    }
}
