package com.era.dogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.era.dogs.model.DogBreed
import com.era.dogs.model.DogsApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel:ViewModel() {

   private val dogService = DogsApiService()
   private val disposable = CompositeDisposable()

    var dogs = MutableLiveData<List<DogBreed>>();
    var dogsLoadingError = MutableLiveData<Boolean>()
    var loading = MutableLiveData<Boolean>();
    fun refresh(){
       fetchFromRemote()

        //var dog1 = DogBreed("1","Corgi","15 years","breadGroup","Bredfor","Temerament","")
     /*  var dog1 = DogBreed("1","Corgi","15 years","breadGroup","Bredfor","Temerament","")
        var dog2 = DogBreed("2","Lanbard","10 years","breadGroup","Bredfor","Temerament","")
        var dog3 = DogBreed("3","Rotwari","20 years","breadGroup","Bredfor","Temerament","")

        var dogList:ArrayList<DogBreed> = arrayListOf<DogBreed>(dog1,dog2,dog3);
        dogs.value = dogList
        dogsLoadingError.value = false
        loading.value = false
        */


    }

   private fun fetchFromRemote(){

       loading.value = true
       disposable.add(dogService.getDogs()
           .subscribeOn(Schedulers.newThread())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribeWith(object : DisposableSingleObserver<List<DogBreed>>() {
               override fun onSuccess(dogList: List<DogBreed>) {

                   dogs.value = dogList
                   dogsLoadingError.value = false
                   loading.value = false
               }

               override fun onError(e: Throwable) {
                   dogsLoadingError.value = true
                   loading.value = false
                   e.printStackTrace()

               }

           })
       )
   }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }


}