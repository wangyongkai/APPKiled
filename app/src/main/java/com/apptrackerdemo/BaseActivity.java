package com.apptrackerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


/**
 * Created by lvzishen on 2016/5/5.
 */
public abstract class BaseActivity extends AppCompatActivity {
    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", "onCreate" + this.toString());
        Log.d("BaseActivity", "AppStatus=" + AppStatusManager.getInstance().getAppStatus());
        setUpContentView();
        setUpView();
        setUpData(savedInstanceState);
//        switch (AppStatusManager.getInstance().getAppStatus()) {
//            /**
//             * 应用被强杀
//             */
//            case AppStatusConstant.STATUS_FORCE_KILLED:
//                //跳到主页,主页lauchmode SINGLETASK
//                Log.d("BaseActivity", "强杀activity=" + this.toString());
//               // protectApp();
//                break;
//            /**
//             * 用户被踢或者TOKEN失效
//             */
//            case AppStatusConstant.STATUS_KICK_OUT:
//                //弹出对话框,点击之后跳到主页,清除用户信息,运行退出登录逻辑
////                Intent intent=new Intent(this,MainActivity.class);
////                startActivity(intent);
//                break;
//            case AppStatusConstant.STATUS_NORMAL:
//                Log.d("BaseActivity", "正常activity=" + this.toString());
//                setUpContentView();
//                setUpView();
//               setUpData(savedInstanceState);
//                break;
//        }


    }

    /**
     * 加载布局
     */
    protected abstract void setUpContentView();

    /**
     * view初始化
     */
    protected abstract void setUpView();

    /**
     * 加载数据
     */
    protected abstract void setUpData(Bundle savedInstanceState);

    protected void protectApp() {
        Intent intent = new Intent(this, SplashActivity.class);
        intent.putExtra(AppStatusConstant.KEY_HOME_ACTION, AppStatusConstant.ACTION_RESTART_APP);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // 返回默认结束当前页面
        finish();
    }


}
