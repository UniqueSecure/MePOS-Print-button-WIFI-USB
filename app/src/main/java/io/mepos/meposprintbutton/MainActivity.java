package io.mepos.meposprintbutton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.uniquesecure.meposconnect.MePOS;
import com.uniquesecure.meposconnect.MePOSConnectionType;
import com.uniquesecure.meposconnect.MePOSReceipt;

import persistence.MePOSSingleton;
import printer.ReceiptBuilder;

public class MainActivity extends MePOSAbstractActivity {
    Button mBtnPrint;
    TextView mipText;
    CheckBox mPrintWifiBox;

//MePOS mePOS = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnPrint = (Button) findViewById(R.id.btnPrint);
        mipText = (TextView) findViewById(R.id.ipText);
        mPrintWifiBox = (CheckBox) findViewById(R.id.printWifiBox);

//  if (mePOS.equals(null)){
//     mePOS = new MePOS(this, MePOSConnectionType.USB);}



        mBtnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MePOSReceipt receipt = new ReceiptBuilder().getShortReceipt();
//mePOS.print(receipt);
                MePOSSingleton.getInstance().print(receipt, MainActivity.this);
                Toast.makeText(MainActivity.this, R.string.printing_message, Toast.LENGTH_SHORT).show();
            }
        });

        mPrintWifiBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPrintWifiBox.isChecked()) {
                    Toast.makeText(MainActivity.this, R.string.wifi, Toast.LENGTH_SHORT).show();
                    String ipValue = mipText.getText().toString();
                    MePOSSingleton.createInstance(getApplicationContext(), MePOSConnectionType.WIFI);
//mePOS.getConnectionManager().setConnectionIPAddress(ipvalue);
                    MePOSSingleton.getInstance().getConnectionManager().setConnectionIPAddress(ipValue);
                } else {
                    MePOSSingleton.createInstance(getApplicationContext(), MePOSConnectionType.USB);
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MePOSSingleton.createInstance(getApplicationContext(), MePOSConnectionType.USB);
    }

    protected void onStop() {
        super.onStop();
    }

}
