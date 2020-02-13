package com.era.dogs.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager;

class SharepreferanceHelper {

    companion object{

        private const val PREF_TIME= "Pref time"

    private var prefs:SharedPreferences? = null

        @Volatile private var instance:SharepreferanceHelper?= null

        private val LOCK = Any()

        operator fun invoke(context: Context):SharepreferanceHelper  = instance ?: synchronized(LOCK){
            instance?:buildHelper(context).also{

                instance = it
            }
        }
        private fun buildHelper(context: Context): SharepreferanceHelper{
            //prefs = getDefaultSharedPreferences(context)
            prefs =  PreferenceManager.getDefaultSharedPreferences(context)

            return SharepreferanceHelper()
        }

    }

    public fun saveDateTime(time:Long){
        prefs?.edit(commit = true){
            putLong(PREF_TIME,time)
        }

    }

     fun getupdateTime() = prefs?.getLong(PREF_TIME,0)
}