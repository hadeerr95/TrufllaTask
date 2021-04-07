package com.example.trufllatask.data.locale

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.trufllatask.constants.Constants
import com.example.trufllatask.model.ReposItem

@Database(entities = [(ReposItem::class)], version = Constants.database_version)
abstract class MyDatabase : RoomDatabase() {
    abstract fun reposItemDao() : ReposItemDAO

}