package com.mcolmenero.madridshops.domain.interactor.getallactivities

import com.mcolmenero.madridshops.domain.interactor.ErrorCompletion
import com.mcolmenero.madridshops.domain.interactor.SuccessCompletion
import com.mcolmenero.madridshops.domain.model.Activities

interface GetAllActivitiesInteractor {
    fun execute(success: SuccessCompletion<Activities>, error: ErrorCompletion)
}