package com.mcolmenero.madridshops.domain.interactor

import com.mcolmenero.madridshops.domain.model.Shops

interface GetAllShopsInteractor {
    fun execute(success: SuccessCompletion<Shops>, error: ErrorCompletion)
}