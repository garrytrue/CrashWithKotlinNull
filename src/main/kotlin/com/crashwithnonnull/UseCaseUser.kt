package com.crashwithnonnull

import com.crashwithnonnull.data.Project
import io.reactivex.observers.DisposableObserver

class UseCaseUser constructor(private val getDataUseCase: GetDataUseCase) {

    fun fetchData() {
        getDataUseCase.execute(DataStateListener())
    }

    class DataStateListener : DisposableObserver<List<Project>>() {
        override fun onComplete() {
            //do nothing
        }

        override fun onNext(t: List<Project>) {
            // consume data
        }

        override fun onError(e: Throwable) {
            // consume error
        }
    }
}