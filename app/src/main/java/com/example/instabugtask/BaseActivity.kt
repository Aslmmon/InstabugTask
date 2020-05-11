package com.example.instabugtask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instabugtask.utils.ProgressDialog

abstract class BaseActivity : AppCompatActivity(){
    lateinit var loadingDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayout())
        loadingDialog = ProgressDialog(this)

    }

    abstract fun provideLayout(): Int

    fun showProgress() {
        loadingDialog.show()
    }

    fun dismissProgressDialog() {
        loadingDialog.dismiss()
    }

}