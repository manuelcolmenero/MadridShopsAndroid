package com.mcolmenero.madridshops.domain.interactor

interface SuccessCompletion<T> {
    fun successCompletion (element: T)
}

interface ErrorCompletion {
    fun errorCompletion (errorMessage: String)
}