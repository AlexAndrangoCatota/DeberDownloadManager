package com.example.android.downloader.simple.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.common.activity.BaseActivity;
import com.example.android.common.adapter.BaseRecyclerViewAdapter.OnItemClickListener;
import com.example.android.downloader.simple.R;
import com.example.android.downloader.simple.adapter.DownloadListAdapter;
import com.example.android.downloader.simple.domain.MyBusinessInfo;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends BaseActivity implements OnItemClickListener {

    private static final int REQUEST_DOWNLOAD_DETAIL_PAGE = 100;

    private RecyclerView rv;
    private DownloadListAdapter downloadListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


    }

    @Override
    public void initListener() {
        downloadListAdapter.setOnItemClickListener(this);
    }

    @Override
    public void initData() {
        downloadListAdapter = new DownloadListAdapter(this);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(downloadListAdapter);

        downloadListAdapter.setData(getDownloadListData());
    }

    private List<MyBusinessInfo> getDownloadListData() {
        ArrayList<MyBusinessInfo> myBusinessInfos = new ArrayList<>();
        myBusinessInfos.add(new MyBusinessInfo("Instrucciones hadoop.pdf",
                "https://i.ibb.co/wSjZ2N9/imagenpdf.webp",
                "http://eventos.citius.usc.es/bigdata/workshops/hadoop-taller.pdf"));
        myBusinessInfos.add(new MyBusinessInfo("Desarrollo apps android",
                "https://i.ibb.co/wSjZ2N9/imagenpdf.webp",
                "https://www.uma.es/media/tinyimages/file/android_ed2.pdf"));
        myBusinessInfos.add(new MyBusinessInfo("Manual Android Studio",
                "https://i.ibb.co/wSjZ2N9/imagenpdf.webp",
                "https://cursoslared.com/recursoslibre/TutorialAndroidPrincipiantes.pdf"));
        myBusinessInfos.add(new MyBusinessInfo("Programación JavaScript",
                "https://i.ibb.co/wSjZ2N9/imagenpdf.webp",
                "https://www.um.es/docencia/barzana/DAWEB/Lenguaje-de-programacion-JavaScript-1.pdf"));
        myBusinessInfos.add(new MyBusinessInfo("Manual JavaScript",
                "https://i.ibb.co/wSjZ2N9/imagenpdf.webp",
                "https://waltercarnero.com/cfp/tpprgweb/Libro2.pdf"));
        myBusinessInfos.add(new MyBusinessInfo("WebServices Developer 2021",
                "https://i.ibb.co/wSjZ2N9/imagenpdf.webp",
                "https://www.fedex.com/us/developer/downloads/pdfs/2021/FedEx_WebServices_DevelopersGuide_v2021.pdf"));
        myBusinessInfos.add(new MyBusinessInfo("Web Service de seguimiento",
                "https://i.ibb.co/wSjZ2N9/imagenpdf.webp",
                "https://www.aduana.gov.py/uploads/archivos/DNA_WSSV%20v1.5.pdf"));
        myBusinessInfos.add(new MyBusinessInfo("Servicio de AWS",
                "https://i.ibb.co/wSjZ2N9/imagenpdf.webp",
                "https://d1.awsstatic.com/legal/awsserviceterms/AWS_Service_Terms_2021-07-09_Spanish.pdf"));
        return myBusinessInfos;
    }

    @Override
    public void initView() {
        rv = findViewById(R.id.rv);
    }

    @Override
    public void onItemClick(int position) {
        MyBusinessInfo data = downloadListAdapter.getData(position);
        Intent intent = new Intent(this, DescargaDetailActivity.class);
        intent.putExtra(DescargaDetailActivity.DATA, data);
        startActivityForResult(intent, REQUEST_DOWNLOAD_DETAIL_PAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        downloadListAdapter.notifyDataSetChanged();
    }
}
