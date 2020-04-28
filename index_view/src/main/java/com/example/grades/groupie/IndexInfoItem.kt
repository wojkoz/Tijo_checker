package com.example.grades.groupie

import android.content.Context
import android.view.animation.AnimationUtils
import androidx.navigation.findNavController
import com.example.core.dto.IndexDto
import com.example.grades.R
import com.example.grades.fragments.IndexInfoListDirections
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.index_info_item.view.*


class IndexInfoItem(private val context: Context, private val indexItem: IndexDto) : Item() {

    override fun getLayout(): Int = R.layout.index_info_item

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.apply {

            itemView.mark_tv.animation = AnimationUtils.loadAnimation(context, R.anim.right_to_left)
            itemView.group_tv.animation = AnimationUtils.loadAnimation(context, R.anim.right_to_left)
            itemView.lecture_points_tv.animation = AnimationUtils.loadAnimation(context, R.anim.right_to_left)
            itemView.homework_points_tv.animation = AnimationUtils.loadAnimation(context, R.anim.right_to_left)
            itemView.presence_counter_tv.animation = AnimationUtils.loadAnimation(context, R.anim.right_to_left)
            itemView.absence_counter_tv.animation = AnimationUtils.loadAnimation(context, R.anim.right_to_left)
            itemView.all_points_tv.animation = AnimationUtils.loadAnimation(context, R.anim.right_to_left)

            itemView.mark_tv.text = indexItem.allPoints.toString()
            itemView.group_tv.text = indexItem.group
            itemView.lecture_points_tv.text = indexItem.lecturePoints.toString()
            itemView.homework_points_tv.text = indexItem.homeworkPoints.toString()
            itemView.presence_counter_tv.text = indexItem.presenceCounter.toString()
            itemView.absence_counter_tv.text = indexItem.absenceCounter.toString()
            itemView.all_points_tv.text = indexItem.allPoints.toString()

            itemView.details_tv.setOnClickListener{
                val action = IndexInfoListDirections.actionGradesListToGradeDetails(Integer.parseInt(indexItem.index))
                it.findNavController().navigate(action)
            }
        }
    }

}