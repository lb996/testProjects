package com.lb.myeventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

public class Main2Activity extends AppCompatActivity {

    private Button btnSkip1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();
    }


//    public void onEventMainThread(FirstEvent event){
//        String msg = "onEventMainThread收到了消息：" + event.getMsg();
//        Log.d("harvic", msg);
//        tvShowMsg.setText(msg);
//        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
//    }

    private void initView() {
        btnSkip1 = (Button)findViewById(R.id.btn_skip1);
        btnSkip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("2222222222222222", "onClick: "+new FirstEvent("111").getMsg());
                EventBus.getDefault().postSticky(new FirstEvent("send msg from 2 to 1"));
                finish();
            }
        });
    }
}
