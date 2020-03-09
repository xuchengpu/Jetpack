package com.xuchengpu.jetpackdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.xuchengpu.jetpackdemo.databinding.FragmentMainBinding
import com.xuchengpu.jetpackdemo.model.MainViewModel

/**
 * Created by 许成谱 on 2020/3/8 12:03.
 * qq:1550540124
 * for:热爱生活每一天！
 */
class MainFragment : Fragment() {
    private var viewModel:MainViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel=ViewModelProvider(this).get(MainViewModel::class.java).apply {
            liveList.observe(this@MainFragment, Observer {list->
                mAdapter.submitList(list)
//                mAdapter.notifyDataSetChanged()
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainBinding = FragmentMainBinding.inflate(inflater, container, false)
        mainBinding.vm=viewModel
        return mainBinding.root
    }
}