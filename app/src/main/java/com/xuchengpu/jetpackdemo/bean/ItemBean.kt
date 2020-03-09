package com.xuchengpu.jetpackdemo.bean

import androidx.paging.DataSource
import androidx.room.*

/**
 * Created by 许成谱 on 2020/3/8 17:36.
 * qq:1550540124
 * for:热爱生活每一天！
 */
@Entity(tableName = "tb_item")
data class ItemBean(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    @ColumnInfo
    val name: String,//名字
    @ColumnInfo
    val color: Int//颜色
)
@Dao
interface ItemDao{
    @Insert
    fun insert(items:List<ItemBean>)

    @Query("select * from tb_item")
    fun queryAll(): DataSource.Factory<Int,ItemBean>
}