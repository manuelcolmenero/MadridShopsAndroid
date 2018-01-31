package com.mcolmenero.madridshops.domain.interactor.deleteallshops

import android.content.Context
import com.mcolmenero.madridshops.domain.interactor.CodeClosure
import com.mcolmenero.madridshops.domain.interactor.ErrorClosure
import com.mcolmenero.madridshops.repository.RepositoryImpl
import java.lang.ref.WeakReference

class DeleteAllShopsImpl(context: Context) : DeleteAllShops {
    val context = WeakReference<Context>(context)

    override fun execute(success: CodeClosure, error: ErrorClosure) {
        val repository = RepositoryImpl(context.get()!!)

        repository.deleteAllShops(success, error)
    }
}