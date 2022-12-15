package com.seisekulov.rickandmorty.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.seisekulov.rickandmorty.databinding.FragmentEpisodesBinding

class EpisodesFragment : Fragment() {

    companion object {
        fun newInstance() = EpisodesFragment()
    }

    private lateinit var viewModel: EpisodesViewModel
    lateinit var binding: FragmentEpisodesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEpisodesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EpisodesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}