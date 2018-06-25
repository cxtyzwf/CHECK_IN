package com.example.weifeng.check_in.login;


import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.weifeng.check_in.MyApplication;
import com.example.weifeng.check_in.R;
import com.example.weifeng.check_in.home.HomeActivity;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;


public class Login extends AppCompatActivity {

    private CustomVideoView videoView;
    private ImageView imageView;
    private Button button1,button2,button3;
    private EditText editText1,editText2;
    private android.support.v7.widget.Toolbar toolbar;
    private int keydown=-1;
    private MyApplication application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initView();

    }

    private void initView() {
        imageView = findViewById(R.id.img_login);
        videoView = findViewById(R.id.videoView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        toolbar = findViewById(R.id.toolbar);

        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.login_bg));
        videoView.start();
        //循环播放
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setVisibility(View.GONE);
                editText2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                toolbar.setVisibility(View.GONE);
                button1.setVisibility(View.VISIBLE);
                ObjectAnimator.ofFloat(button1,"alpha",0.0f,0.5f).setDuration(1000).start();
                button2.setVisibility(View.VISIBLE);
                ObjectAnimator.ofFloat(button2,"alpha",0.0f,0.5f).setDuration(1000).start();
            }
        });

    }


    public void numberClick(View view) {

       toolbar.setVisibility(View.VISIBLE);
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        editText1.setVisibility(View.VISIBLE);

        ObjectAnimator.ofFloat(editText1,"alpha",0.0f,0.5f).setDuration(1000).start();
        editText2.setVisibility(View.VISIBLE);
        ObjectAnimator.ofFloat(editText2,"alpha",0.0f,0.5f).setDuration(1000).start();
        button3.setVisibility(View.VISIBLE);
        ObjectAnimator.ofFloat(button3,"alpha",0.0f,0.5f).setDuration(1000).start();
        keydown=1;

    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

    if (keydown==1) {
            editText1.setVisibility(View.GONE);
            editText2.setVisibility(View.GONE);
            button3.setVisibility(View.GONE);
            toolbar.setVisibility(View.GONE);
            button1.setVisibility(View.VISIBLE);
            ObjectAnimator.ofFloat(button1, "alpha", 0.0f, 0.5f).setDuration(1000).start();
            button2.setVisibility(View.VISIBLE);
            ObjectAnimator.ofFloat(button2, "alpha", 0.0f, 0.5f).setDuration(1000).start();
            keydown=-1;
            return false;
        }
      else
        return super.onKeyDown(keyCode, event);

    }
    public void faceClick(View view) {
    }

    public void login_in_Click(View view) {
        Student student = new Student();
        student.setStudent(new Student.StudentBean(editText1.getText().toString(),editText2.getText().toString()));
        String msg = new Gson().toJson(student);

        application = (MyApplication) getApplication();
        application.setStuId(editText1.getText().toString());

//        OkGo.<String>post("https://www.vingyun.com/face_attendance/studentLogin.action")
//                .tag(this)
//                .upJson(msg)
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        Log.e("登录回调测试","onSuccess"+response.body());
//                    }
//                });


        startActivity(new Intent(this,HomeActivity.class));
    }

    @Override
    protected void onPause() {
        videoView.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        videoView.start();
        super.onResume();
    }
}
