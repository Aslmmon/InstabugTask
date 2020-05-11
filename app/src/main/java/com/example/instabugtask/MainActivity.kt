package com.example.instabugtask

import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.instabugtask.utils.Constants
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showProgress()
        val url = Constants.BASE_URL
        val task = NetworkClass(url, object : AsyncResponse {
            override fun processFinish(output: MutableList<String>?) {
                dismissProgressDialog()
                showList(output)
            }

        })
        task.execute()
    }

    private fun showList(output: MutableList<String>?) {
        val adapter: ArrayAdapter<*> =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, output!!)
        list.adapter = adapter
    }

    override fun provideLayout(): Int = R.layout.activity_main


}

