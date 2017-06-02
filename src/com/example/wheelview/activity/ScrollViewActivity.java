package com.example.wheelview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;
import com.example.wheelview.R;
import com.example.wheelview.loopview.LoopView;
import com.example.wheelview.loopview.OnItemSelectedListener;

import java.util.ArrayList;

/**
 * Created by Weidongjian on 2017/3/25.
 */

public class ScrollViewActivity extends Activity {

    private Toast toast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

        final LoopView loopView = (LoopView) findViewById(R.id.loopView);

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 15; i++) {
            list.add("item " + i);
        }
        // 滚动监听
        loopView.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                if (toast == null) {
                    toast = Toast.makeText(ScrollViewActivity.this, "item " + index, Toast.LENGTH_SHORT);
                }
                toast.setText("item " + index);
                toast.show();
            }
        });
        // 设置原始数据
        loopView.setItems(list);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loopView.setCurrentPosition(0);
            }
        });

    }
}
