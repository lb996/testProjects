package com.lb.myeventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvShowMsg;
    private Button btnSkip2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initView();

    }

    private void initView() {
        tvShowMsg = (TextView)findViewById(R.id.tv_showMsg);
        btnSkip2 = (Button)findViewById(R.id.btn_skip2);

        btnSkip2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_skip2:

                Intent intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                EventBus.getDefault().register(this);
                break;
        }
    }


    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onEventMainMethod(FirstEvent event){
        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        Log.d("harvic", msg);
        tvShowMsg.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Subscribe(threadMode=ThreadMode.MAIN,sticky=true)
    public void onEventMainStickyMethod(FirstEvent event){
        String msg = "onEventMainStickyMethod收到了粘性消息：" + event.getMsg();
        Log.d("harvic", msg);
        tvShowMsg.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
