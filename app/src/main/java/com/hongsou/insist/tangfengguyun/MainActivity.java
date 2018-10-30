package com.hongsou.insist.tangfengguyun;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.container)
    RelativeLayout mContainer;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.listView)
    ListView mListView;

    private String[] author = new String[]{"李白", "李白", "陈毅"};
    private String[] content = new String[]{"日照香炉生紫烟，\n遥看瀑布挂前川。\n飞流直下三千尺，\n疑是银河落九天。",
            "床前明月光，\n疑是地上霜。\n举头望明月，\n低头思故乡。",
            "大雪压青松，\n青松挺且直。\n要知松高洁，\n待到雪化时。"};
    private String[] name1 = new String[]{"《望庐山瀑布日》", "《出塞》", "《春晓》",
            "《杂诗》", "《寻隐者不遇》", "《早发白帝城》", "《九月九日忆山东兄弟》", "《登鹳雀楼》"};
    private String[] name2 = new String[]{"《静夜思》", "《凉州词》",
            "《赤壁》", "《近试上张水部》", "《伊州歌》", "《哥舒歌》", "《宫词》"};
    private String[] name3 = new String[]{"《青松》", "《送别》", "《八阵图》", "《红豆》",
            "《鹿柴》", "《送孟浩然之广陵》", "《江雪》", "《枫桥夜泊》"};
    private int mPosition;

    private ArrayList<HashMap<String, String>> mData;
    private ArrayList<HashMap<String, String>> mArrayList1;
    private ArrayList<HashMap<String, String>> mArrayList2;
    private ArrayList<HashMap<String, String>> mArrayList3;
    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        initView();

    }

    private void initView() {
        mTab.addTab(mTab.newTab().setText("写景诗"));
        mTab.addTab(mTab.newTab().setText("抒情诗"));
        mTab.addTab(mTab.newTab().setText("咏物诗"));

        if (mData == null){
            mData = new ArrayList<>();
        }
        mData.addAll(mArrayList1);
        mAdapter = new SimpleAdapter(this, mData, R.layout.item_title_list,
                new String[]{"name"}, new int[]{R.id.tv_name});
        mListView.setAdapter(mAdapter);

        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPosition = tab.getPosition();
//                mTvName.setText(name[tab.getPosition()]);
//                mTvAuthor.setText(author[tab.getPosition()]);
//                mTvContent.setText(content[tab.getPosition()]);

                mData.clear();
                if (mPosition == 0){
                    mData.addAll(mArrayList1);
                }else if (mPosition == 1){
                    mData.addAll(mArrayList2);
                }else if (mPosition == 2){
                    mData.addAll(mArrayList3);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, InfoActivity.class)
                        .putExtra("position", mPosition)
                        .putExtra("childPosition", position));
            }
        });
    }

    private void initData() {
        if (mArrayList1 == null){
            mArrayList1 = new ArrayList<>();
        }
        if (mArrayList2 == null){
            mArrayList2 = new ArrayList<>();
        }
        if (mArrayList3 == null){
            mArrayList3 = new ArrayList<>();
        }

        for (int i = 0; i < name1.length; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("name", name1[i]);
            mArrayList1.add(map);
        }
        for (int i = 0; i < name2.length; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("name", name2[i]);
            mArrayList2.add(map);
        }
        for (int i = 0; i < name3.length; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("name", name3[i]);
            mArrayList3.add(map);
        }
    }

}
