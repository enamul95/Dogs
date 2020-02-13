package com.era.dogs.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.era.dogs.model.DogBreed

@Dao
interface DogDao {

    @Insert
    suspend fun insetAll(vararg dogs:DogBreed):List<Long>

    @Query("SELECT * FROM DogBreed")
    suspend fun getAllDogs():List<DogBreed>

    @Query("SELECT * FROM DogBreed WHERE uuid =:dogId")
    suspend fun getDog(dogId:Int):DogBreed

    @Query("DELETE FROM DOGBREED")
    suspend fun deleteAllDogs()
}