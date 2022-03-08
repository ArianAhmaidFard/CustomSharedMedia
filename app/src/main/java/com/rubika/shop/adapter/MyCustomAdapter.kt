package com.rubika.shop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.rubika.shop.adapter.databinding.ItemShopBinding

class MyCustomAdapter(private val list:List<RowItems>):
    RecyclerView.Adapter<MyCustomAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCustomAdapter.CustomViewHolder {

        val itemBinding = ItemShopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: MyCustomAdapter.CustomViewHolder, position: Int) {
        holder.bind(list[position])


    }

    override fun getItemCount(): Int {
        return  list.size
    }

    class CustomViewHolder(private val itemShopBinding: ItemShopBinding) :RecyclerView.ViewHolder(itemShopBinding.root){
        fun bind(rowItems: RowItems){
            itemShopBinding.llRowItems.orientation = LinearLayout.HORIZONTAL
            for(i in 0 until rowItems.rowItems.size){
                val imageView=ImageView(itemShopBinding.root.context)
                imageView.layoutParams = LinearLayout.LayoutParams(getWidthOfItem(),getWidthOfItem())
                imageView.x= Constants.MARGIN_VALUE.toFloat()
                imageView.y= Constants.MARGIN_VALUE.toFloat()
                imageView.setImageResource(rowItems.rowItems[i].imageSource)
                itemShopBinding.llRowItems.addView(imageView)
            }
        }
        private fun getWidthOfItem() :Int
        {
            return Constants.SCREEN_WIDTH/Constants.COLUMNS_VALUE
        }
        private fun getMarginOfItem():Int
        {
            return Constants.MARGIN_VALUE
        }
    }

}