package com.metromart.metromart_kitchen_sink.ext

import android.content.Context
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.util.Log
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.content.res.ResourcesCompat
import com.metromart.metromart_kitchen_sink.widget.MetroMartTypefaceSpan
import java.lang.NullPointerException

fun String.spannableString(
    context: Context,
    textSize: Float? = 0f,
    fontFamily: Int,
    @ColorInt fontColor: Int,
    vararg words: String,
    clickable: (String) -> Unit
): SpannableStringBuilder {
    val ssb = SpannableStringBuilder()
    val typeface = ResourcesCompat.getFont(context, fontFamily)

    if (this.isEmpty() || words.isEmpty()) {
        throw NullPointerException(
            if (this.isEmpty())
                "text must no be empty"
            else
                "words must no be empty"
        )
    }

    ssb.append(this)
    for(item in words){
        val findIndex = this.indexOf(item)

        val clickableSpan = object : ClickableSpan(){
            override fun onClick(widget: View) {
                Log.d("makerChecker", "item: $item")
                clickable.invoke(item)
            }

            override fun updateDrawState(ds: TextPaint) {
                ds.isUnderlineText = false
            }
        }

        ssb.setSpan(
            ForegroundColorSpan(fontColor), findIndex,
            findIndex + item.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        typeface?.let {
            ssb.setSpan(
                MetroMartTypefaceSpan(it),
                findIndex,
                findIndex + item.length,
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE
            )
        }

        ssb.setSpan(
            clickableSpan,
            findIndex,
            findIndex + item.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        textSize?.let{
            ssb.setSpan(
                RelativeSizeSpan(it),
                findIndex,
                findIndex + item.length,
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE
            )
        }
    }
    return ssb
}
