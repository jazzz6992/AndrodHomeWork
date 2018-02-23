package com.vsevolodvisnevskij.homework.hw5;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.vsevolodvisnevskij.homework.R;

public class WiFiActivity extends AppCompatActivity {
    private WifiManager manager;
    private ImageView imageView;
    private Button changeWifiStateButton;
    private ServiceConnection connection;
    private boolean bound = false;
    private MyWifiService.MyBinder binder;
    private MyWifiService service;
    BroadcastReceiver receiver;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bound) {
            unbindService(connection);
        }
        bound = false;
        unregisterReceiver(receiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fi);
        imageView = findViewById(R.id.wifi_state_imageView);
        manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                checkWiFi();
            }
        };
        registerReceiver(receiver, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
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
        bindService(new Intent(this, MyWifiService.class), connection, BIND_AUTO_CREATE);
        changeWifiStateButton = findViewById(R.id.change_wifi_state_button);
        changeWifiStateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bound) {
                    binder.getService().changeWiFiState();
                }
            }
        });
        checkWiFi();
    }

    public void checkWiFi() {
        if (manager.isWifiEnabled()) {
            imageView.setImageResource(R.drawable.ic_wifi_on);
            changeWifiStateButton.setText(R.string.turn_wifi_off);
        } else {
            imageView.setImageResource(R.drawable.ic_wifi_off);
            changeWifiStateButton.setText(R.string.turn_wifi_on);
        }
    }
}
