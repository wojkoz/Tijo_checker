package com.example.grades.groupie

import androidx.navigation.findNavController
import com.example.core.entity.Index
import com.example.grades.R
import com.example.grades.fragments.IndexInfoListDirections
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.index_info_item.view.*


class IndexInfoItem(private val indexItem: Index) : Item() {

    override fun getLayout(): Int = R.layout.index_info_item

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.apply {
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