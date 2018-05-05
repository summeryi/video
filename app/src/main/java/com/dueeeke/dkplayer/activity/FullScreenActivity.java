package com.dueeeke.dkplayer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dueeeke.dkplayer.widget.controller.FullScreenController;
import com.dueeeke.dkplayer.widget.videoview.FullScreenIjkVideoView;
import com.dueeeke.videoplayer.player.IjkVideoView;

/**
 * 全屏播放
 * Created by Devlin_n on 2017/4/21.
 */

public class FullScreenActivity extends AppCompatActivity{

    private FullScreenIjkVideoView ijkVideoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ijkVideoView = new FullScreenIjkVideoView(this);
        setContentView(ijkVideoView);
        ijkVideoView
//                .useAndroidMediaPlayer()
//                .autoRotate()
//                .setTitle("这是一个标题")
                .setUrl("http://video.ding1kj.com/15180647773494789040797595342266.mp4")
                .setVideoController(new FullScreenController(this))
                .start();
        ijkVideoView.setScreenScale(IjkVideoView.SCREEN_SCALE_DEFAULT);

    }

    @Override
    protected void onPause() {
        super.onPause();
        ijkVideoView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ijkVideoView.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ijkVideoView.release();
    }

    @Override
    public void onBackPressed() {
        if (!ijkVideoView.onBackPressed()){
            super.onBackPressed();
        }
    }
}
