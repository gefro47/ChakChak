package com.example.chakchak.utilits

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bratmoisha.UI.adapters.ChakChakAdapter
import com.example.chakchak.model.ChakChakJoke

fun initRecyclerViewForCheck(recyclerView: RecyclerView, requireContext: Context, chakList: List<ChakChakJoke>){
    val adapter = ChakChakAdapter()

    adapter.setData(chakList)
    recyclerView.adapter = adapter
    recyclerView.layoutManager = LinearLayoutManager(requireContext)
}