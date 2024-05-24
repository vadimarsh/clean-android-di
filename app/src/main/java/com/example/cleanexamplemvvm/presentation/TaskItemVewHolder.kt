package com.example.cleanexamplemvvm.presentation

import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanexamplemvvm.R
import com.example.cleanexamplemvvm.domain.entity.Task
import java.util.Date

class TaskItemVewHolder(val adapter: TaskListAdapter, val view: View) :
    RecyclerView.ViewHolder(view) {
    fun bind(task: Task) {

        with(view) {
            val disciplineTv = findViewById<TextView>(R.id.disciplineTv)
            val deadlineTv = findViewById<TextView>(R.id.deadlineTv)
            val taskTv = findViewById<TextView>(R.id.contentTv)
            val closeTaskButton = findViewById<ImageButton>(R.id.closeTaskButton)

            disciplineTv.text = task.discipline.name
            taskTv.text = task.title
            deadlineTv.text = Date(task.deadline).date.toString()
            when {
                task.isClosed -> {
                    closeTaskButton.setImageResource(R.drawable.close_task)
                }

                else -> {
                    closeTaskButton.setImageResource(R.drawable.closed_task)
                }
            }
        }

    }
}