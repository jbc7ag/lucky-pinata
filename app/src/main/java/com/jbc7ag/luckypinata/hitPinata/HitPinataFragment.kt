package com.jbc7ag.luckypinata.hitPinata


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.jbc7ag.luckypinata.R
import com.jbc7ag.luckypinata.databinding.FragmentHitPinataBinding



class HitPinataFragment : Fragment() {

    private lateinit var viewModel: HitPinataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentHitPinataBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(HitPinataViewModel::class.java)
        binding.hitPinataViewModel = viewModel

        binding.setLifecycleOwner(this)

        viewModel.finishHit.observe(viewLifecycleOwner, Observer {

            if(it){
                this.findNavController().navigate(HitPinataFragmentDirections.actionHitPinataFragmentToMyAdviceFragment())
            }

        })

       // binding.imgPinata.setOnClickListener{

            AnimationUtils.loadAnimation(context, R.anim.pend_animation).also { animation ->
                binding.imgPinata.startAnimation(animation)
      //      }
        }



        return binding.root
    }
}