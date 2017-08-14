package jiyun.com.example.lenovo.android_svndemo_8_10.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.adapter.StaticPagerAdapter;

import jiyun.com.example.lenovo.android_svndemo_8_10.R;

/**
 * Created by lenovo on 2017/8/11.
 */

public class MyRollAdapter extends StaticPagerAdapter{
    public int[] i = {
            R.mipmap.c,
            R.mipmap.ca,
            R.mipmap.d,
            R.mipmap.k,
            R.mipmap.i};

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView imageView = new ImageView(container.getContext());
        imageView.setImageResource(i[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return imageView;
    }

    @Override
    public int getCount() {
        return i.length;
    }
}
