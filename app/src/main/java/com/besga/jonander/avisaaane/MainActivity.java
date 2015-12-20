package com.besga.jonander.avisaaane;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParsePush;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv_status)
    TextView tv_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_yes)
    public void subscribe(View view) {
        ParsePush.subscribeInBackground("Ane");
        tv_status.setText("Suscrita a las notificaciones");
    }

    @OnClick(R.id.btn_disable)
    public void notify(View view) {
        ParsePush.unsubscribeInBackground("Ane");
        tv_status.setText("Cancelar suscripcion");

    }

    @OnClick(R.id.btn_notify)
    public void unsubscribe(View view) {
        ParsePush push = new ParsePush();
        push.setChannel("Ane");
        push.setMessage("TE ESTOY LLAMANDO ANE.");
        push.sendInBackground();
        tv_status.setText("Notificacion enviada");
    }
}
