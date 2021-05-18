package com.geektech.less1kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
            if (ui.editTextSendData.text.toString().trim().isEmpty()) {
                Toast.makeText(this, "Field can not be empty", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(MainActivity.ET_VALUE, ui.editTextSendData.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}