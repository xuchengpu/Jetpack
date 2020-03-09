package com.xuchengpu.jetpackdemo.model

import android.app.Application
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.xuchengpu.jetpackdemo.bean.LoginStatus
import com.xuchengpu.jetpackdemo.bean.UserBean
import com.xuchengpu.jetpackdemo.db.UserDatabase
import kotlin.concurrent.thread

/**
 * Created by 许成谱 on 2020/3/8 16:31.
 * qq:1550540124
 * for:热爱生活每一天！
 */
class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val name = ObservableField<String>()
    val pwd = ObservableField<String>()

    val loginOk = MutableLiveData<Boolean>()

    fun login() {
        Toast.makeText(getApplication(), "点击了登录", Toast.LENGTH_SHORT).show()
        var user = UserBean(0, name.get()!!, pwd.get()!!)

        //模拟联网请求后台传递用户名密码，耗时操作
        thread {
            UserDatabase.getInstances(getApplication())
                .getUserDao()
                .insert(user)
            UserDatabase.getInstances(getApplication())
                .getStatusDao()
                .insert(LoginStatus(login = true))

        }
        loginOk.value = true
    }
}