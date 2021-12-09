package com.andysworkshop.movies.moviedetailsscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.andysworkshop.movies.databinding.FragmentMovieDetailsBinding
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MovieDetailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MovieDetailViewModel by viewModels { viewModelFactory }

    private var _binding: FragmentMovieDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onResume() {
        super.onResume()

        observeDetailData()
        observeRequestError()

        arguments?.let {
            viewModel.onFragmentResumed(
                MovieDetailFragmentArgs.fromBundle(it).movieId
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeDetailData() {
        viewModel.movieDetailSharedFlow.onEach {
            println("Movie detail fragment got detail data: $it")
            binding.titleTextview.text = it.title
            binding.overviewTextview.text = it.overview
        }.launchIn(lifecycleScope)
    }

    private fun observeRequestError() {
        viewModel.detailsRequestError.onEach {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }.launchIn(lifecycleScope)
    }
}