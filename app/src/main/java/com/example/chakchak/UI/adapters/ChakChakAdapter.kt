package com.example.bratmoisha.UI.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chakchak.databinding.JokeItemBinding
import com.example.chakchak.model.ChakChakJoke
import org.jsoup.Jsoup

class ChakChakAdapter: RecyclerView.Adapter<ChakChakAdapter.MyViewHolder>() {

    private var chakList = emptyList<ChakChakJoke>()

    class MyViewHolder(val binding: JokeItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = JokeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = chakList[position]
        val text = Jsoup.parse(currentItem.joke).text()
        holder.binding.jokeText.setText(text)

    }

    override fun getItemCount(): Int {
        return chakList.size
    }

    fun setData(check: List<ChakChakJoke>){
        this.chakList = check
        notifyDataSetChanged()
    }
}