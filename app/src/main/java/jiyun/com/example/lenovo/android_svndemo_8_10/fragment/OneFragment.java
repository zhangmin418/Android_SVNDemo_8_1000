package jiyun.com.example.lenovo.android_svndemo_8_10.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jiyun.com.example.lenovo.android_svndemo_8_10.Entity.Bean;
import jiyun.com.example.lenovo.android_svndemo_8_10.R;
import jiyun.com.example.lenovo.android_svndemo_8_10.adapter.RecyclerAdapter;
import jiyun.com.example.lenovo.android_svndemo_8_10.utils.OkHttpUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by lenovo on 2017/8/11.
 */

public class OneFragment extends Fragment {
    private String url = "http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%AB%98%E6%99%93%E6%9D%BE&bk_length=600";
    private ArrayList<Bean.CardBean> mList = new ArrayList<>();
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView rv_recycler_fragment;

    public OneFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, null);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        OkHttpUtil.getInstance().loadData_Get(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG",e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                Bean bean = gson.fromJson(string, Bean.class);
                List<Bean.CardBean> card = bean.getCard();

                String image = bean.getImage();
                String wapUrl = bean.getWapUrl();
                Intent intent = new Intent("aaa");
                intent.putExtra("img", image);
                intent.putExtra("wapUrl", wapUrl);
                getActivity().sendBroadcast(intent);

                mList.addAll(card);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rv_recycler_fragment.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                        recyclerAdapter = new RecyclerAdapter(getActivity(),mList);
                        rv_recycler_fragment.setAdapter(recyclerAdapter);
                        recyclerAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private void initView(View view) {
        rv_recycler_fragment = (RecyclerView) view.findViewById(R.id.rv_recycler_fragment);
    }
}
