package com.example.mirasyan.lab2

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_item.*

class MainActivity : AppCompatActivity() {
    lateinit var dataset: ArrayList<User>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            dataset = savedInstanceState.getParcelableArrayList("dataset")
        } else {
            dataset = ArrayList()
        }

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recycler.layoutManager = GridLayoutManager(this, 3)
        } else {
            recycler.layoutManager = LinearLayoutManager(this)
        }

        recycler.adapter = UserAdapter(this, dataset)

        addButton.setOnClickListener {
            dataset.add(User("Johny Depp", "Hollywood Actor"))
            recycler.adapter.notifyDataSetChanged()
        }


    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.d("onSaveInstanceState", dataset.toString())

        outState?.putParcelableArrayList("dataset", dataset)

    }
}
