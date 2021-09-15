package com.metromart.metromart_kitchen_sink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.metromart.metromart_kitchen_sink.databinding.ActivityMainBinding
import com.metromart.metromart_kitchen_sink.sample.InputTextExampleActivity
import com.metromart.metromart_kitchen_sink.sample.StringExampleActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        binding.btnStringWidget.setOnClickListener {
            startActivity(
                StringExampleActivity.getIntent(this)
            )
        }

        binding.btnInputText.setOnClickListener {
            startActivity(
                InputTextExampleActivity.getIntent(this)
            )
        }
    }
}