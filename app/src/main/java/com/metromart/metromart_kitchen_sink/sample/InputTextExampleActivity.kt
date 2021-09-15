package com.metromart.metromart_kitchen_sink.sample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.metromart.metromart_kitchen_sink.R

class InputTextExampleActivity : AppCompatActivity() {

    companion object{
        fun getIntent(context: Context): Intent {
            return Intent(context, InputTextExampleActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_fields)
    }
}