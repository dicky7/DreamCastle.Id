package com.example.dreamcastleid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dreamcastleid.Adapter.CardViewProductAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var rvProduct: RecyclerView
    private var list: ArrayList<Product> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvProduct=findViewById(R.id.rv_DreamCastle)
        rvProduct.setHasFixedSize(true)

        list.addAll(ProductData.listData)
        showRecyclerCard()
    }

    private fun showRecyclerCard() {
        rvProduct.layoutManager = LinearLayoutManager(this)
        val cardViewProductAdapter =
            CardViewProductAdapter(list)
        rvProduct.adapter = cardViewProductAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int){
        when(selectedMode){
            R.id.about_menu->{
                val  iabou=  Intent(this,About::class.java)
                startActivity(iabou)
            }
        }
    }
}