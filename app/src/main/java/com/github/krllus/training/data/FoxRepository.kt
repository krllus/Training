package com.github.krllus.training.data

import androidx.lifecycle.LiveData
import com.github.krllus.training.domain.service.FoxWebService
import java.util.concurrent.Executor
import javax.inject.Inject

class FoxRepository @Inject constructor(
    val webService: FoxWebService,
    val executor: Executor,
    val foxDao: FoxDao
) {

    fun getFox(foxId: String): LiveData<Fox> {
        refreshFox(foxId)

        return foxDao.load(foxId)
    }

    private fun refreshFox(foxId: String) {
        executor.execute {
            val foxExists = foxDao.hasFox(foxId)
            if (!foxExists) {
                val response = webService.getFox(foxId).execute()
                foxDao.save(response.body()!!)
            }
        }
    }
}