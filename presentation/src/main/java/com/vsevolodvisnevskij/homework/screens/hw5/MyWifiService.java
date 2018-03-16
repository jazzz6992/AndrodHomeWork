package com.vsevolodvisnevskij.homework.screens.hw5;

import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;

public class MyWifiService extends Service {
    private MyBinder binder;
    private WifiManager manager;

    public MyWifiService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
    }

    public void changeWiFiState() {
        manager.setWifiEnabled(!manager.isWifiEnabled());
    }

    @Override
    public IBinder onBind(Intent intent) {
        binder = new MyBinder();
        return binder;
    }

    public class MyBinder extends Binder {
        public MyWifiService getService() {
            return MyWifiService.this;
        }
    }
}
