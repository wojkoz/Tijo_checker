package com.example.grades.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.entity.Index

import com.example.grades.R
import com.example.grades.groupie.GradeGroupieExpandable
import com.example.grades.groupie.GradeGroupieItem
import com.xwray.groupie.*
import kotlinx.android.synthetic.main.grade_groupie_item.view.*
import kotlinx.android.synthetic.main.grades_list_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel


class GradesList : Fragment() {

    private val viewModel: GradesListViewModel by viewModel()
    private val groupieAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.grades_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        recyclerView.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL ,false)
            adapter = groupieAdapter
        }

        viewModel.data.observe(viewLifecycleOwner, Observer { list ->
            groupieAdapter.clear()

           list.forEach {
               ExpandableGroup(GradeGroupieExpandable(it.index), false).apply {
                   add(Section(GradeGroupieItem(it)))
                   groupieAdapter.add(this)
               }
           }
        })

    }


}
