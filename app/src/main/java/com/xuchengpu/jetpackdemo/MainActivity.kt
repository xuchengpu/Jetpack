package com.xuchengpu.jetpackdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.xuchengpu.jetpackdemo.databinding.ActivityMainBinding
import com.xuchengpu.jetpackdemo.db.UserDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        UserDatabase.getInstances(this)
            .getStatusDao()
            .queryStatus()
            .observe(this, Observer {logged->
            if (logged!=true){
                Navigation.findNavController(this,R.id.fg_host_main).navigate(R.id.fg_login)
            }
        })



    }
}
