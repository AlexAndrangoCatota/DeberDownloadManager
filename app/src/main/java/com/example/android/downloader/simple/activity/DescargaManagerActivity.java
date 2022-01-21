package com.example.android.downloader.simple.activity;

import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.example.android.common.activity.BaseActivity;
import com.example.android.downloader.simple.R;
import com.example.android.downloader.simple.adapter.DownloadManagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class DescargaManagerActivity extends BaseActivity {

    private TabLayout tl;
    private ViewPager vp;
    private DownloadManagerAdapter downloadManagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descarga_interf);
    }

    @Override
    protected void initView() {
        super.initView();
        tl = (TabLayout) findViewById(R.id.tl);
        vp = (ViewPager) findViewById(R.id.vp);
    }

    @Override
    protected void initData() {
        super.initData();

        downloadManagerAdapter = new DownloadManagerAdapter(
                getSupportFragmentManager(), getActivity());

        List<String> strings = new ArrayList<>();
        strings.add("Downloading");
        strings.add("Downloaded");

        downloadManagerAdapter.setData(strings);
        vp.setAdapter(downloadManagerAdapter);
        tl.setupWithViewPager(vp);
        tl.setTabsFromPagerAdapter(downloadManagerAdapter);

    }
}
