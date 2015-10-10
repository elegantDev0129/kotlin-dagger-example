package org.loop.example

import android.location.LocationManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.activity_main.textView
import javax.inject.Inject
import javax.inject.Named

public class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.name

    lateinit var locationManager: LocationManager
        @Inject set

    var something: String? = null
        @Inject set(@Named("something") value) {
            field = value
        }

    var somethingElse: String = ""
        @Inject set(@Named("somethingElse") value) {
            field = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.graph.inject(this)
        assert(textView != null)
        Log.d(TAG, "$something and $somethingElse")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}
