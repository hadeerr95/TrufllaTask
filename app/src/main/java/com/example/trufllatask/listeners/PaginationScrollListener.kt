package com.example.trufllatask.listeners

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


// i want to use pagination library of jetpack but i not able customize it to pagination when specified third item from bottom as required , so i use this way
abstract class PaginationScrollListener(layoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {

    private val  myLayoutManager : LinearLayoutManager = layoutManager
    private val pageSize = 15

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val visibleItemCount: Int = myLayoutManager.childCount
        val totalItemCount: Int = myLayoutManager.itemCount
        val firstVisibleItemPosition: Int = myLayoutManager.findFirstVisibleItemPosition()

        if (!isLoading() && !isLastPage()) {
            if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0 &&
                totalItemCount >= pageSize-3) {
                loadMoreItems()
            }
        }
    }

    protected abstract fun loadMoreItems()

    abstract fun isLastPage(): Boolean

    abstract fun isLoading(): Boolean
}