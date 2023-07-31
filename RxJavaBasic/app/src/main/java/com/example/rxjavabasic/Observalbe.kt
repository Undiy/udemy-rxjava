package com.example.rxjavabasic

import android.util.Log
import com.example.rxjavabasic.data.User
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.CompletableObserver
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.MaybeObserver
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable

lateinit var disposable: Disposable

fun createObservable(): Observable<Int> {
    return Observable.create { emitter ->
        try {
            if (!emitter.isDisposed) {
                (0..1000_000).forEach() {
                    emitter.onNext(it)
                }
                emitter.onComplete()
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }
}

fun observer(): Observer<Int> {
    return object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            disposable = d
            Log.d(TAG, "onSubscribe")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError ${e.toString()}")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }

        override fun onNext(t: Int) {
            Log.d(TAG, "onNext: $t")
        }

    }
}

fun createSingleObservable(): Single<Int> {
    return Single.create { emitter ->
        try {
            if (!emitter.isDisposed) {
                emitter.onSuccess(42)
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }
}

fun singleObserver(): SingleObserver<Int> {
    return object : SingleObserver<Int> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError ${e.toString()}")
        }

        override fun onSuccess(t: Int) {
            Log.d(TAG, "onSuccess: $t")
        }

    }
}

fun createMaybeObservable(): Maybe<List<User>> {
    return Maybe.just(emptyList())
}

fun maybeObserver(): MaybeObserver<List<User>> {
    return object  : MaybeObserver<List<User>> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError ${e.toString()}")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }

        override fun onSuccess(t: List<User>) {
            Log.d(TAG, "onSuccess: $t")
        }
    }
}

fun createCompletable(): Completable {
    return Completable.create {
        try {
            if (!it.isDisposed) {
                it.onComplete()
            }
        } catch (e: Exception) {
            it.onError(e)
        }
     }
}

fun completableObserver(): CompletableObserver {
    return object : CompletableObserver {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError ${e.toString()}")
        }

    }
}

fun createFlowable(): Flowable<Int> {
    return Flowable.range(1, 100)
}
