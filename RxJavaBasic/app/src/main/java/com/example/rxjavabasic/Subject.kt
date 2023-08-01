package com.example.rxjavabasic

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject
import java.util.concurrent.TimeUnit

fun asyncSubject() {
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile { it <= 5 }

    val subject = AsyncSubject.create<Long>()

    observable.subscribe(subject)

    val d1 = subject.subscribe(
        {
            Log.d(TAG, "onNext1: $it")
        },
        {
            Log.d(TAG, "onError1 ${it.toString()}")
        },
        {
            Log.d(TAG, "onComplete1")
        }
    )

    val d2 = subject.subscribe(
        {
            Log.d(TAG, "onNext2: $it")
        },
        {
            Log.d(TAG, "onError2 ${it.toString()}")
        },
        {
            Log.d(TAG, "onComplete2")
        }
    )
}

fun asyncSubject2() {
    val subject = AsyncSubject.create<Int>()
    subject.onNext(42)

    val d = subject.subscribe(
        {
            Log.d(TAG, "onNext: $it")
        },
        {
            Log.d(TAG, "onError ${it.toString()}")
        },
        {
            Log.d(TAG, "onComplete")
        }
    )
    subject.onNext(2)
    subject.onNext(3)

    val d2 = subject.subscribe(
        {
            Log.d(TAG, "onNext2: $it")
        },
        {
            Log.d(TAG, "onError2 ${it.toString()}")
        },
        {
            Log.d(TAG, "onComplete2")
        }
    )

    subject.onComplete()
}

fun behaviorSubject() {
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile { it <= 5 }

    val subject = BehaviorSubject.create<Long>()
    observable.subscribe(subject)

    val d1 = subject.subscribe(
        {
            Log.d(TAG, "onNext1: $it")
        },
        {
            Log.d(TAG, "onError1 ${it.toString()}")
        },
        {
            Log.d(TAG, "onComplete1")
        }
    )

    Thread.sleep(3000)

    val d2 = subject.subscribe(
        {
            Log.d(TAG, "onNext2: $it")
        },
        {
            Log.d(TAG, "onError2 ${it.toString()}")
        },
        {
            Log.d(TAG, "onComplete2")
        }
    )

}

fun publishSubject() {
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile { it <= 5 }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    val subject = PublishSubject.create<Long>()
    observable.subscribe(subject)

    val d1 = subject.subscribe(
        {
            Log.d(TAG, "onNext1: $it")
        },
        {
            Log.d(TAG, "onError1 ${it.toString()}")
        },
        {
            Log.d(TAG, "onComplete1")
        }
    )

    Thread.sleep(5000)

    val d2 = subject.subscribe(
        {
            Log.d(TAG, "onNext2: $it")
        },
        {
            Log.d(TAG, "onError2 ${it.toString()}")
        },
        {
            Log.d(TAG, "onComplete2")
        }
    )
}

fun publishSubject2() {
    val subject = PublishSubject.create<Int>()
    subject.onNext(42)

    val d = subject.subscribe(
        {
            Log.d(TAG, "onNext: $it")
        },
        {
            Log.d(TAG, "onError ${it.toString()}")
        },
        {
            Log.d(TAG, "onComplete")
        }
    )
    subject.onNext(2)
    subject.onNext(3)

    val d2 = subject.subscribe(
        {
            Log.d(TAG, "onNext2: $it")
        },
        {
            Log.d(TAG, "onError2 ${it.toString()}")
        },
        {
            Log.d(TAG, "onComplete2")
        }
    )

    subject.onNext(4)
    subject.onNext(5)

    subject.onComplete()
}
fun replaySubject() {
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile { it <= 5 }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    val subject = ReplaySubject.create<Long>()
    observable.subscribe(subject)

    val d1 = subject.subscribe(
        {
            Log.d(TAG, "onNext1: $it")
        },
        {
            Log.d(TAG, "onError1 ${it.toString()}")
        },
        {
            Log.d(TAG, "onComplete1")
        }
    )

    Thread.sleep(5000)

    val d2 = subject.subscribe(
        {
            Log.d(TAG, "onNext2: $it")
        },
        {
            Log.d(TAG, "onError2 ${it.toString()}")
        },
        {
            Log.d(TAG, "onComplete2")
        }
    )
}

fun replaySubject2() {
    val subject = ReplaySubject.create<Int>()
    subject.onNext(42)

    val d = subject.subscribe(
        {
            Log.d(TAG, "onNext: $it")
        },
        {
            Log.d(TAG, "onError ${it.toString()}")
        },
        {
            Log.d(TAG, "onComplete")
        }
    )
    subject.onNext(2)
    subject.onNext(3)

    val d2 = subject.subscribe(
        {
            Log.d(TAG, "onNext2: $it")
        },
        {
            Log.d(TAG, "onError2 ${it.toString()}")
        },
        {
            Log.d(TAG, "onComplete2")
        }
    )

    subject.onNext(4)
    subject.onNext(5)

    subject.onComplete()
}