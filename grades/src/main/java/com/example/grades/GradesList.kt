package com.example.grades

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.grades_list_fragment.*


class GradesList : Fragment() {

    private lateinit var viewModel: GradesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.grades_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GradesListViewModel::class.java)
        // TODO: Use the ViewModel
        button.setOnClickListener {
            val indexId = 0;
            it.findNavController().navigate(GradesListDirections.actionGradesListToGradeDetails(indexId))
        }

    }


}
