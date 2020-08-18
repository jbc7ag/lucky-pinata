package com.jbc7ag.luckypinata.hitPinata

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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

        val animation: Animation = AnimationUtils.loadAnimation(context, R.anim.fade_in)

        binding.imgPinata.setOnClickListener(View.OnClickListener {
            it.startAnimation(animation)

           // Toast.makeText(context,"${viewModel.randomNumber.value} - ${viewModel.countClick.value}", Toast.LENGTH_LONG).show()

            if(viewModel.finishHits()){
                this.findNavController().navigate(HitPinataFragmentDirections.actionHitPinataFragmentToMyAdviceFragment())
            }
            viewModel.addClick()
        })

        return binding.root
    }
}