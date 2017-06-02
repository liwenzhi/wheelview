package com.example.wheelview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.wheelview.R;
import com.example.wheelview.loopview.LoopView;
import com.example.wheelview.loopview.OnItemSelectedListener;
import com.example.wheelview.utils.TimeUtil;

import java.util.ArrayList;

/**
 * 时间选择页面,第二种
 */
public class DataTimeViewActivity2 extends Activity {

    LoopView loopView_year;
    LoopView loopView_mooth;
    LoopView loopView_day;
    ArrayList<String> list_year = new ArrayList<String>();
    ArrayList<String> list_mooth = new ArrayList<String>();
    ArrayList<String> list_day = new ArrayList<String>();

    int year;
    int mooth;
    int day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data2);
        initView();
        initData();
        initEvent();


    }

    private void initView() {
        loopView_year = (LoopView) findViewById(R.id.loopView_year);
        loopView_mooth = (LoopView) findViewById(R.id.loopView_mooth);
        loopView_day = (LoopView) findViewById(R.id.loopView_day);

    }

    private void initData() {
        //设置是否不循环播放
//        loopView_year.setNotLoop();
        year = getYear();
        mooth = getMooth();
        day = getDay();

        //年的时间
        for (int i = 2000; i < 2031; i++) {
            list_year.add("" + i);
        }
        //设置原始数据
        loopView_year.setItems(list_year);
        for (int i = 0; i < list_year.size(); i++) {
            if (Integer.parseInt(list_year.get(i)) == getYear()) {
                loopView_year.setCurrentPosition(i);
            }
        }


        //月的时间
        for (int i = 1; i < 13; i++) {
            list_mooth.add("" + i);
        }
        //设置原始数据
        loopView_mooth.setItems(list_mooth);
        loopView_mooth.setCurrentPosition(getMooth() - 1);

        //日的时间
        for (int i = 1; i < 32; i++) {
            list_day.add("" + i);
        }
        //设置原始数据
        loopView_day.setItems(list_day);
        loopView_day.setCurrentPosition(getDay() - 1);


    }

    private void initEvent() {
        //滚动监听
        loopView_year.setListener(new OnItemSelectedListener() {
            public void onItemSelected(int index) {
                year = Integer.parseInt(list_year.get(index));
            }
        });

        loopView_mooth.setListener(new OnItemSelectedListener() {
            public void onItemSelected(int index) {
                mooth = Integer.parseInt(list_mooth.get(index));
            }
        });

        loopView_day.setListener(new OnItemSelectedListener() {
            public void onItemSelected(int index) {
                day = Integer.parseInt(list_day.get(index));
            }
        });
    }


    public void selectData(View view) {
        Toast.makeText(this, "你选中的时间是：" + year + "年" + mooth + "月" + day + "日", Toast.LENGTH_SHORT).show();
    }


    /**
     * 获取得当前时间的天数
     *
     * @return
     */
    public int getDay() {
        return TimeUtil.getTimeInt("d");
    }


    /**
     * 获得当前时间的月份
     */
    public int getMooth() {
        return TimeUtil.getTimeInt("M");
    }

    /**
     * 获得当前时间的年份
     */
    public int getYear() {
        return TimeUtil.getTimeInt("yyyy");
    }

}