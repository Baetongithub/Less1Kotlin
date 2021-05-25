package com.geektech.less1kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geektech.less1kotlin.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var ui: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(ui.root)

        val etValue = intent.getStringExtra(MainActivity.ET_VALUE)
        ui.editTextSendData.setText(etValue)

        ui.buttonSend.setOnClickListener {
            if (ui.editTextSendData.isEmpty()) {
                toast(getString(R.string.field_cant_be_empty))
            } else {
                val data =
                    Intent().putExtra(MainActivity.ET_VALUE, ui.editTextSendData.text.toString().trim())
                setResult(RESULT_OK, data)
                finish()
            }
        }
    }
}