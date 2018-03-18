package com.gimenez.kent.pokeapi20

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL


class MainActivity : AppCompatActivity() {


    val url = "https://pokeapi.co/api/v2/pokemon/"
    private var Pokemons: ArrayList<Pokedata>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView.layoutManager = LinearLayoutManager(this)

        ivSearch.setOnClickListener {


                    progressBar.visibility = View.VISIBLE
                var name:String


                doAsync {

                    name = etPokemonName.text.toString()

                    val resultJson = URL(url + name).readText()
                    val jsonObject = JSONObject(resultJson)
                    val Pokemonname = (jsonObject.getString("name"))
                    val imageUrl = jsonObject.getJSONObject("sprites").getString("front_default")
                    val height = (jsonObject.getString("height"))
                    val weight = (jsonObject.getString("weight"))
                    val ability = jsonObject.getJSONArray("abilities").getJSONObject(0).getJSONObject("ability").getString("name")
                    val type = jsonObject.getJSONArray("types").getJSONObject(0).getJSONObject("type").getString("name")
                    val baseExp = (jsonObject.getString("base_experience"))


                    uiThread {

                            Pokemons = ArrayList()
                            recyclerView.adapter = Adapter(Pokemons)
                            Pokemons?.add(Pokedata(Pokemonname, imageUrl,height,weight,ability,type,baseExp))
                        }

                    progressBar.visibility = View.INVISIBLE

                }



                }

            }

        }




