package com.example.rxjavabasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rxjavabasic.data.User
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observables.GroupedObservable
import io.reactivex.rxjava3.schedulers.Schedulers


const val TAG = "RxJavaBasicTag"
class MainActivity : AppCompatActivity() {

    val compositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        justOperator()
//        fromOperator()
//        fromIterableOperator()

//        val d = rangeOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        val d = repeatOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        val d = intervalOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        val d = timerOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        val d = createOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        val d = filterOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        val d = lastOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError ${it.toString()}")
//            }
//        )

//        val d = distinctOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        val d = skipOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        val d = bufferOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        val d = mapOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        val d = flatMapOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        val d = grupByOperator()
//            .flatMapSingle(GroupedObservable<Int, User>::toList)
//            .subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        val d = mergeOperator()
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError ${it.toString()}")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        val d = concatOperator().subscribe(
//           {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        val d = startWithOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        val d = zipOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        createObservable().subscribe(observer())

//        createSingleObservable().subscribe(singleObserver())

//        createMaybeObservable().subscribe(maybeObserver())

//        createCompletable().subscribe(completableObserver())

//        val d = createFlowable()
//            .onBackpressureLatest()
//            .observeOn(Schedulers.io(), false, 10)
//            .subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError ${it.toString()}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        compositeDisposable.add(
//            createObservable()
//                .subscribeOn(Schedulers.io())
//                .subscribe(
//                    {
//                        Log.d(TAG, "onNext: $it")
//                    },
//                    {
//                        Log.d(TAG, "onError ${it.toString()}")
//                    },
//                    {
//                        Log.d(TAG, "onComplete")
//                    }
//                )
//        )

//        compositeDisposable.add(
//            Observable.just(mUserList)
//                .flatMap{
//                    Log.d(TAG, "Upstream threadName: ${Thread.currentThread().name}")
//                    Observable.fromIterable(it)
//                }
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                    {
//                        Log.d(TAG, "onNext: $it, threadName: ${Thread.currentThread().name}")
//                    },
//                    {
//                        Log.d(TAG, "onError ${it.toString()}")
//                    },
//                    {
//                        Log.d(TAG, "onComplete")
//                    }
//                )
//
//        )

//        coldObservable().subscribe(coldObserver())
//        Thread.sleep(200)
//        coldObservable().subscribe(coldObserver())
//        Thread.sleep(200)
//        coldObservable().subscribe(coldObserver())


        val hotObservable = hotObservable()
        compositeDisposable.add(
            hotObservable.subscribe(
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
        )
        hotObservable.connect()
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }
}