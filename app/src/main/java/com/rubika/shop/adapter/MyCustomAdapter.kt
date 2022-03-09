package com.rubika.shop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.rubika.shop.adapter.databinding.ItemShopBinding


class MyCustomAdapter(private val list: List<RowItems>) :
    RecyclerView.Adapter<MyCustomAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyCustomAdapter.CustomViewHolder {

        val itemBinding =
            ItemShopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: MyCustomAdapter.CustomViewHolder, position: Int) {
        holder.bind(list[position])//3

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class CustomViewHolder(private val itemShopBinding: ItemShopBinding) :
        RecyclerView.ViewHolder(itemShopBinding.root) {
        fun bind(rowItems: RowItems) {
            itemShopBinding.llRowItems.orientation = LinearLayout.HORIZONTAL
            if (rowItems.rowItems.isNotEmpty()) {
                for (i in 0 until rowItems.rowItems.size) {

                    val imageView = ImageView(itemShopBinding.root.context)
                    val lp = LinearLayout.LayoutParams(
                        getWidthOfItem()  ,
                        getWidthOfItem()
                    )
                    if (i == 0 ) {
                        lp.setMargins(
                            Constants.MARGIN_HORIZONTAL_VALUE,
                            Constants.MARGIN_VERTICAL_VALUE,
                            Constants.MARGIN_VERTICAL_VALUE/2,
                            Constants.MARGIN_VERTICAL_VALUE
                        )
                    }else if(i == rowItems.rowItems.size){
                        lp.setMargins(
                            0,
                            Constants.MARGIN_VERTICAL_VALUE,
                            Constants.MARGIN_HORIZONTAL_VALUE,
                            Constants.MARGIN_VERTICAL_VALUE
                        )
                    } else
                    {
                        lp.setMargins(
                            Constants.MARGIN_HORIZONTAL_VALUE/2,
                            Constants.MARGIN_VERTICAL_VALUE,
                            Constants.MARGIN_HORIZONTAL_VALUE/2,
                            Constants.MARGIN_VERTICAL_VALUE
                        )
                    }
//
                    imageView.layoutParams = lp;
                    imageView.setImageResource(rowItems.rowItems[i].imageSource)
                    itemShopBinding.llRowItems.addView(imageView)
                }
            }

        }

        private fun getWidthOfItem(): Int {

            return (Constants.SCREEN_WIDTH - getTotalHorizontalMargin()) / Constants.COLUMNS_VALUE
        }
        private fun getTotalHorizontalMargin(): Int {
            return (Constants.COLUMNS_VALUE+1)*Constants.MARGIN_HORIZONTAL_VALUE
        }

        private fun getMarginOfItem(): Int {
            return Constants.MARGIN_HORIZONTAL_VALUE
        }
    }

}