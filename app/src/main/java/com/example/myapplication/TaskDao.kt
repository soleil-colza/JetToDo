package com.example.myapplication

import androidx.room.*
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    suspend fun insertTask(task: Task) //データベースにデータを追加する, taskはTask型の引数, suspendはコルーチンを使用することを示す（非同期ワンショット）

    @Query("SELECT * FROM task")
    fun loadALlTasks(): Flow<List<Task>> //データベースからデータを取得する, List<Task>はTask型のリストを返す. Flowは非同期でデータを取得する（返り値にFlowを指定する）

    @Update
    suspend fun updateTask(task: Task) //データベースのデータを更新する, taskはTask型の引数

    @Delete
    suspend fun deleteTask(task: Task) //データベースのデータを削除する, 引数に削除するデータを指定する

}