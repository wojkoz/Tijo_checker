package com.example.grades.groupie

import com.example.grades.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.error_message_header.view.*

class ErrorMessageHeader(private val error: String) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.error_tv.text = error
    }

    override fun getLayout(): Int = R.layout.error_message_header
}