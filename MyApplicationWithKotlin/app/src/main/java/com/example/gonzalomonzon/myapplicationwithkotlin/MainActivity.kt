package com.example.gonzalomonzon.myapplicationwithkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        varDefinitionString()


    }
    fun varDefinitionString(){

        var vari:String?=null //definicion de una  variable sin asignar

        var vari1="asdasdds" //definicion y asignacion de una variable

        toast("$vari asdasadsaasdads $vari1")

        toast(vari+" "+vari1)

        vari="asdaddasd"
        longToast(vari)

        val url="hjs.com"
        toast(url)
    }
}
