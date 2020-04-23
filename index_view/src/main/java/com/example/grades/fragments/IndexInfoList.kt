package com.example.grades.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.dto.IndexDto
import com.example.core.resource.Status
import com.example.grades.R
import com.example.grades.groupie.ErrorMessageHeader
import com.example.grades.groupie.HeaderExpandable
import com.example.grades.groupie.IndexInfoItem
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import kotlinx.android.synthetic.main.index_info_list_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel


class IndexInfoList : Fragment() {

    private val viewModel: IndexInfoListViewModel by viewModel()
    private val groupieAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.index_info_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        recyclerView.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL ,false)
            adapter = groupieAdapter
        }

        viewModel.data.observe(viewLifecycleOwner, Observer {
            groupieAdapter.clear()

            when(it.status){
                Status.SUCCESS -> showItems(it.data!!)
                Status.ERROR -> {showMessage(it.message!!, it.data.isNullOrEmpty())
                                showItems(it.data!!)}
                else -> showMessage(getString(R.string.loading_string), true)
            }

        })

    }

    private fun showItems(list: List<IndexDto>) {
        list.forEach {
            ExpandableGroup(HeaderExpandable(it.index), false).apply {
                add(Section(IndexInfoItem(it)))
                groupieAdapter.add(this)
            }
        }
    }

    private fun showMessage(message: String, showLayout: Boolean) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        if(showLayout){
            groupieAdapter.add(Section(ErrorMessageHeader(message)))
        }

    }


}
