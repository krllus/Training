package com.github.krllus.training.data

import androidx.lifecycle.LiveData
import com.github.krllus.training.AppExecutors
import com.github.krllus.training.domain.service.FoxWebService
import javax.inject.Inject

class FoxRepository @Inject constructor(
    private val webService: FoxWebService,
    private val appExecutors: AppExecutors,
    private val foxDao: FoxDao
) {

    fun getFox(foxId: String): LiveData<Fox> {
        refreshFox(foxId)

        return foxDao.load(foxId)
    }

    private fun refreshFox(foxId: String) {
        appExecutors.networkIO().execute {
            val response = webService.getRandomFox().execute()

            val fox = response.body() as Fox
            val clone = fox.copy(id = foxId, image = fox.image, link = fox.link)

            foxDao.save(clone)
        }
    }
}