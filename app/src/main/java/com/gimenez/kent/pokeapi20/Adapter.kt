package com.gimenez.kent.pokeapi20

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.poke_item.view.*

/**
 * Created by Kent on 3/14/2018.
 */
class Adapter(val pokemons: ArrayList<Pokedata>?): RecyclerView.Adapter<Adapter.CustomViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int):
            CustomViewHolder = CustomViewHolder(LayoutInflater.from(parent?.context)
            .inflate(R.layout.poke_item,parent,false))

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {


        val pokemon = pokemons!![position]
        holder?.tvPokemonName?.text = pokemon.name
        holder?.tvHeight?.text = pokemon.height
        holder?.tvWeight?.text = pokemon.weight
        holder?.tvAbility?.text = pokemon.ability
        holder?.tvType?.text = pokemon.type
        holder?.tvBaseExp?.text = pokemon.base_experience

   /*     for (i in 0 until pokemon.abilities.size)
            holder?.tvabilities?.text = pokemon.abilities[i].ability.name*/

        Picasso.with(holder?.itemView?.context).load(pokemon.imageUrl).into(holder?.ivPokemon)

    }

    override fun getItemCount(): Int = pokemons!!.size



    class CustomViewHolder(view:View):RecyclerView.ViewHolder(view) {
                val ivPokemon = view.ivPokemon
                val tvPokemonName = view.tvResult
                val tvHeight = view.tvHeight
                val tvWeight = view.tvWeight
                val tvAbility = view.tvAbility
                val tvType = view.tvType
                val tvBaseExp = view.tvBaseExp

    }


}
