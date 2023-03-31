package com.example.peopleapplication.room

import androidx.room.Dao
import androidx.room.Query
import com.example.peopleapplication.data.entity.People

@Dao
interface PeopleDao {
    @Query("SELECT * FROM kisiler")
    suspend fun getPeople() : List<People>
}