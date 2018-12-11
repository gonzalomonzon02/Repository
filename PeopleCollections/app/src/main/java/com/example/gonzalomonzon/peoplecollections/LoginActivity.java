package com.example.gonzalomonzon.peoplecollections;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gonzalomonzon.peoplecollections.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding mbilding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mbilding= DataBindingUtil.setContentView(this, R.layout.activity_login);

        Context context = getApplicationContext();
        final SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        if (sharedPref.contains("key_user_name")) {
            Intent intent = new Intent(this, MainActivity.class);
            Toast.makeText(getApplicationContext(),"Usuario: "+sharedPref.getString("key_user_name","")+
                    " Contraseña: "+ sharedPref.getString("key_user_key",""),Toast.LENGTH_SHORT).show();
            startActivity(intent);
        } else {
            mbilding.loginActivityBtnok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        SharedPreferences.Editor editor=sharedPref.edit();
                        editor.putString("key_user_name",mbilding.loginActivityTvEmail.getText().toString());
                        editor.putString("key_user_key",mbilding.loginActivityTvPassword.getText().toString());
                        editor.commit();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                }
            });
        }
    }
}
