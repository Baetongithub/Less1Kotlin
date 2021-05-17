package com.geektech.less1kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.less1kotlin.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var ui: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(ui.root)

        val etValue = intent.getStringExtra(MainActivity.ET_VALUE)
        ui.textViewActivity2.text = etValue
    }
}