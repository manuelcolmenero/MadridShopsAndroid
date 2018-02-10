package com.mcolmenero.madridshops.repository.network

import com.mcolmenero.madridshops.repository.ErrorCompletion
import com.mcolmenero.madridshops.repository.SuccessCompletion

interface GetJsonManager {
    fun execute (url: String, success: SuccessCompletion<String>, error: ErrorCompletion) {

    }
}