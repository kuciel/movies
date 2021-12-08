package com.andysworkshop.movies.popularmoviesscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.andysworkshop.movies.databinding.FragmentPopularMoviesBinding
import com.andysworkshop.movies.popularmoviesscreen.data.PopularMoviesUIData
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PopularMoviesFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var _binding: FragmentPopularMoviesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: PopularMoviesViewModel by viewModels { viewModelFactory }

    private val moviesListData: MutableList<PopularMoviesUIData> = mutableListOf()
    private val moviesViewAdapter = MoviesRecyclerAdapter(moviesListData)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPopularMoviesBinding.inflate(inflater, container, false)
        val view = binding.root
        view.layoutManager = LinearLayoutManager(context)
        view.adapter = moviesViewAdapter
        return view
    }

    override fun onResume() {
        super.onResume()
        observeViewModelMoviesData()
        viewModel.fragmentResumed()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeViewModelMoviesData() {
        viewModel.moviesSharedFlow.onEach {
            moviesListData.clear()
            moviesListData.addAll(it)
            moviesViewAdapter.notifyDataSetChanged()
        }
            .launchIn(lifecycleScope)

    }
}