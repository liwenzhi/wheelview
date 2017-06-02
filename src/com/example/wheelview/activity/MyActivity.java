package com.example.wheelview.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.wheelview.R;
import com.example.wheelview.loopview.LoopView;
import com.example.wheelview.loopview.OnItemSelectedListener;

import java.util.ArrayList;

public class MyActivity extends Activity {

    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LoopView loopView = (LoopView) findViewById(R.id.loopView);

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 15; i++) {
            list.add("item " + i);
        }
        //设置是否循环播放
//        loopView.setNotLoop();
        //滚动监听
        loopView.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                if (toast == null) {
                    toast = Toast.makeText(MyActivity.this, "item " + index, Toast.LENGTH_SHORT);
                }
                toast.setText("item " + index);
                toast.show();
            }
        });
        //设置原始数据
        loopView.setItems(list);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, DataTimeViewActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, ScrollViewActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, DataTimeViewActivity2.class);
                startActivity(intent);
            }
        });
    }

}
