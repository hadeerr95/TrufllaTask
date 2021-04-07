package com.example.trufllatask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trufllatask.model.ReposItem

class ReposAdapter(myRepos : List<ReposItem> ) : RecyclerView.Adapter<ReposAdapter.ViewHolder>() {

     var repos :List<ReposItem> = myRepos

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.repo_item, parent, false) as View
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name.text = repos.get(position).name
    }

    override fun getItemCount(): Int {
      return repos.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name_of_repo)

    }
}