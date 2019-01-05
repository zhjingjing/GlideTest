package com.zj.glidetest;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.zj.glidetest.databinding.ActivityMainBinding;

import java.security.MessageDigest;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final static String URL="https://raw.githubusercontent.com/zhjingjing/GlideTest/master/image/image_test.jpeg";
    private final static String URL_GIF="https://raw.githubusercontent.com/zhjingjing/GlideTest/master/image/gif_test.gif";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil. setContentView(this,R.layout.activity_main);
        binding.setPresenter(this);
    }


    //加载图片
    public void onLoadPic(){
        //应用图片
//        GlideApp.with(this).load(R.mipmap.ic_launcher).into(binding.ivPic);
        //网络图片
//        GlideApp.with(this).load(URL).into(binding.ivPic);
        //加载gif 应用图片
//        GlideApp.with(this).load(R.drawable.gif_test).placeholder(R.mipmap.ic_launcher).into(binding.ivPic);
        //加载gif 网络图片
//        GlideApp.with(this).load(URL_GIF).diskCacheStrategy(DiskCacheStrategy.ALL) .into(binding.ivPic);

        //设置gif 播放次数
//         GlideApp.with(this).load(URL_GIF).diskCacheStrategy(DiskCacheStrategy.ALL).into(new SimpleTarget<Drawable>() {
//             @Override
//             public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
//                 GifDrawable gifDrawable= (GifDrawable) resource;
//                 gifDrawable.setLoopCount(1);
//                 binding.ivPic.setImageDrawable(gifDrawable);
//                 gifDrawable.start();
//             }
//         });
        //错误加载指定gif，却传入静态图片地址
//        GlideApp.with(this).asGif().load(URL).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(R.mipmap.ic_launcher).error(R.drawable.error) .into(binding.ivPic);


        //圆形图片
        GlideApp.with(this).load(URL).circleCrop().into(binding.ivPic);

        //圆角图片
        RoundedCorners corners=new RoundedCorners(50);
        RequestOptions options=RequestOptions.bitmapTransform(corners).override(300,300);
        GlideApp.with(this).load(URL).apply(options).into(binding.ivPic2);

        //设置淡入淡出效果
        GlideApp.with(this).load(URL_GIF) .transition(DrawableTransitionOptions.withCrossFade(5000)).into(binding.ivPic);

        //高斯模糊
        GlideApp.with(this)
                .load(URL_GIF)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.error)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(5, 1)))
                .into(binding.ivPic2);


    }




}
