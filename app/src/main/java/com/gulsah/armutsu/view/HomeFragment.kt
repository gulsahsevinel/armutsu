package com.gulsah.armutsu.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.gulsah.armutsu.R
import com.gulsah.armutsu.adapter.PopularAdapter
import com.gulsah.armutsu.adapter.ServicesAdapter
import com.gulsah.armutsu.databinding.FragmentHomeBinding
import com.gulsah.armutsu.viewmodel.HomeViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var servicesAdapter: ServicesAdapter
    private lateinit var popularAdapter : PopularAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.homeFragment = this
        binding.rvAllServices.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        binding.rvPopular.layoutManager =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)

        viewModel.servicesList.observe(viewLifecycleOwner)
        {
            servicesAdapter = ServicesAdapter(it, requireContext())
            binding.servicesAdapter = servicesAdapter
        }
        viewModel.popularlist.observe(viewLifecycleOwner){
            popularAdapter = PopularAdapter(it,requireContext())
            binding.popularAdapter = popularAdapter
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp: HomeViewModel by viewModels()
        viewModel = temp
    }

}