package com.example.grades.groupie

import android.content.Context
import android.view.animation.AnimationUtils
import com.example.core.dto.LabDto
import com.example.grades.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.index_info_detail_item.view.*

class IndexInfoDetailItem(private val context: Context, private val itemLab: LabDto) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.apply {
            itemView.presence_chb.animation = AnimationUtils.loadAnimation(context, R.anim.right_to_left)
            itemView.date_of_lab_tv.animation = AnimationUtils.loadAnimation(context, R.anim.right_to_left)
            itemView.points_detail_tv.animation = AnimationUtils.loadAnimation(context, R.anim.right_to_left)


            itemView.presence_chb.isChecked = itemLab.presence
            itemView.date_of_lab_tv.text = itemLab.dateOfLab
            itemView.points_detail_tv.text = itemLab.points.toString()
        }
    }

    override fun getLayout(): Int = R.layout.index_info_detail_item
}