package com.mcolmenero.madridshops.domain.interactor

import com.mcolmenero.madridshops.domain.model.Shops

typealias CodeClosure = () -> Unit
typealias SuccessClosure = (shops: Shops) -> Unit
typealias ErrorClosure =  (msg: String) -> Unit
typealias Variant = Any
