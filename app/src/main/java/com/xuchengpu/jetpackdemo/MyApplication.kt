package com.xuchengpu.jetpackdemo

import android.app.Application
import android.content.Context
import android.provider.SyncStateContract.Helpers.insert
import android.util.Log
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.xuchengpu.jetpackdemo.bean.ItemBean
import com.xuchengpu.jetpackdemo.db.UserDatabase

/**
 * Created by 许成谱 on 2020/3/8 16:35.
 * qq:1550540124
 * for:热爱生活每一天！
 */
class MyApplication : Application() {
    private var workRequest=OneTimeWorkRequest.Builder(ListWorker::class.java).build()

    override fun onCreate() {
        super.onCreate()
        mContext = this
        //模拟首页显示的数据
        WorkManager.getInstance(this).enqueue(workRequest)
    }

    companion object {
        private var mContext: Context? = null
        fun getContext(): Context? {
            return mContext
        }
    }

    class ListWorker(private val context: Context,params:WorkerParameters ):Worker(context,params){
        override fun doWork(): Result {
            val itemDao = UserDatabase.getInstances(context)
                .getItemDao()
            val mutableList = mutableListOf<ItemBean>()
            for (i in 0..499){
                mutableList.add(ItemBean(name = "Double D $i",color = 0))
            }
            Log.e("tag","mutableList.size="+mutableList.size)
            itemDao.insert(mutableList)
            val queryAll = itemDao.queryAll()
            return Result.success()
        }

    }
}