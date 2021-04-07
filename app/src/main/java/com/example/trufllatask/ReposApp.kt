package com.example.trufllatask

import android.app.Application
import androidx.room.Room
import com.example.trufllatask.constants.Constants.Companion.database_name
import com.example.trufllatask.data.locale.MyDatabase

class ReposApp  : Application() {
    companion object {
        var db : MyDatabase? = null;
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, MyDatabase::class.java, database_name).fallbackToDestructiveMigration().build()
    }
}