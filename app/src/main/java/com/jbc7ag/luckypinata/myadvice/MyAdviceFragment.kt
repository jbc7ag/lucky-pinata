package com.jbc7ag.luckypinata.myadvice


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.jbc7ag.luckypinata.databinding.FragmentMyAdviceBinding

class MyAdviceFragment: Fragment(){

    private lateinit var viewModel: MyAdviceViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val binding = FragmentMyAdviceBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(MyAdviceViewModel::class.java)
        binding.myAdviceViewModel = viewModel

        binding.setLifecycleOwner(this)

        binding.btnAnotherHit.setOnClickListener{
            this.findNavController().navigate(MyAdviceFragmentDirections.actionMyAdviceFragmentToHitPinataFragment())

        }




        return binding.root
    }

}