package com.example.jiashuaishuai.listiviewgroup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jiashuaishuai on 2016/5/12.
 */
public class ListAdapter extends BaseAdapter {
    private List<TextGroupBean> list;
    private Context context;
    private static final int TITLE = 1;
    private static final int ITEM = 2;
    private LayoutInflater mInflater;

    public ListAdapter(Context context, List<TextGroupBean> list) {
        this.list = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        int count = 0;
        for (TextGroupBean bean : list) {
            count += bean.getCount();
        }
        return count;
    }

    @Override
    public Object getItem(int position) {
        if (null == list || position < 0 || position > getCount()) {
            return null;
        }
        // 同一分类内，第一个元素的索引值
        int textGroupFirstIndex = 0;

        for (TextGroupBean bean : list) {
            int size = bean.getCount();
            // 在当前分类中的索引值
            int groupIndex = position - textGroupFirstIndex;
            // item在当前分类内
            if (groupIndex < size) {
                return bean.getItem(groupIndex);
            }

            // 索引移动到当前分类结尾，即下一个分类第一个元素索引
            textGroupFirstIndex += size;
        }


        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {

        if (null == list || position < 0 || position > getCount()) {
            return ITEM;
        }

        // 同一分类内，第一个元素的索引值
        int textGroupFirstIndex = 0;

        for (TextGroupBean bean : list) {
            int size = bean.getCount();
            // 在当前分类中的索引值
            int groupIndex = position - textGroupFirstIndex;
            // item在当前分类内
            if (groupIndex == 0) {
                return TITLE;
            }

            // 索引移动到当前分类结尾，即下一个分类第一个元素索引
            textGroupFirstIndex += size;
        }

        return ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }
    @Override
    public boolean isEnabled(int position) {
        return getItemViewType(position) != TITLE;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        switch (type) {
            case TITLE:
                convertView = mInflater.inflate(R.layout.list_item_1, null);
                TextView title = (TextView) convertView.findViewById(R.id.name);
                title.setText((String) getItem(position));
                break;
            case ITEM:
                convertView = mInflater.inflate(R.layout.list_item_2, null);
                TextView age = (TextView) convertView.findViewById(R.id.tv1);
                TextView sex = (TextView) convertView.findViewById(R.id.tv2);
                TestBean bean = (TestBean) getItem(position);
                age.setText(bean.age);
                sex.setText(bean.sex);
                break;
        }
        return convertView;
    }
}
