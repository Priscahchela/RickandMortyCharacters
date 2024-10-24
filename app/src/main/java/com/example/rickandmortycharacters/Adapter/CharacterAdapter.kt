package com.example.rickandmortycharacters.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortycharacters.CharacterResult
import com.example.rickandmortycharacters.R

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private val characters = mutableListOf<CharacterResult>()

    fun setCharacters(list: List<CharacterResult>) {
        characters.clear()
        characters.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val Character = characters[position]
        holder.bind(Character)
    }

    override fun getItemCount() = characters.size

    class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.tvCharacterName)
        private val status: TextView = view.findViewById(R.id.tvCharacterStatus)
        private val image: ImageView = view.findViewById(R.id.imgCharacter)

        fun bind(character: CharacterResult) {
            name.text = character.name
            status.text = character.status
            Glide.with(itemView.context).load(character.image).into(image)
        }
    }
}
