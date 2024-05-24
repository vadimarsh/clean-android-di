package com.example.cleanexamplemvvm.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanexamplemvvm.R
import com.example.cleanexamplemvvm.domain.entity.Task


class TaskListAdapter(var items:List<Task>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val taskItemView = LayoutInflater.from(parent.context).inflate(R.layout.task_item,parent,false)
        return TaskItemVewHolder(this,taskItemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is TaskItemVewHolder ->{
                holder.bind(items.get(position))
            }
        }
    }

}