package com.example.gonzalomonzon.mvvmlogin.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.gonzalomonzon.mvvmlogin.model.Login;

public class LoginModel extends ViewModel
{

    MutableLiveData<Login> login=new MutableLiveData<>();

   public MutableLiveData<Login> getLogin(){
       return login;
   }

   public void setLogin(String username, String password) {
       Login newLogin = new Login(username, password);
       login.setValue(newLogin);
   }
}
