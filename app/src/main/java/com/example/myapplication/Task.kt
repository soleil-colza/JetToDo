package com.example.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity //データベースのテーブルとして使用することを示す
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int, //autoGenerate = trueは自動でIDを割り振る
    var title: String, //titleとdescriptionは変更可能なのでvar
    var description: String,
)
