package com.besga.jonander.avisaaane;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParsePush;


public class MainActivity extends AppCompatActivity {

    private Button btnYes;
    private Button btn_disable;
    private Button btn_notify;
    private TextView tv_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnYes = (Button) this.findViewById(R.id.btn_yes);

        btn_disable = (Button) this.findViewById(R.id.btn_disable);
        btn_notify = (Button) this.findViewById(R.id.btn_notify);
        tv_status = (TextView) this.findViewById(R.id.tv_status);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParsePush.subscribeInBackground("Ane");

                tv_status.setText("Suscrita a las notificaciones");
            }
        });

        btn_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParsePush push = new ParsePush();
                push.setChannel("Ane");
                push.setMessage("TE ESTOY LLAMANDO ANE.");
                push.sendInBackground();

                tv_status.setText("Notificacion enviada");
            }
        });

        btn_disable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParsePush.unsubscribeInBackground("Ane");

                tv_status.setText("Cancelar suscripcion");
            }
        });


    }
}
