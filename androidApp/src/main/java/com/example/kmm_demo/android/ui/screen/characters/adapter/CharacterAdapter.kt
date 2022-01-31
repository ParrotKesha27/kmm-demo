package com.example.kmm_demo.android.ui.screen.characters.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kmm_demo.android.R
import com.example.kmm_demo.android.databinding.ItemCharacterBinding
import com.example.kmm_demo.android.extension.inflate
import com.example.kmm_demo.android.extension.load
import com.example.kmm_demo.shared.entity.Character

class CharacterAdapter(
    private val characters: List<Character>
) : RecyclerView.Adapter<CharacterAdapter.CharacterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CharacterHolder(parent.inflate(R.layout.item_character))

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) =
        holder.bind(characters[position])

    override fun getItemCount() = characters.size

    inner class CharacterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding by viewBinding(ItemCharacterBinding::bind)

        fun bind(character: Character) = with(binding) {
            avatar.load(character.image)
            name.text = character.name
            status.text = character.status
        }
    }
}
