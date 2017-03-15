package com.rshealth.viewpagerdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 百强 on 2017/1/9.
 */

public class HomeGridViewAdapter extends BaseAdapter {
    private Context context;
    private List<HomeModel> homelist;

    public HomeGridViewAdapter(Context context, List<HomeModel> homelist) {
        this.context = context;
        this.homelist = homelist;
    }

    @Override
    public int getCount() {
        return homelist.size();
    }

    @Override
    public Object getItem(int position) {
        return homelist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_gridview, null);
        }
        ImageView iv_icon = ViewHolder.get(convertView, R.id.iv_icon);
        TextView icon_title_ch = ViewHolder.get(convertView, R.id.icon_title_ch);
        TextView icon_title_en = ViewHolder.get(convertView, R.id.icon_title_en);

        icon_title_ch.setText(homelist.get(position).name);
        icon_title_en.setText(homelist.get(position).name_en);
        return convertView;
    }
}
