package com.metromart.metromart_kitchen_sink.widget

import android.content.Context
import android.util.AttributeSet
import com.metromart.metromart_kitchen_sink.R
import com.google.android.material.textfield.TextInputLayout

class MetroMartMaterialInputTextLayout  : TextInputLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(context, attributeSet, defStyle)

    override fun setErrorEnabled(enabled: Boolean) {
        editText?.let { et ->
            val startPadding = et.paddingLeft
            et.setBackgroundResource(if (enabled) R.drawable.edittext_form_transparent_with_border_error else R.drawable.edittext_form_background_selector)
            et.setPadding(
                0,
                et.paddingTop,
                et.paddingRight,
                et.paddingBottom
            )

            et.setPadding(
                startPadding,
                et.paddingTop,
                et.paddingRight,
                et.paddingBottom
            )
        }
        super.setErrorEnabled(enabled)
    }
}