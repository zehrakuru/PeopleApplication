package com.example.peopleapplication.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.doTransition(it:View, id:Int) {
    findNavController(it).navigate(id)
}

fun Navigation.doTransition(it:View, id:NavDirections) {
    findNavController(it).navigate(id)
}