package com.geektech.less1kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.geektech.less1kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var ui: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        val etValue2 = intent.getStringExtra(ET_VALUE)
        ui.editTextSendData.setText(etValue2)

        ui.buttonSend.setOnClickListener {
            if (ui.editTextSendData.text.toString().trim().isEmpty()) {
                Toast.makeText(this, "Field can not be empty", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra(ET_VALUE, ui.editTextSendData.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }

    companion object {
        const val ET_VALUE = "et_value"
    }
}