package com.alex.c_platform.service;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.alex.c_platform.model.UserInfo;

/**
 * 登录组件暴露的接口
 */
public interface IAccountService {

    boolean isLogin();

    UserInfo getUserInfo();

    Fragment newUserFragment(Activity activity, int containerId, FragmentManager fragmentManager, Bundle bundle, String tag);
}
