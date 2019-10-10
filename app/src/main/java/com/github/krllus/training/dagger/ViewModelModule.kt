package com.github.krllus.training.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.krllus.training.viewmodels.FoxViewModel
import com.github.krllus.training.viewmodels.TrainingViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FoxViewModel::class)
    abstract fun bindFoxViewModel(foxViewModel: FoxViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: TrainingViewModelFactory): ViewModelProvider.Factory
}
