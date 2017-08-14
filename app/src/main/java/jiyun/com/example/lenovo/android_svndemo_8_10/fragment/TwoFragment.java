package jiyun.com.example.lenovo.android_svndemo_8_10.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jiyun.com.example.lenovo.android_svndemo_8_10.R;

/**
 * Created by lenovo on 2017/8/11.
 */

public class TwoFragment extends Fragment {
    private ImageView image;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String img = intent.getStringExtra("img");
            Glide.with(getActivity().getApplication()).load(img).into(image);
        }
    };
    public TwoFragment() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, null);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        IntentFilter intentFilter = new IntentFilter("aaa");
        getActivity().registerReceiver(receiver, intentFilter);
    }

    private void initView(View view) {
        image = (ImageView) view.findViewById(R.id.image);
    }
}
