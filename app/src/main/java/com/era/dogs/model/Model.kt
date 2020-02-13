package com.era.dogs.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class DogBreed(
    @ColumnInfo(name="bread_id")
    @SerializedName("id")
    var breedId:String?,

    @ColumnInfo(name="dog_name")
    @SerializedName("name")
    var dogBreed:String?,

    @ColumnInfo(name="life_span")
    @SerializedName("life_span")
    var lifeSpan:String?,

    @ColumnInfo(name="breed_group")
    @SerializedName("breed_group")
    var breedGroup:String?,

    @ColumnInfo(name="bred_for")
    @SerializedName("bred_for")
    var bredFor:String?,

    @ColumnInfo(name="temperament")
    @SerializedName("temperament")
    var temperament:String?,

    @ColumnInfo(name="dog_url")
    @SerializedName("url")
    var imageUrl:String?
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}
