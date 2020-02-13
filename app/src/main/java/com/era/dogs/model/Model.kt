package com.era.dogs.model

import com.google.gson.annotations.SerializedName

data class DogBreed(
    @SerializedName("id")
    var breedId:String?,

    @SerializedName("name")
    var dogBreed:String?,

    @SerializedName("life_span")
    var lifeSpan:String?,

    @SerializedName("breed_group")
    var breedGroup:String?,

    @SerializedName("bred_for")
    var bredFor:String?,

    @SerializedName("temperament")
    var temperament:String?,

    @SerializedName("url")
    var imageUrl:String?
)
