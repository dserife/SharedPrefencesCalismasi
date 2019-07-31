package com.example.sharedprefencescalismasi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etMesaj ;
    Button  btnGonder;

    //tanımlanmış değerleri çağırmak için sp..
    SharedPreferences sp;
    //ekle sil güncelle işlemleri editor ile yapılır
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMesaj=findViewById(R.id.etMesaj);
        btnGonder=findViewById(R.id.btnGonder);

        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sp.edit();

        etMesaj.setText(sp.getString("mesaj",""));

        btnGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //shared pref. içerisine veri kaydedbilmek için, put metotları kullandık.
                editor.putString("mesaj", etMesaj.getText().toString());
                //değişikliği kaydedebilmek için
                editor.commit();

                startActivity(new Intent(getApplicationContext(),SecondActivity.class));
            }
        });


    }
}
