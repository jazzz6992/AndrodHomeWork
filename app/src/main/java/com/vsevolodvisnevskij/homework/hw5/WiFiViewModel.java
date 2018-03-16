package com.vsevolodvisnevskij.homework.hw5;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.databinding.Bindable;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;

import com.vsevolodvisnevskij.homework.BR;
import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;
import com.vsevolodvisnevskij.homework.databinding.ActivityWiFiBinding;

/**
 * Created by vsevolodvisnevskij on 15.03.2018.
 */

public class WiFiViewModel extends BaseViewModel {
    private AppCompatActivity activity;
    private WifiManager manager;
    private BroadcastReceiver receiver;
    private ServiceConnection connection;
    private MyWifiService.MyBinder binder;
    private boolean bound = false;

    private int imgResId;
    private int buttonTextResId;


    private ActivityWiFiBinding binding;

    public WiFiViewModel(AppCompatActivity activity, ActivityWiFiBinding binding) {
        this.activity = activity;
        this.binding = binding;
    }

    @Bindable
    public int getImgResId() {
        return imgResId;
    }

    @Bindable
    public int getButtonTextResId() {
        return buttonTextResId;
    }

    @Override
    public void onStart() {
        manager = (WifiManager) activity.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                checkWiFi();
            }
        };
        activity.registerReceiver(receiver, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binder = (MyWifiService.MyBinder) service;
                bound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                bound = false;
            }
        };
        activity.bindService(new Intent(activity, MyWifiService.class), connection, Context.BIND_AUTO_CREATE);
        checkWiFi();
    }

    @Override
    public void onStop() {
        if (bound) {
            activity.unbindService(connection);
        }
        bound = false;
        activity.unregisterReceiver(receiver);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    public void changeWiFiState() {
        if (bound) {
            binder.getService().changeWiFiState();
        }
    }

    public void checkWiFi() {
        if (manager.isWifiEnabled()) {
            imgResId = R.drawable.ic_wifi_on;
            buttonTextResId = R.string.turn_wifi_off;
        } else {
            imgResId = R.drawable.ic_wifi_off;
            buttonTextResId = R.string.turn_wifi_on;
        }
        binding.wifiStateImageView.setImageResource(imgResId);
        //        notifyPropertyChanged(BR.imgResId);
        notifyPropertyChanged(BR.buttonTextResId);
    }
}