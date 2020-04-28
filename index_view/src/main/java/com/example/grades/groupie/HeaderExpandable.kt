package com.example.grades.groupie

import android.content.Context
import android.view.animation.AnimationUtils
import com.example.grades.R
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.header_expandable.view.*

class HeaderExpandable(private val context: Context, private val header: String) : Item(), ExpandableItem{

    private lateinit var expandableGroup: ExpandableGroup

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.apply {
            itemView.headter_tv.animation = AnimationUtils.loadAnimation(context, R.anim.left_to_right)
            itemView.headter_tv.text = header
            itemView.headter_tv.setOnClickListener {
                expandableGroup.onToggleExpanded()

            }
        }

    }

    override fun getLayout(): Int{
        return R.layout.header_expandable
    }

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        expandableGroup = onToggleListener
    }
}