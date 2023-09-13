package com.luisguzman.myapplication1.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.luisguzman.myapplication1.R
import com.luisguzman.myapplication1.databinding.FragmentHomeBinding
import com.luisguzman.myapplication1.domain.model.Entries
import com.luisguzman.myapplication1.ui.home.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        setObservers()

    }

    fun setObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when(it) {
                      is HomeState.Success -> setUpListRecyclerView(it.data)
                    }
                }
            }
        }

    }

    private fun setUpListRecyclerView(listEntries: List<Entries>) {
        val index = listEntries.size
        listEntries.sortedBy { it.entries[index].Category}
        binding.setUpRv.adapter = HomeAdapter(
            listItem = listEntries,
            onClick = {  }
        )
    }

}