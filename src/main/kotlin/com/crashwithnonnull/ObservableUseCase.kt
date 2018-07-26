package com.crashwithnonnull

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

abstract class ObservableUseCase<T, in Params> {
    private val disposables = CompositeDisposable()

    abstract fun buildUseCaseObservable(params: Params? = null): Observable<T>

    open fun execute(observer: DisposableObserver<T>, params: Params? = null) {
        val observable = buildUseCaseObservable(params)
        disposables.add(observable.subscribeWith(observer))
    }


    fun shutdown() {
        if (!disposables.isDisposed) disposables.dispose()
    }
}