package com.jbc7ag.luckypinata

import android.R
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.DialogFragmentNavigatorDestinationBuilder
import androidx.navigation.fragment.findNavController
import com.jbc7ag.luckypinata.databinding.FragmentHitPinataBinding
import kotlin.random.Random

private var randomNumber: Int = 0
private var countClick: Int = 0;

class HitPinataFragment : Fragment() {


    init {

        randomNumber = Random.nextInt(5, 10)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentHitPinataBinding.inflate(inflater)

        binding.setLifecycleOwner(this)

        val animation: Animation = AnimationUtils.loadAnimation(context, R.anim.fade_in)

        binding.imgPinata.setOnClickListener(View.OnClickListener {
            it.startAnimation(animation)

            Toast.makeText(context,"${randomNumber} - ${countClick}", Toast.LENGTH_LONG).show()

            if( countClick == randomNumber){
                this.findNavController().navigate(HitPinataFragmentDirections.actionHitPinataFragmentToMyAdviceFragment())
            }
            countClick++
        })

        return binding.root
    }
}