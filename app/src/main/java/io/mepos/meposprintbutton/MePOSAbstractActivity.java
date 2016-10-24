package io.mepos.meposprintbutton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import com.uniquesecure.meposconnect.MePOSConnectionType;
import com.uniquesecure.meposconnect.MePOSException;
import com.uniquesecure.meposconnect.MePOSPrinterCallback;


import persistence.MePOSSingleton;

public abstract class MePOSAbstractActivity extends AppCompatActivity implements MePOSPrinterCallback{

    private static final String TAG = MePOSAbstractActivity.class.getSimpleName();

    protected BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (UsbManager.ACTION_USB_DEVICE_ATTACHED.equals(action)) {
                MePOSSingleton.createInstance(getApplicationContext(), MePOSConnectionType.USB);
                Toast.makeText(context, "MePOS  connected", Toast.LENGTH_SHORT).show();
            } else if (UsbManager.ACTION_USB_DEVICE_DETACHED.equals(action)) {
                try {
                    Toast.makeText(context, "MePOS disconnected", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.e("USB", e.getMessage());
                }
            } else {
                Toast.makeText(context, "MePOS disconnected", Toast.LENGTH_SHORT).show();
                getApplicationContext().unregisterReceiver(mReceiver);

            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        registerReceiver(this.mReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            unregisterReceiver(mReceiver);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onPrinterStarted(MePOSConnectionType mePOSConnectionType, String s) {
        Snackbar.make(findViewById(android.R.id.content), R.string.print_started, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onPrinterCompleted(MePOSConnectionType mePOSConnectionType, String s) {
        Snackbar.make(findViewById(android.R.id.content), R.string.print_completed, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onPrinterError(MePOSException e) {
        Snackbar.make(findViewById(android.R.id.content), R.string.print_error, Snackbar.LENGTH_SHORT).show();
    }

}
