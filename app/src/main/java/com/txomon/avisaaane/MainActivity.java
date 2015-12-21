package com.txomon.avisaaane;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.parse.ParsePush;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnCheckedChanged(R.id.subscription_button)
    public void subscribe(CompoundButton view, boolean isChecked) {
        if (isChecked) {
            ParsePush.subscribeInBackground("Ane");
            Toast.makeText(getApplicationContext(), "Suscrita a las notificaciones", Toast.LENGTH_SHORT).show();
        } else {
            ParsePush.unsubscribeInBackground("Ane");
            Toast.makeText(getApplicationContext(), "Cancelar suscripcion", Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick(R.id.btn_notify)
    public void btn_notify(View view) {
        notify_parse();
        Toast.makeText(getApplicationContext(), "Notificatión enviada", Toast.LENGTH_SHORT).show();
    }

    static void notify_parse() {
        ParsePush push = new ParsePush();
        push.setChannel("Ane");
        push.setMessage("TE ESTOY LLAMANDO ANE.");
        push.sendInBackground();
    }
}
