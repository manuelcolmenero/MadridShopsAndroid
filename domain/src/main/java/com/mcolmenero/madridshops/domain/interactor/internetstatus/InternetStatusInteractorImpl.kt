package com.mcolmenero.madridshops.domain.interactor.internetstatus

import com.mcolmenero.madridshops.domain.interactor.CodeClosure
import com.mcolmenero.madridshops.domain.interactor.ErrorClosure

class InternetStatusInteractorImpl() : InternetStatusInteractor {
    override fun execute(success: CodeClosure, error: ErrorClosure) {
        success()
    }

}
