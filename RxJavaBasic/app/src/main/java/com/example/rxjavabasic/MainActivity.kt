package com.example.rxjavabasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
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

        val d = mapOperator().subscribe(
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
    }

}