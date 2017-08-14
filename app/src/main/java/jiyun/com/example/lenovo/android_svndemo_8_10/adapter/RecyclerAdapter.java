package jiyun.com.example.lenovo.android_svndemo_8_10.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import jiyun.com.example.lenovo.android_svndemo_8_10.Entity.Bean;
import jiyun.com.example.lenovo.android_svndemo_8_10.R;

/**
 * Created by lenovo on 2017/8/11.
 */

public class RecyclerAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Bean.CardBean> mList;

    public RecyclerAdapter(Context context, ArrayList<Bean.CardBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    class MyHolder extends RecyclerView.ViewHolder{
        private TextView name,info;
        public MyHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.recy_name);
            info = (TextView) itemView.findViewById(R.id.recy_info);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.fragments_threes,null);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        myHolder.name.setText(mList.get(position).getName());
        myHolder.info.setText(mList.get(position).getValue().get(0));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
