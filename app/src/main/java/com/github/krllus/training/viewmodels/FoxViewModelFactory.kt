package com.github.krllus.training.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.krllus.training.data.FoxRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FoxViewModelFactory @Inject constructor(
    private val foxRepository: FoxRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        require(modelClass == FoxViewModel::class) { "unknown viewmodel class" }
        return FoxViewModel(
            foxRepository
        ) as T
    }
}