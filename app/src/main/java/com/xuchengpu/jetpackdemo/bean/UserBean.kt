package com.xuchengpu.jetpackdemo.bean

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Created by 许成谱 on 2020/3/8 18:03.
 * qq:1550540124
 * for:热爱生活每一天！
 *
为方便操作，将UserDao一起放入bean类中
tablename:表名
@Primarykey:指定主键
@ColumnInfo:指定了这个注解，表中才会创建这个字段

@Dao:定义操作类
@Query(value):定义查询，参数为sql语句
fun query():LiveData<UserBean> 既可以指定返回值为LiveData<T>,又可以指定为bean类对象：UserBean
@Insert(entity=UserBean::class,onConflict=OnConflictStrategy.REPLACE)：定义插入，括号内参数可不指定，有默认值
entity：插入的实体类
onConflict：冲突时指定的模式，上例为替换
@Update:定义更新（参数为实体类对象）
@Delete:定义删除（参数为实体类对象）
 */
@Entity(tableName = "tb_user")
data class UserBean(
    @PrimaryKey
    val uid: Int,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val pwd: String
)

@Dao
interface UserDao {
    @Query("select * from tb_user where uid=0")
    fun query(): LiveData<UserBean>

    @Insert(entity = UserBean::class, onConflict = OnConflictStrategy.REPLACE)
    fun insert(userBean: UserBean)

    @Update
    fun update(userBean: UserBean)

    @Delete
    fun delete(userBean: UserBean)
}


