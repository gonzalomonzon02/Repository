package com.example.gonzalomonzon.mvvmlogin;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.gonzalomonzon.mvvmlogin.databinding.ActivityLoginBinding;
import com.example.gonzalomonzon.mvvmlogin.model.Login;
import com.example.gonzalomonzon.mvvmlogin.viewmodel.LoginModel;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityLoginBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        final LoginModel loginModel = ViewModelProviders.of(this).get(LoginModel.class);
        loginModel.getLogin().observe(this, new Observer<Login>() {
            @Override
            public void onChanged(@Nullable Login login) {
                Toast.makeText(getApplicationContext(), "User: " + login.getUser() + " Password: " + login.getPassword(), Toast.LENGTH_SHORT).show();
            }
        });

        mBinding.btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginModel.setLogin(mBinding.tvPassword.getText().toString(), mBinding.tvUser.getText().toString());
            }
        });

    }
}
