package com.example.courseapp.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.courseapp.R
import com.example.courseapp.presentation.adapter.CoursesAdapter
import com.example.courseapp.presentation.vm.CourseViewModel
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var btnSort: MaterialButton
    private val courseAdapter by lazy {
        CoursesAdapter(
            onFavoriteClick = { }
        )
    }
    private val vm by viewModel<CourseViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view_courses)
        btnSort = view.findViewById(R.id.button_sort)
    }

    override fun onResume() {
        super.onResume()
        btnSort.setOnClickListener {
            vm.sortByPublishDateDesc()
        }
        recyclerView.adapter = courseAdapter
        viewLifecycleOwner.lifecycleScope.launch {
            vm.getCourses()
            vm.courses.collectLatest { list ->
                courseAdapter.submitList(list)
            }
        }
    }

}