package com.vsevolodvisnevskij.homework.hw6.manager.download;


import com.vsevolodvisnevskij.homework.hw6.model.Model;
import com.vsevolodvisnevskij.homework.hw6.manager.interfaces.DownloadCompleteListener;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader implements Runnable {
    private String urlLink;
    private String path;
    private DownloadCompleteListener listener;
    private final Model monitor;


    public Downloader(String urlLink, String path, DownloadCompleteListener listener, Model monitor) {
        this.urlLink = urlLink;
        this.path = path;
        this.listener = listener;
        this.monitor = monitor;
    }


    private void downloadFile() {
        File file = createFile(path);
        if (file != null) {
            try {
                HttpURLConnection connection = createConnection(urlLink);
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    try {
                        download(connection, file);
                        listener.onDownloadSuccess(file);
                    } catch (IOException e) {
                        listener.onDownloadFailed(e.getMessage());
                    }
                } else {
                    listener.onDownloadFailed("Response code is " + connection.getResponseCode());
                }
            } catch (IOException e) {
                listener.onDownloadFailed("Address " + e.getMessage() + " doesn't response. Check your connection");
            }
        } else {
            listener.onDownloadFailed("Can't create file");
        }
    }


    private File createFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    return null;
                }
            } catch (IOException e) {
                listener.onDownloadFailed(e.getMessage());
                return null;
            }
        }
        return file;
    }

    private HttpURLConnection createConnection(String link) throws IOException {
        URL url = new URL(link);
        return (HttpURLConnection) url.openConnection();
    }


    private void download(HttpURLConnection connection, File file) throws IOException {
        try (InputStream is = connection.getInputStream()) {
            try (OutputStream os = new FileOutputStream(file)) {
                byte[] buf = new byte[4096];
                int bufSize;
                while ((bufSize = is.read(buf)) != -1) {
                    os.write(buf, 0, bufSize);
                }
            }
        }
    }

    @Override
    public void run() {
        synchronized (monitor) {
            downloadFile();
        }
    }
}
