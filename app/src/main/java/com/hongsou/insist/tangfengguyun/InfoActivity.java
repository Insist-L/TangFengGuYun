package com.hongsou.insist.tangfengguyun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InfoActivity extends AppCompatActivity {


    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_author)
    TextView mTvAuthor;
    @BindView(R.id.tv_content)
    TextView mTvContent;
    @BindView(R.id.ll_item)
    LinearLayout mLlItem;
    @BindView(R.id.iv_laba)
    ImageView mIvLaba;
    @BindView(R.id.iv_pause)
    ImageView mIvPause;
    @BindView(R.id.iv_start)
    ImageView mIvStart;
    @BindView(R.id.ll_play)
    LinearLayout mLlPlay;
    @BindView(R.id.container)
    RelativeLayout mContainer;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.ll_top)
    RelativeLayout mLlTop;
    @BindView(R.id.btn_click)
    Button mBtnClick;
    @BindView(R.id.iv_background)
    ImageView mIvBackground;

    private String[] title = new String[]{"写景诗", "抒情诗", "咏物诗"};
    private String[] name = new String[]{"《望庐山瀑布》", "《静夜思》", "《青松》"};
    private String[] author = new String[]{"李白", "李白", "陈毅"};
    private String[] content = new String[]{"日照香炉生紫烟，\n遥看瀑布挂前川。\n飞流直下三千尺，\n疑是银河落九天。",
            "床前明月光，\n疑是地上霜。\n举头望明月，\n低头思故乡。",
            "大雪压青松，\n青松挺且直。\n要知松高洁，\n待到雪化时。"};
    private String[] info = new String[]{"望庐山瀑布 , 李白 , 日照香炉生紫烟，遥看瀑布挂前川。飞流直下三千尺，疑是银河落九天。",
            "静夜思 , 李白 , 床前明月光，疑是地上霜。举头望明月，低头思故乡。",
            "青松 , 陈毅 , 大雪压青松，青松挺且直。要知松高洁，待到雪化时。"};

    private int mPosition;
    private int childPosition;
    private boolean isSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
        mPosition = getIntent().getIntExtra("position", 0);
        childPosition = getIntent().getIntExtra("childPosition", 0);
        initView();

        TTSUtils.getInstance().init(this);

        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoActivity.this.finish();
            }
        });
        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoActivity.this.finish();
            }
        });
    }

    private void initView() {
        mIvBackground.setImageResource(Constant.getImg(mPosition));
        mTvTitle.setText(title[mPosition]);
        mTvName.setText(Constant.getName(mPosition, childPosition));
        mTvAuthor.setText(Constant.getAuthor(mPosition, childPosition));
        mTvContent.setText(Constant.getContent(mPosition, childPosition));

    }

    @OnClick({R.id.iv_laba, R.id.iv_start, R.id.iv_pause})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_laba:
                TTSUtils.getInstance().speak(this, Constant.getInfo(mPosition, childPosition));
                mIvLaba.setVisibility(View.GONE);
                mLlPlay.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_start:
                TTSUtils.getInstance().resume();
                break;
            case R.id.iv_pause:
                TTSUtils.getInstance().pause();
                break;
        }
    }

    public void setVisible() {
        mIvLaba.setVisibility(View.VISIBLE);
        mLlPlay.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TTSUtils.getInstance().release();
    }

}
