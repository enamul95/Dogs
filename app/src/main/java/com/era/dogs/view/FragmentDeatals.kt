package com.era.dogs.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.era.dogs.R
import com.era.dogs.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_deatals.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentDeatals : Fragment() {
    private lateinit var viewModel:DetailViewModel
 private var dogUuid = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_deatals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModel.fetch()
        arguments?.let {
            dogUuid = FragmentDeatalsArgs.fromBundle(it).dogUuid
           // textView2.text = dogUuid.toString()
        }

        obseverViewMode()
    }

    private fun obseverViewMode(){
        viewModel.dogLiveData.observe(this, Observer { dog ->
            dog?.let {
                dogName.text = dog.dogBreed
                dogPurpose.text = dog.bredFor
                dogTemperament.text = dog.temperament
                dogLifspan.text = dog.lifeSpan

            }
        })
    }
}


