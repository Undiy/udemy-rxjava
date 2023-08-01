package com.example.rxjavabasic

import com.example.rxjavabasic.data.User
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observables.ConnectableObservable

fun hotObservable(): ConnectableObservable<User> {
    return Observable.fromIterable(mUserList).publish()
}