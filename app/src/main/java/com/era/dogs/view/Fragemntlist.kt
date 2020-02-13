package com.era.dogs.view


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager


import com.era.dogs.R
import com.era.dogs.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class Fragemntlist : Fragment() {

    private lateinit var viewModel:ListViewModel
    private val dogListAdapter = DogsListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
       viewModel.refresh()


        dogList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dogListAdapter
        }

        refreshLayout.setOnRefreshListener {
            dogList.visibility = View.GONE
            listError.visibility = View.GONE
            loadingView.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    fun  observeViewModel(){
        viewModel.dogs.observe(this, Observer {dogs ->
           dogs?.let {

               dogList.visibility = View.VISIBLE
               dogListAdapter.updateDogList(dogs)
           }
        })


        viewModel.dogsLoadingError.observe(this, Observer { isError ->
            isError?.let {
                listError.visibility = if(it) View.VISIBLE else View.GONE
            }
        })

        viewModel.loading.observe(this, Observer { isLoading ->

            isLoading?.let {
                loadingView.visibility = if(it) View.VISIBLE else View.GONE
                if(it){
                    listError.visibility = View.GONE
                    dogList.visibility = View.GONE
                }
            }

        })

    }


}
