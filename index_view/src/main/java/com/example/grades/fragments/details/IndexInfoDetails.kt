package com.example.grades.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.dto.IndexDetailsDto
import com.example.core.resource.Status
import com.example.grades.R
import com.example.grades.groupie.ErrorMessageHeader
import com.example.grades.groupie.HeaderExpandable
import com.example.grades.groupie.IndexInfoDetailItem
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import kotlinx.android.synthetic.main.index_info_details_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class IndexInfoDetails : Fragment() {

    private var index: Int? = null
    private val viewModel : IndexInfoDetailsViewModel by viewModel{ parametersOf(index) }
    private val groupieAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.index_info_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        index = arguments?.get("indexId") as Int?

        recyclerViewDetail.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL ,false)
            adapter = groupieAdapter
        }


        viewModel.data.observe(viewLifecycleOwner, Observer {
            groupieAdapter.clear()
            when(it.status){
                Status.SUCCESS -> showItems(it.data!!)
                Status.ERROR -> {showMessage(it.message!!, it.data!!.labs.isNullOrEmpty())
                                showItems(it.data!!)}
                else -> showMessage(getString(R.string.loading_string), true)
            }

        })


    }

    private fun showItems(indexDetails: IndexDetailsDto) {
        index_detail_tv.text = indexDetails.index
        group_detail_tv.text = indexDetails.group


        indexDetails.labs.forEach {
            ExpandableGroup(HeaderExpandable(it.labName), false).apply {
                add(Section(IndexInfoDetailItem(it)))
                groupieAdapter.add(this)
            }
        }
    }

    private fun showMessage(message: String, showLayout: Boolean) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        if(showLayout){
            groupieAdapter.add(Section(ErrorMessageHeader(message)))
        }
    }

}
