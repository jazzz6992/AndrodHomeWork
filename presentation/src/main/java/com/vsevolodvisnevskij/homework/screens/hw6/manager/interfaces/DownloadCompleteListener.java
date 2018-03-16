package com.vsevolodvisnevskij.homework.screens.hw6.manager.interfaces;

import java.io.File;


public interface DownloadCompleteListener {
    void onDownloadSuccess(File file);

    void onDownloadFailed(String message);
}
