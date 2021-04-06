package com.example.dreamcastleid

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailProductAcitvity : AppCompatActivity() {
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PRICE = "extra_price"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_IMG = "extra_img"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_product)


        val TvImg: ImageView = findViewById(R.id.img_detail)
        val Tvname:TextView = findViewById(R.id.name_detail)
        val Tvprice: TextView = findViewById(R.id.price_detail)
        val tvDetail: TextView = findViewById(R.id.desc_detail)

        val name = intent.getStringExtra(EXTRA_NAME)
        val price = intent.getStringExtra(EXTRA_PRICE)
        val desc = intent.getStringExtra(EXTRA_DETAIL)
        val img = intent.getIntExtra(EXTRA_IMG,0)


        Tvname.text = name
        Glide.with(this)
            .load(img)
            .apply(RequestOptions())
            .into(TvImg)
        Tvprice.text = price
        tvDetail.text = desc


    }
}