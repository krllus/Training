package com.github.krllus.training.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.github.krllus.training.data.Fox
import com.github.krllus.training.data.FoxRepository
import com.github.krllus.training.utils.AbsentLiveData
import javax.inject.Inject

class FoxViewModel @Inject constructor(
    foxRepository: FoxRepository
) : ViewModel() {

    private val _foxId = MutableLiveData<String>()

    val foxId: LiveData<String>
        get() = _foxId

    val fox: LiveData<Fox> = Transformations
        .switchMap(_foxId) { id ->
            if (id == null) {
                AbsentLiveData.create()
            } else {
                foxRepository.getFox(id)
            }

        }


    fun setFoxId(foxId: String?) {
        if (_foxId.value != foxId) {
            _foxId.value = foxId
        }
    }


}