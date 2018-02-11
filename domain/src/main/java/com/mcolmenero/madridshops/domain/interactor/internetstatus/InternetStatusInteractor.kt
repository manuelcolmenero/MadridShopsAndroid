package com.mcolmenero.madridshops.domain.interactor.internetstatus

import android.content.Context
import com.mcolmenero.madridshops.domain.interactor.CodeClosure
import com.mcolmenero.madridshops.domain.interactor.ErrorClosure

interface InternetStatusInteractor {
    fun execute(context: Context, success: CodeClosure, error: ErrorClosure) {

    }
}