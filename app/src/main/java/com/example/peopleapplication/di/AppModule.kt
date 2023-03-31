package com.example.peopleapplication.di

import android.content.Context
import androidx.room.Room
import com.example.peopleapplication.data.repo.PeopleDaoRepository
import com.example.peopleapplication.room.Dbase
import com.example.peopleapplication.room.PeopleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePeopleDaoRepository(pdao: PeopleDao) : PeopleDaoRepository {
        return PeopleDaoRepository(pdao)
    }

    @Provides
    @Singleton
    fun providePeopleDao(@ApplicationContext context: Context) : PeopleDao {
        val db = Room.databaseBuilder(context, Dbase::class.java, "rehber.sqlite")
            .createFromAsset("rehber.sqlite").build()
        return db.getPeopleDao()
    }
}