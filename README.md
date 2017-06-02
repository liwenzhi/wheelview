#wheelview滚动效果的View
这段时间需要用到一个时间选择器，但是不能使用日期对话框，
因为它是筛选条件框架下的，只能是View！这个WheelView改造后可以达到要求！
这个wheelview框架使用的类不多，就几个，还有一些资源文件。
我根据这个框架设计了日期的选择器。

##主页面：

![1](http://i.imgur.com/cRurb6a.png)

###第一种日期选择器页面：

![2](http://i.imgur.com/A8epEj2.png)

##动态效果：

![3](http://i.imgur.com/KemMe4n.gif)

#使用：
具体的实现是一个LoopView的类，这是一个继承View的类！
理解LoopView的公开方法就可以了。
##1.布局文件
```

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              xmlns:app="http://schemas.android.com/apk/res-auto"
              android:orientation="vertical"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:background="#fff"
        >

    <com.example.wheelview.loopview.LoopView
        android:layout_marginTop="50dp"
        android:id="@+id/loopView"
        android:layout_width="match_parent"
        android:layout_height="150dp"
        app:awv_textsize="18"
        />

</LinearLayout>

```

##2.控制代码
```
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

        
    }

}


```

那个日期选择器就是使用三个LoopView结合而成的！
LoopView类里面控制字体颜色和横线颜色的地方：
```
//中间选中的字体颜色：     灰色：0xff313131，橙色：0xffec6f1a
centerTextColor = typedArray.getInteger(R.styleable.androidWheelView_awv_centerTextColor, 0xffec6f1a);
//没被选中的字体的颜色 
outerTextColor = typedArray.getInteger(R.styleable.androidWheelView_awv_outerTextColor, 0xffafafaf);
//中间字体上下两条横线的颜色
dividerColor = typedArray.getInteger(R.styleable.androidWheelView_awv_dividerTextColor, 0xffc5c5c5);
```
其他的控制可以参考我的代码
我的项目的代码：https://github.com/liwenzhi/wheelview

#共勉：去争取你想要拥有的，而不是停留在生活中剩余给你的！
