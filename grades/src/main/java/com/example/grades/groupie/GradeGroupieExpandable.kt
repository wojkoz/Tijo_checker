package com.example.grades.groupie

import com.example.grades.R
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.grade_groupie_expandable.view.*

class GradeGroupieExpandable(private val index: String) : Item(), ExpandableItem{

    private lateinit var expandableGroup: ExpandableGroup

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.apply {
            itemView.index_tv.text = index
            itemView.index_tv.setOnClickListener {
                expandableGroup.onToggleExpanded()

            }
        }

    }

    override fun getLayout(): Int{
        return R.layout.grade_groupie_expandable
    }

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        expandableGroup = onToggleListener
    }
}