package com.example.jiashuaishuai.listiviewgroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView list_view;
    private List<TextGroupBean> groupList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_view = (ListView) findViewById(R.id.list_view);
        initData();

        ListAdapter adapter = new ListAdapter(this, groupList);
        list_view.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initData() {
        for (int i = 0; i < 4; i++) {
            TextGroupBean bean = new TextGroupBean();
            bean.title = "title" + i;
            bean.listAdd(new TestBean("age" + i, "sex" + i));
            bean.listAdd(new TestBean("ageee" + i, "sex" + i));
            bean.listAdd(new TestBean("ageee" + i, "sex" + i));
            bean.listAdd(new TestBean("ageee" + i, "sex" + i));
            groupList.add(bean);
        }
    }
}
