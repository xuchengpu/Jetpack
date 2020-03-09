package com.xuchengpu.jetpackdemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.xuchengpu.jetpackdemo.bean.*

/**
 * Created by 许成谱 on 2020/3/8 18:12.
 * qq:1550540124
 * for:热爱生活每一天！
 */
@Database(entities = [ItemBean::class, UserBean::class,LoginStatus::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
    abstract fun getItemDao(): ItemDao
    abstract fun getStatusDao(): StatusDao

    companion object {
        private var instance: UserDatabase? = null
        fun getInstances(context: Context): UserDatabase {
            return instance ?: Room.databaseBuilder(context, UserDatabase::class.java, "user_db")
                .build()
        }
    }
}