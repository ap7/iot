package fr.ap7.iot.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import fr.ap7.iot.R
import fr.ap7.iot.ViewModelProviderFactory
import io.reactivex.Flowable
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mViewModelProviderFactory: ViewModelProviderFactory
    lateinit var mMainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMainViewModel =
            ViewModelProviders.of(this, mViewModelProviderFactory).get(MainViewModel::class.java)

        Flowable.just("salut").subscribe(System.out::println)
    }
}
