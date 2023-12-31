package com.example.myapplication

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Task::class], version = 1) //Databaseアノテーションを付ける, entitiesにはテーブルとして使用するクラスを指定する, versionはデータベースのバージョンを指定する
abstract class AppDatabase: RoomDatabase() { //抽象クラスとして宣言する
    abstract fun taskDao(): TaskDao //TaskDaoを返す関数を宣言する
}