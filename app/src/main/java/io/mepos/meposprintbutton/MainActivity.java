package io.mepos.meposprintbutton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.uniquesecure.meposconnect.MePOSConnectionType;

import persistence.MePOSSingleton;
import printer.ReceiptBuilder;

public class MainActivity extends MePOSAbstractActivity {
    Button mBtnPrint;
    TextView mipText;
    CheckBox mprintWifiBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnPrint = (Button) findViewById(R.id.btnprint);
        mipText = (TextView) findViewById(R.id.ipText);
        mprintWifiBox = (CheckBox) findViewById(R.id.printWifiBox);

        mBtnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MePOSSingleton.getInstance().print(new ReceiptBuilder().getShortReceipt());
                Toast.makeText(MainActivity.this, "A printer job has sent to the queue", Toast.LENGTH_SHORT).show();
            }
        });

        mprintWifiBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mprintWifiBox.isChecked()) {
                    Toast.makeText(MainActivity.this, "Wifi selected", Toast.LENGTH_SHORT).show();
                    String ipValue = mipText.getText().toString();
                    MePOSSingleton.createInstance(getApplicationContext(), MePOSConnectionType.WIFI);
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
