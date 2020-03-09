package com.xuchengpu.jetpackdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.xuchengpu.jetpackdemo.databinding.FragmentLoginBinding
import com.xuchengpu.jetpackdemo.model.LoginViewModel

/**
 * Created by 许成谱 on 2020/3/8 12:05.
 * qq:1550540124
 * for:热爱生活每一天！
 */
class LoginFragment : Fragment() {
    private var loginModel: LoginViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginModel = ViewModelProvider(this).get(LoginViewModel::class.java).apply {
            loginOk.observe(this@LoginFragment, Observer {ok->
                if (ok){
                    Navigation.findNavController(activity!!,R.id.fg_host_main).navigateUp()
                }
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val loginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        loginBinding.vm = loginModel
        return loginBinding.root
    }
}