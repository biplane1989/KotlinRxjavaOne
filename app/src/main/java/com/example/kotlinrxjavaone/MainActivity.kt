package com.example.kotlinrxjavaone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private var TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//Start the stream when the button is clicked//

        button.setOnClickListener { startRStream2() }
    }

    private fun startRStream() {

        val myObservable = getObservable()

        val myObserver = getObserver()

        myObservable
                .subscribe(myObserver)
    }

    private fun getObserver(): Observer<String> {
        return object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(s: String) {
                Log.d(TAG, "onNext: $s")
            }

            override fun onError(e: Throwable) {
                Log.e(TAG, "onError: " + e.message)
            }

            override fun onComplete() {
                Log.d(TAG, "onComplete")
            }
        }
    }

//Give myObservable some data to emit//

    private fun getObservable(): Observable<String> {
        return Observable.just("1", "2", "3", "4", "5")
    }

    private fun startRStream2() {

        val list = listOf("1", "2", "3", "4", "5")
        list.toObservable()
                .subscribeBy(

                        onNext = { println(it) },
                        onError = { it.printStackTrace() },
                        onComplete = { println("onComplete!") }

                )
    }

    private fun startRStream3() {

        val list = listOf("1", "2", "3", "4", "5")
        val text = "Orange"
        val arr = ArrayList<Int>();
        arr.add(1)
        arr.add(2)
        arr.add(3)

    }

    fun sum(x: Int, y: Int) = x + y
}
