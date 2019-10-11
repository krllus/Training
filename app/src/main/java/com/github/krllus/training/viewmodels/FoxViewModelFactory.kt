package com.github.krllus.training.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.krllus.training.dagger.GlobalScope
import com.github.krllus.training.data.FoxRepository
import javax.inject.Inject

@GlobalScope
class FoxViewModelFactory @Inject constructor(
    private val foxRepository: FoxRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        require(modelClass == FoxViewModel::class.java) { "unknown viewmodel class" }
        return FoxViewModel(
            foxRepository
        ) as T
    }
}