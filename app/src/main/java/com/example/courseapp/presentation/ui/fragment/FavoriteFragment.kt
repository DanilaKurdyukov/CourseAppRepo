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
import com.example.courseapp.presentation.vm.FavoriteCourseViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.getValue

class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    private val vm by viewModel<FavoriteCourseViewModel>()
    private lateinit var recyclerView: RecyclerView
    private val courseAdapter by lazy {
        CoursesAdapter(
            onFavoriteClick = { }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view_favoriteCourses)
    }

    override fun onResume() {
        super.onResume()
        recyclerView.adapter = courseAdapter
        vm.getCourses()
        lifecycleScope.launch {
            vm.courses.collectLatest { list ->
                courseAdapter.submitList(list)
            }
        }
    }

}