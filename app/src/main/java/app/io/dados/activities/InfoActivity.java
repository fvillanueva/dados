package app.io.dados.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

import org.w3c.dom.Text;

import app.io.dados.R;
import app.io.dados.utilities.Util;

public class InfoActivity extends AppCompatActivity {

    TelephonyManager telephonyManager;


    TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        telephonyManager= (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String dataInfo="DeviceID"+telephonyManager.getDeviceId()+"\n"+
                "Line1Number: "+telephonyManager.getLine1Number()+"\n"+
                "Sim Operator: "+telephonyManager.getSimOperatorName()+"\n"+
                "PhoneType: "+telephonyManager.getPhoneType()+"\n"+
                "NetworkOperator: "+telephonyManager.getNetworkOperatorName()+"\n"+
                "DateTime: "+Util.getDateTimeLocale();
        view=(TextView)findViewById(R.id.textInfo);
        view.setText(dataInfo);
    }
}
