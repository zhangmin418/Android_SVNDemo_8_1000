package jiyun.com.example.lenovo.android_svndemo_8_10.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/8/11.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mList;
    public MyFragmentAdapter(FragmentManager fm,ArrayList<Fragment> mList) {
        super(fm);
        this.mList = mList;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
