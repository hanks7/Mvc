package com.hanks.mvc.base;

import android.app.Application;

import com.zhouyou.http.EasyHttp;

import static com.hanks.mvc.base.BaseConstant.IS_RELEASE;

/**
 * @author 侯建军 47466436@qq.com
 * @class com.hanks.mvc.base.MyApplication
 * @time 2019/4/11 10:58
 * @description 请填写描述
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        EasyHttp.init(this);//默认初始化
        EasyHttp.getInstance().debug("EasyHttp-", !IS_RELEASE);  // 最后的true表示是否打印内部异常，一般打开方便调试错误
    }
}