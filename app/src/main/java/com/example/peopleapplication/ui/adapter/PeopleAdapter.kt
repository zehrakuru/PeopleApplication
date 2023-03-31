package com.example.peopleapplication.ui.adapter

import android.content.Context
import android.database.DatabaseUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.peopleapplication.R
import com.example.peopleapplication.data.entity.People
import com.example.peopleapplication.databinding.CardDesignBinding
import com.example.peopleapplication.ui.fragment.HomepageFragment
import com.example.peopleapplication.ui.fragment.HomepageFragmentDirections
import com.example.peopleapplication.ui.viewmodel.HomepageViewModel
import com.example.peopleapplication.util.doTransition
import com.google.android.material.snackbar.Snackbar

class PeopleAdapter(var mContext:Context,
                    var peopleList:List<People>,
                    var viewModel:HomepageViewModel) : RecyclerView.Adapter<PeopleAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(design:CardDesignBinding): RecyclerView.ViewHolder(design.root){
        var design:CardDesignBinding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design:CardDesignBinding = DataBindingUtil.inflate(layoutInflater, R.layout.card_design, parent, false)
        return CardDesignHolder(design)
    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val person = peopleList.get(position)
        holder.design.personObject = person

        holder.design.lineCard.setOnClickListener {
            val transition = HomepageFragmentDirections.personInfoTransition(person = person)
            Navigation.doTransition(it, transition)
        }

        holder.design.imageViewDelete.setOnClickListener {
            Snackbar.make(it, "Delete ${person.person_name}?", Snackbar.LENGTH_LONG)
                .setAction("YES"){
                    viewModel.delete(person.person_id)
                }.show()
        }
    }

}