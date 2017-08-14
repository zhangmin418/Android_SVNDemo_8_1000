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
import android.webkit.WebView;
import android.widget.TextView;

import jiyun.com.example.lenovo.android_svndemo_8_10.R;

/**
 * Created by lenovo on 2017/8/11.
 */

public class ThreeFragment extends Fragment {
    private WebView webview;
    private BroadcastReceiver recriver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String wapUrl = intent.getStringExtra("wapUrl");
            webview.loadUrl(wapUrl);
        }
    };

    public ThreeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, null);

        initView(view);
        initData();
        return view;
    }

    private void initData() {
        IntentFilter filter=new IntentFilter("aaa");
        getActivity().registerReceiver(recriver,filter);
    }


    private void initView(View view) {
        webview = (WebView) view.findViewById(R.id.webview);
    }
}
