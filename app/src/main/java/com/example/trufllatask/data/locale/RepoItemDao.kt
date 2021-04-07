package com.example.trufllatask.data.locale

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.trufllatask.constants.Constants.Companion.repo_table
import com.example.trufllatask.model.ReposItem


@Dao
interface ReposItemDAO {

    @Query("SELECT * From $repo_table")
    fun getImageItemList()  : LiveData<List<ReposItem>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertImageItems(countryList: List<ReposItem>)

    @Query("DELETE FROM $repo_table")
    fun deleteAllImageItems()
}