package com.example.android.downloader.db;

import com.example.android.downloader.domain.DownloadInfo;
import com.example.android.downloader.domain.DownloadThreadInfo;

import java.util.List;

/**
 * Created by ixuea(http://a.ixuea.com/3) on 19/9/2021.
 */

public interface DownloadDBController {

    List<DownloadInfo> findAllDownloading();

    List<DownloadInfo> findAllDownloaded();

    DownloadInfo findDownloadedInfoById(String id);

    void pauseAllDownloading();

    void createOrUpdate(DownloadInfo downloadInfo);

    void createOrUpdate(DownloadThreadInfo downloadThreadInfo);

    void delete(DownloadInfo downloadInfo);

    void delete(DownloadThreadInfo download);
}
