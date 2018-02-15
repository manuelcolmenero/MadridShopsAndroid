package com.mcolmenero.madridshops.domain.interactor.deleteallactivities

import android.content.Context
import com.mcolmenero.madridshops.domain.interactor.CodeClosure
import com.mcolmenero.madridshops.domain.interactor.ErrorClosure
import com.mcolmenero.madridshops.repository.RepositoryImpl
import java.lang.ref.WeakReference

class DeleteAllActivitiesImpl(context: Context) : DeleteAllActivities {
    val context = WeakReference<Context>(context)

    override fun execute(success: CodeClosure, error: ErrorClosure) {
        val repository = RepositoryImpl(context.get()!!)

        repository.deleteAllActivities(success, error)
    }
}