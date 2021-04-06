package com.example.dreamcastleid.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.dreamcastleid.DetailProductAcitvity
import com.example.dreamcastleid.Product
import com.example.dreamcastleid.R

class CardViewProductAdapter (private  val listProduct : ArrayList<Product>):RecyclerView.Adapter<CardViewProductAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        var tvPrice : TextView = itemView.findViewById(R.id.tv_item_price)
        var tvDetail : TextView = itemView.findViewById(R.id.tv_item_detail)
        var btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        var btnShare: Button = itemView.findViewById(R.id.btn_set_share)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview,parent,false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val product = listProduct[position]

        Glide.with(holder.itemView.context)
            .load(product.Photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)
            holder.tvName.text = product.name
            holder.tvPrice.text = product.price
            holder.tvDetail.text = product.detail

            holder.btnFavorite.setOnClickListener { Toast.makeText(holder.itemView.context, "Favorite " + listProduct[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }
            holder.btnShare.setOnClickListener { Toast.makeText(holder.itemView.context, "Share " + listProduct[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }

            val Mcontext = holder.itemView.context
            holder.itemView.setOnClickListener {
                val intent = Intent(Mcontext, DetailProductAcitvity::class.java)
                intent.putExtra(DetailProductAcitvity.EXTRA_NAME, product.name)
                intent.putExtra(DetailProductAcitvity.EXTRA_PRICE, product.price)
                intent.putExtra(DetailProductAcitvity.EXTRA_IMG, product.Photo)
                intent.putExtra(DetailProductAcitvity.EXTRA_DETAIL, product.detail)
                Mcontext.startActivity(intent)
            }

    }
}