package com.github.kontvip.lab3.domain.model

import android.os.Bundle
import android.widget.TextView
import androidx.core.os.bundleOf

data class Fact(private val fact: String) {


    fun applyLimitedText(textView: TextView) {
        if (fact.length >= 16) {
            val limitedFact = "${fact.removeRange(16, fact.length)}..."
            textView.text = limitedFact
        }
    }

    fun bundle(): Bundle = bundleOf("fact" to fact)

}