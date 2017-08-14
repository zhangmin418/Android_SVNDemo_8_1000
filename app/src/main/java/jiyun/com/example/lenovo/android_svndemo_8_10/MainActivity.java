package jiyun.com.example.lenovo.android_svndemo_8_10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import jiyun.com.example.lenovo.android_svndemo_8_10.adapter.MyRollAdapter;
import jiyun.com.example.lenovo.android_svndemo_8_10.view.RollView;
//https://www.zhihu.com/question/32298079

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RollView rpv_view;
    private Button bt_kaiqi;
    private ViewPager viewPager;
    private MyRollAdapter myRollAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        rpv_view.setPlayDelay(1000);
        myRollAdapter = new MyRollAdapter();
        rpv_view.setAdapter(myRollAdapter);
        viewPager = rpv_view.getViewPager();
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (viewPager.getCurrentItem()!=(myRollAdapter.i.length-1)){
                    bt_kaiqi.setVisibility(View.VISIBLE);
                }else{
                    rpv_view.pause();
                    rpv_view.setHintViewVisibility(View.INVISIBLE);
                    bt_kaiqi.setVisibility(View.VISIBLE);
                }

            }
        });
    }

    private void initView() {
        rpv_view = (RollView) findViewById(R.id.rpv_view);
        bt_kaiqi = (Button) findViewById(R.id.bt_kaiqi);

        bt_kaiqi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_kaiqi:
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                break;
        }
    }
}
