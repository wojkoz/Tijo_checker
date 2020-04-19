package com.example.grades

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.grades_list_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel


class GradesList : Fragment() {

    private val viewModel: GradesListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.grades_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.data.observe(viewLifecycleOwner, Observer {
            Log.d("GradesListFragment", it[0].index)
        })


        button.setOnClickListener {
            val indexId = 0
            it.findNavController().navigate(GradesListDirections.actionGradesListToGradeDetails(indexId))
        }

    }


}
