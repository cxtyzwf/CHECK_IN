package com.example.weifeng.check_in;

import android.app.Application;

import com.lzy.okgo.OkGo;

public class MyApplication extends Application{

    private String stuId;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    private String stuPassword;


    @Override
    public void onCreate() {
        super.onCreate();

        OkGo.getInstance().init(this);
    }
}
