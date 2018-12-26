package com.zj.glidetest;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zj.glidetest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final static String URL="";
    private final static String URL_GIF="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil. setContentView(this,R.layout.activity_main);
        binding.setPresenter(this);
    }


    //加载图片
    public void onLoadPic(){
        //应用图片
        GlideApp.with(this).load(R.mipmap.ic_launcher).into(binding.ivPic);


    }
}
