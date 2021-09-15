package com.metromart.metromart_kitchen_sink.sample

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.metromart.metromart_kitchen_sink.Constant.PRIVACY_POLICY
import com.metromart.metromart_kitchen_sink.Constant.TERMS_AND_CONDITION
import com.metromart.metromart_kitchen_sink.R
import com.metromart.metromart_kitchen_sink.databinding.ActivityStringExampleBinding
import com.metromart.metromart_kitchen_sink.ext.spannableString

class StringExampleActivity : AppCompatActivity() {

    companion object{
        fun getIntent(context: Context): Intent {
            return Intent(context, StringExampleActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityStringExampleBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_string_example)

        binding.tvUnderLineText.text = getString(R.string.sample_text_spanned)
            .spannableString(
                this,
                null,
                R.font.lato_regular,
                Color.parseColor("#FC7900"),
                "Terms and Condition",
                "Privacy Policy",
                clickable = { spanClick ->
                    Log.d("makerChecker", "spanClick: $spanClick")
                    when(spanClick){
                        TERMS_AND_CONDITION -> {
                            Toast.makeText(this, TERMS_AND_CONDITION, Toast.LENGTH_LONG).show()
                        }
                        PRIVACY_POLICY -> {
                            Toast.makeText(this, PRIVACY_POLICY, Toast.LENGTH_LONG).show()
                        }
                    }
                }
            )
    }
}