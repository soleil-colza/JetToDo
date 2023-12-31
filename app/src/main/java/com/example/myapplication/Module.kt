package com.example.myapplication

import android.content.Context
import androidx.room.Room
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@dagger.Module
@InstallIn(SingletonComponent::class) //InstallInアノテーションを付けることで、どのコンポーネントにインストールするかを指定する
object Module {
    @Provides //Providesアノテーションを付けることで、この関数が依存性の提供元であることを示す
    fun provideDatabase(
        @ApplicationContext context: Context //引数に@ApplicationContextアノテーションを付けることで、Contextを注入する
    ) = Room.databaseBuilder( //Room.databaseBuilderでデータベースを作成する
        context,
        AppDatabase::class.java,
        "task_database"
    ).build()

    @Provides
    fun provideDao(db: AppDatabase) = db.taskDao() //引数にAppDatabaseを指定することで、AppDatabaseを注入する
}