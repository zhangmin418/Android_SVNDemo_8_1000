package jiyun.com.example.lenovo.android_svndemo_8_10;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.example.lenovo.android_svndemo_8_10.adapter.MyFragmentAdapter;
import jiyun.com.example.lenovo.android_svndemo_8_10.adapter.MyListAdapter;
import jiyun.com.example.lenovo.android_svndemo_8_10.fragment.OneFragment;
import jiyun.com.example.lenovo.android_svndemo_8_10.fragment.ThreeFragment;
import jiyun.com.example.lenovo.android_svndemo_8_10.fragment.TwoFragment;

public class SecondActivity extends AppCompatActivity {


    private Toolbar tb_toolbar;
    private ListView lv_list;
    private ViewPager vp_viewpager;
    private List<String> mList = new ArrayList<>();
    private MyListAdapter myListAdapter;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    private MyFragmentAdapter myFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        initToolBar();
        initListData();
        initFragment();


        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        vp_viewpager.setCurrentItem(0);
                        break;
                    case 1:
                        vp_viewpager.setCurrentItem(1);
                        break;
                    case 2:
                        vp_viewpager.setCurrentItem(2);
                        break;
                }
            }
        });

    }

    private void initFragment() {
        fragmentList.add(new OneFragment());
        fragmentList.add(new TwoFragment());
        fragmentList.add(new ThreeFragment());

        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(),fragmentList);
        vp_viewpager.setAdapter(myFragmentAdapter);
    }

    private void initListData() {
        for (int i = 0; i < 1; i++) {
            mList.add("个人简介");
            mList.add("个人图片");
            mList.add("更多内容");
        }
        myListAdapter = new MyListAdapter(SecondActivity.this,mList);
        lv_list.setAdapter(myListAdapter);
    }

    private void initToolBar() {
        tb_toolbar.setTitle("高晓松简介");
        setSupportActionBar(tb_toolbar);

    }

    private void initView() {
        tb_toolbar = (Toolbar) findViewById(R.id.tb_toolbar);
        lv_list = (ListView) findViewById(R.id.lv_list_second);
        vp_viewpager = (ViewPager) findViewById(R.id.vp_viewpager);
    }
}
