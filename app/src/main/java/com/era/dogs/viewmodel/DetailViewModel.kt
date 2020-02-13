package com.era.dogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.era.dogs.model.DogBreed

class DetailViewModel: ViewModel() {
     var dogLiveData = MutableLiveData<DogBreed>();
    fun fetch(){
        var dog = DogBreed("1","Corgi","15 years","breadGroup","Bredfor","Temerament","")
        dogLiveData.value = dog
    }
}