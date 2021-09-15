package com.metromart.metromart_kitchen_sink.widget

import android.graphics.Paint
import android.graphics.Typeface
import android.text.TextPaint
import android.text.style.MetricAffectingSpan

class MetroMartTypefaceSpan(private val typeface: Typeface) : MetricAffectingSpan() {

    override fun updateDrawState(tp: TextPaint) {
        applyCustomTypeFace(tp, typeface)
    }

    override fun updateMeasureState(textPaint: TextPaint) {
        applyCustomTypeFace(textPaint, typeface)
    }

    private fun applyCustomTypeFace(paint: Paint, tf: Typeface){
        paint.typeface = tf
    }
}