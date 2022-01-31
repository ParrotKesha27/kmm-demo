package com.example.kmm_demo.android.ui.screen.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kmm_demo.android.R
import com.example.kmm_demo.android.databinding.FragmentCharactersBinding
import com.example.kmm_demo.android.ui.screen.characters.adapter.CharacterAdapter
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.scope.scopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : Fragment(R.layout.fragment_characters) {

    private val binding by viewBinding(FragmentCharactersBinding::bind)
    private val viewModel: CharactersViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            charactersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.state.observe(viewLifecycleOwner) {
            when(it) {
                is CharactersState.Data -> binding.charactersRecyclerView.adapter = CharacterAdapter(it.characters)
            }
        }

        viewModel.setIntent(CharactersIntent.GetCharacters)
    }

    companion object {
        fun newInstance() = CharactersFragment()
    }
}