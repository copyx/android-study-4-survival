package com.copyx.androidstudy;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListViewPracticeActivity extends AppCompatActivity {

    ListView listView;
    SingerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_practice);

        listView = findViewById(R.id.list_view);

        adapter = new SingerAdapter();

        adapter.addItem(new SingerItem("소녀시대", "010-0000-0000", 20, android.R.drawable.ic_lock_idle_lock));
        adapter.addItem(new SingerItem("걸스데이", "010-0000-0000", 20, android.R.drawable.ic_lock_idle_lock));
        adapter.addItem(new SingerItem("여자친구", "010-0000-0000", 20, android.R.drawable.ic_lock_idle_lock));
        adapter.addItem(new SingerItem("티아라", "010-0000-0000", 20, android.R.drawable.ic_lock_idle_lock));
        adapter.addItem(new SingerItem("AOA", "010-0000-0000", 20, android.R.drawable.ic_lock_idle_lock));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "Selected : " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<>();

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SingerItem item = items.get(position);

            SingerItemView view = new SingerItemView(getApplicationContext());
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setAge(item.getAge());
            view.setImage(item.getResId());

            return view;
        }

        public void addItem(SingerItem item) {
            items.add(item);
        }
    }
}
