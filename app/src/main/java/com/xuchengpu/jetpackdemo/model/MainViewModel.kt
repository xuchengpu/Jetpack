package com.xuchengpu.jetpackdemo.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.recyclerview.widget.DiffUtil
import com.xuchengpu.jetpackdemo.adapter.FGMainAdapter
import com.xuchengpu.jetpackdemo.bean.ItemBean
import com.xuchengpu.jetpackdemo.db.UserDatabase

/**
 * Created by 许成谱 on 2020/3/8 17:14.
 * qq:1550540124
 * for:热爱生活每一天！
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val diffCallBack = object : DiffUtil.ItemCallback<ItemBean>() {
        override fun areItemsTheSame(oldItem: ItemBean, newItem: ItemBean): Boolean {
            return oldItem.uid == newItem.uid
        }

        override fun areContentsTheSame(oldItem: ItemBean, newItem: ItemBean): Boolean {
            return oldItem.uid == newItem.uid
        }

    }
    val mAdapter = FGMainAdapter(diffCallBack)
    val liveList: LiveData<PagedList<ItemBean>>

    init {
        val itemDao = UserDatabase.getInstances(application).getItemDao()
        liveList = LivePagedListBuilder<Int, ItemBean>(
            itemDao.queryAll(),
            PagedList.Config.Builder()
                .setInitialLoadSizeHint(80)
                .setPageSize(20)
                .setPrefetchDistance(10)
                .setEnablePlaceholders(false)
                .build()
        ).build()
    }

}