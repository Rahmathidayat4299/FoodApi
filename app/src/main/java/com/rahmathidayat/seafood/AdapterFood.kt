package com.rahmathidayat.seafood

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rahmathidayat.seafood.databinding.ItemListfoodBinding
import com.rahmathidayat.seafood.model.Meal
import com.rahmathidayat.seafood.model.ModelFood

class AdapterFood : RecyclerView.Adapter<AdapterFood.ListViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null
    private var listUser = ArrayList<Meal>()
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    private var onClickListener: OnClickListener? = null

    private val differCallback = object : DiffUtil.ItemCallback<Meal>() {
        override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return oldItem.idMeal == newItem.idMeal
        }

        override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return oldItem == newItem
        }


    }
    val differ = AsyncListDiffer(this, differCallback)


    inner class ListViewHolder(val binding: ItemListfoodBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(users: Meal) {

            binding.apply {
                name.text = users.strMeal
                username.text = users.idMeal.toString()
            }
            Glide.with(itemView.context)
                .load(users.strMealThumb)
                .apply(RequestOptions.circleCropTransform())
                .into(binding.imageUser)


//            itemView.setOnClickListener {
//                val intent = Intent(itemView.context, DetailUser::class.java)
//                intent.putExtra(DetailUser.USERNAME_GITHUB, users.login)
//                itemView.context.startActivity(intent)
//            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ItemListfoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        holder.bind(differ.currentList[position])
    }


    override fun getItemCount(): Int = differ.currentList.size

    interface OnClickListener {
        fun onClick(item: Meal)
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnItemClickCallback {
        fun onItemClik(data: ModelFood)
    }

}