package com.geektech.less1kotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.geektech.less1kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var ui: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val data: Intent? = result.data
                    val etValue = data?.getStringExtra(ET_VALUE)
                    ui.editTextSendData.setText(etValue)
                }
            }

        ui.buttonSend.setOnClickListener {
            if (isEditTextEmpty(ui.editTextSendData)) {
                toast(getString(R.string.field_cant_be_empty))
            } else {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra(ET_VALUE, ui.editTextSendData.text.toString().trim())
                resultLauncher.launch(intent)
            }
        }
    }

    companion object {
        const val ET_VALUE = "et_value"
    }
}