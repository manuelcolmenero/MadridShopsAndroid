package com.mcolmenero.madridshops.domain.interactor.deleteallactivities

import com.mcolmenero.madridshops.domain.interactor.CodeClosure
import com.mcolmenero.madridshops.domain.interactor.ErrorClosure

interface DeleteAllActivities {
    fun execute(success: CodeClosure, error: ErrorClosure)
}