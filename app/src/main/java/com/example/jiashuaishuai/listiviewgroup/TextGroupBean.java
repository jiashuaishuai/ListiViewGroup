package com.example.jiashuaishuai.listiviewgroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by jiashuaishuai on 2016/5/12.
 */
public class TextGroupBean {

    public String title;
    public List<TestBean> list = new ArrayList<>();


    public int getCount() {

        return list.size() + 1;
    }

    public Object getItem(int postion) {
        if (postion == 0)
            return title;
        else
            return list.get(postion-1);
    }

    public void listAdd(TestBean testBean) {
        list.add(testBean);
    }
}
