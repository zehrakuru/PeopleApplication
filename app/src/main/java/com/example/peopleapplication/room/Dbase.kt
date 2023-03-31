package com.example.peopleapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.peopleapplication.data.entity.People

@Database(entities = [People::class], version = 1)
abstract class Dbase : RoomDatabase() {
    abstract fun getPeopleDao() : PeopleDao
}