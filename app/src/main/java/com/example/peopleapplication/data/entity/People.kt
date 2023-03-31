package com.example.peopleapplication.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "kisiler")
data class People(@PrimaryKey(autoGenerate = true)
                  @ColumnInfo(name = "kisi_id") @NotNull var person_id:Int,
                  @ColumnInfo(name = "kisi_ad") @NotNull var person_name:String,
                  @ColumnInfo(name = "kisi_tel") @NotNull var person_phone:String): Serializable {
}