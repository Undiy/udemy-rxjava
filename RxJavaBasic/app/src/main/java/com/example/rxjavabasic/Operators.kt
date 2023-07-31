package com.example.rxjavabasic

import android.util.Log
import com.example.rxjavabasic.data.Blog
import com.example.rxjavabasic.data.BlogDetail
import com.example.rxjavabasic.data.User
import com.example.rxjavabasic.data.UserProfile
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observables.GroupedObservable
import java.util.Arrays
import java.util.concurrent.TimeUnit

val mListNum = (1..12).toMutableList()
val arrayNum1 = mListNum.toTypedArray()
val arrayNum2 = (10..120 step 10).toList().toTypedArray()
val mUserList = mutableListOf(
    User(1, "demo1", 15),
    User(2, "demo2", 18),
    User(3, "demo3", 20),
    User(4, "demo4", 21),
    User(5, "demo5", 23),
    User(6, "demo6", 22) ,
    User(7, "demo7", 23),
    User(8, "demo8", 22)
)
val mUserProfileList = mUserList.map {
    UserProfile(it.id, it.name, it.age, "https://test.com/${it.id}")
}

val mBlogList = mutableListOf(
    Blog(1, 1,"title1", "content1"),
    Blog(2, 1,"title2", "content2"),
    Blog(3, 2,"title1", "content1"),
    Blog(4, 2,"title2", "content2"),
    Blog(5, 2,"title3", "content3"),
    Blog(6, 3,"title1", "content1"),
    Blog(7, 13,"title1", "content1")
)


fun justOperator() {
    val observable = Observable.just(mListNum)

    val obsever = object : Observer<List<Int>> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError ${e.toString()}")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }

        override fun onNext(t: List<Int>) {
            Log.d(TAG, "onNext: $t")
        }
    }

    observable.subscribe(obsever)
}

fun fromOperator() {
    val observable = Observable.fromArray(arrayNum1, arrayNum2)

    val observer = object : Observer<Array<Int>> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError ${e.toString()}")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }

        override fun onNext(t: Array<Int>) {
            Log.d(TAG, "onNext: ${t.contentToString()}")
        }
    }

    observable.subscribe(observer)
}

fun fromIterableOperator() {
    val observable = Observable.fromIterable(mListNum)

    val observer = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
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

    observable.subscribe(observer)
}

fun rangeOperator(): Observable<Int> {
    return Observable.range(1, 10)
}

fun repeatOperator(): Observable<Int> {
    return rangeOperator().repeat(3)
}

fun intervalOperator(): Observable<Long> {
    return Observable.interval(1, TimeUnit.SECONDS).takeWhile { it <= 10 }
}

fun timerOperator(): Observable<Long> {
    return Observable.timer(3, TimeUnit.SECONDS)
}

fun createOperator(): Observable<Int> {
    return Observable.create(ObservableOnSubscribe {
        try {
            for (i in mListNum) {
                it.onNext(i * 5)
            }
//            throw RuntimeException("BOOM!")
            it.onComplete()
        } catch (e: Exception) {
            it.onError(e)
        }
    })
}

fun filterOperator(): Observable<User> {
    return Observable.fromIterable(mUserList).filter { it.age > 18 }
}

fun lastOperator(): Single<User> {
    return Observable.fromIterable(mUserList).last(User(0, "", 0))
}

fun distinctOperator(): Observable<User> {
    return Observable.fromIterable(mUserList).distinct(User::age)
}

fun skipOperator(): Observable<User> {
    return Observable.fromIterable(mUserList).skip(2)
}

fun bufferOperator(): Observable<List<User>> {
    return Observable.fromIterable(mUserList).buffer(3)
}

fun mapOperator(): Observable<UserProfile> {
    return Observable.fromIterable(mUserList).map {
        UserProfile(it.id, it.name, it.age, "https://test.com/${it.id}")
    }
}

fun flatMapOperator(): Observable<UserProfile> {
    return Observable.fromIterable(mUserList).flatMap {
        getUserProfile(it.id)
    }
}

fun getUserProfile(id: Long): Observable<UserProfile> {
    return Observable.fromIterable(mUserProfileList)
        .filter { it.id == id }
}

fun grupByOperator(): Observable<GroupedObservable<Int, User>> {
    return Observable.fromIterable(mUserList).groupBy(User::age)
}

fun getUser(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun getProfile(): Observable<UserProfile> {
    return Observable.fromIterable(mUserProfileList)
}

fun mergeOperator(): Observable<Any> {
    return Observable.merge(getUser(), getProfile())
}

fun concatOperator(): Observable<Int> {
//    return Observable.concat(
//        Observable.range(1, 10),
//        Observable.range(101, 80)
//    )

    return Observable.range(1, 10)
        .concatWith(Observable.range(101, 80))
}

fun startWithOperator(): Observable<Int> {
    return Observable.range(101, 80)
        .startWith(Observable.range(1, 10))
}

fun zipOperator(): Observable<Any> {
//    val num = Observable.just(1, 2,3,4,5)
//    val ch = Observable.just('A', 'B','C','D','E')
//    return Observable.zip(num, ch) { t1, t2 ->
//        "$t1 $t2"
//    }

    return Observable.zip(Observable.just(mUserList), Observable.just(mBlogList)) { t1, t2 ->
        t1.flatMap { user ->
            t2.filter { it.userId == user.id }.map {
                BlogDetail(it.id, it.userId, it.title, it.content, user)
            }
        }
    }
}