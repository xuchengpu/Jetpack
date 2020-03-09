package com.xuchengpu.jetpackdemo.bean

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Created by 许成谱 on 2020/3/8 22:50.
 * qq:1550540124
 * for:热爱生活每一天！
 */
@Entity(tableName = "tb_status")
data class LoginStatus(
    @PrimaryKey(autoGenerate = false)
    val uid : Int = 0,
    @ColumnInfo
    val login : Boolean
)
@Dao
interface StatusDao {
    @Query("select login from tb_status where uid=0")
    fun queryStatus(): LiveData<Boolean>

    @Insert(entity = LoginStatus::class, onConflict = OnConflictStrategy.REPLACE)
    fun insert(status: LoginStatus)

    @Update
    fun updateStatus(status:LoginStatus)


}