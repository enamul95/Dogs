package com.era.dogs.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.era.dogs.R
import com.era.dogs.model.DogBreed
import com.era.dogs.util.getProgressDrawble
import com.era.dogs.util.loadImage
import kotlinx.android.synthetic.main.item_dog.view.*

class DogsListAdapter(var dogList:ArrayList<DogBreed>):RecyclerView.Adapter<DogsListAdapter.DogViewHolder>()
{
   fun updateDogList(newLogList:List<DogBreed>){
       dogList.clear();
       dogList.addAll(newLogList);
       notifyDataSetChanged()
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {

        var inflater:LayoutInflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.item_dog,parent,false);
        return DogViewHolder(view);
    }

    override fun getItemCount() = dogList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {

        holder.view.name.text = dogList[position].dogBreed
        holder.view.lifespan.text = dogList[position].lifeSpan

        holder.view.img_dog_image.loadImage(dogList[position].imageUrl, getProgressDrawble(holder.view.img_dog_image.context))
        holder.view.setOnClickListener {
            Navigation.findNavController(it).navigate(FragemntlistDirections.actionToDetaailFragments())
        }
    }

    class DogViewHolder(var view:View):RecyclerView.ViewHolder(view)
}