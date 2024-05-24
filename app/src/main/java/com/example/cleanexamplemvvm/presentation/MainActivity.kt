package com.example.cleanexamplemvvm.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanexamplemvvm.R
import com.example.cleanexamplemvvm.domain.entity.Discipline
import com.example.cleanexamplemvvm.domain.entity.Task
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
     
private val vm by viewModel<MainViewModel>()
private lateinit var taskListAdapter:TaskListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val fabButton = findViewById<FloatingActionButton>(R.id.addTaskFAB)
        val tasksRV = findViewById<RecyclerView>(R.id.recView)


        vm.load()
        var taskListAdapter= TaskListAdapter(vm.resultLive.value!!)
        tasksRV.adapter=taskListAdapter


        tasksRV.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            taskListAdapter = TaskListAdapter(vm.resultLive.value!!)
        }
        var items = taskListAdapter.items

        vm.resultLive.observe( this, Observer {
            items = it
            taskListAdapter = TaskListAdapter(it)
            tasksRV.adapter=taskListAdapter
        })
        fabButton.setOnClickListener(View.OnClickListener {
            val task3 = Task(
                2,
                "Лаб.раб №1",
                false,
                //DateFormat.getDateInstance(DateFormat.SHORT).parse("01.01.24")!!.time,
                766766,
                Discipline(1, "Базы данных", false, 5)
            )
            vm.save(task3)

        })
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
    }

    
}