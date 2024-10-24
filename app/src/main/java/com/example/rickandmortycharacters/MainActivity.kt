package com.example.rickandmortycharacters

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortycharacters.Adapter.CharacterAdapter
import com.example.rickandmortycharacters.ViewModel.CharacterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CharacterViewModel
    private lateinit var adapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CharacterAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.rvCharacters)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
        viewModel.characters.observe(this, Observer {
            adapter.setCharacters(it)
        })
    }
}
