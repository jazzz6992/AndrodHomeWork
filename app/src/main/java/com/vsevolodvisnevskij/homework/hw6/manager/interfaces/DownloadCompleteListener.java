package com.vsevolodvisnevskij.homework.hw6.manager.interfaces;

import java.io.File;


public interface DownloadCompleteListener {
    void onDownloadSuccess(File file);

    void onDownloadFailed(String message);
}
