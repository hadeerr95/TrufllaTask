package com.example.trufllatask.listeners

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


// i want to use pagination library of jetpack but i not able customize it to pagination when specified third item from bottom as required , so i use this way
abstract class PaginationScrollListener(layoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {

    var pastVisiblesItems = 0
    var visibleItemCount:Int = 0
    var totalItemCount:Int = 0
    private val mLayoutManager : LinearLayoutManager = layoutManager

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (dy > 0) { //check for scroll down
            visibleItemCount = mLayoutManager.childCount
            totalItemCount = mLayoutManager.itemCount
            pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition()


                if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                    loadMoreItems()
                }

        }

    }

    protected abstract fun loadMoreItems()
}