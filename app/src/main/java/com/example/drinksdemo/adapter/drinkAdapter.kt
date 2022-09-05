package com.example.drinksdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.drinksdemo.databinding.RowDrinksBinding
import com.example.drinksdemo.model.Drink

class  DrinkAdapter : ListAdapter<Drink, DrinkAdapter.MyViewHolder>(SampleItemDiffCallback())
{

    class MyViewHolder (val itemBinding: RowDrinksBinding): RecyclerView.ViewHolder(itemBinding.root) {



    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
        //view binding
        val binding = RowDrinksBinding.inflate(view,parent,false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val drinkList = getItem(position)
        holder.itemBinding.drinkNameTextView.text = drinkList.strDrink
        Glide.with(holder.itemView.context)
            .load(drinkList.strDrinkThumb)
            .into(holder.itemBinding.drinksimageView)
    }

}


class SampleItemDiffCallback : DiffUtil.ItemCallback<Drink>() {
    override fun areItemsTheSame(oldItem: Drink, newItem: Drink): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: Drink, newItem: Drink): Boolean = oldItem == newItem

}