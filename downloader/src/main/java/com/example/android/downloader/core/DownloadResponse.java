package com.example.android.downloader.core;

import com.example.android.downloader.domain.DownloadInfo;
import com.example.android.downloader.exception.DownloadException;

/**
 * Created by ixuea(http://a.ixuea.com/3) on 19/9/2021.
 */

public interface DownloadResponse {

    void onStatusChanged(DownloadInfo downloadInfo);

    void handleException(DownloadInfo downloadInfo, DownloadException exception);
}
