package jiyun.com.example.lenovo.android_svndemo_8_10.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import jiyun.com.example.lenovo.android_svndemo_8_10.R;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by lenovo on 2017/8/11.
 */

public class MyListAdapter extends BaseAdapter {
    private Context context;
    private List<String> mList;

    public MyListAdapter(Context context, List<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_list,null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.lv_listview);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(mList.get(position));
        return convertView;
    }
    class ViewHolder{
        private TextView textView;
    }
}
