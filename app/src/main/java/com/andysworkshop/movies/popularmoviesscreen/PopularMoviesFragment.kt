package com.andysworkshop.movies.popularmoviesscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.andysworkshop.movies.R
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
    private val moviesViewAdapter = MoviesRecyclerAdapter(moviesListData) {
        viewModel.onPosterClicked(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)

        viewModel.fragmentCreate()
        observeViewModelMoviesData()
        observeNavigationEvent()
        observeViewModelMoviesRequestError()
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
            println("Fragment successfully got movies data: ")
            moviesViewAdapter.notifyDataSetChanged()
        }.launchIn(lifecycleScope)

    }

    private fun observeViewModelMoviesRequestError() {
        viewModel.moviesRequestError.onEach {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }.launchIn(lifecycleScope)
    }

    private fun observeNavigationEvent() {
        viewModel.navigateMovieDetails.onEach { movieData ->
            movieData.let{
                val action = PopularMoviesFragmentDirections
                    .actionPopularMoviesFragmentToMovieDetailFragment(it.id, it.posterPath)
                findNavController().navigate(action)
            }
        }.launchIn(lifecycleScope)
    }
}
