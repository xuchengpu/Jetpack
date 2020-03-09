package com.xuchengpu.jetpackdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.xuchengpu.jetpackdemo.MyApplication
import com.xuchengpu.jetpackdemo.bean.ItemBean
import com.xuchengpu.jetpackdemo.databinding.ActivityMainBinding
import com.xuchengpu.jetpackdemo.databinding.ItemRvMainBinding

/**
 * Created by 许成谱 on 2020/3/8 20:10.
 * qq:1550540124
 * for:热爱生活每一天！
 */
class FGMainAdapter(diffResult: DiffUtil.ItemCallback<ItemBean>) :
    PagedListAdapter<ItemBean, FGMainAdapter.ListViewHolder>(diffResult) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemRvMainBinding =
            ItemRvMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemRvMainBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ListViewHolder(private val binding: ItemRvMainBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemBean?) {
            binding.bean = item
            binding.listener = View.OnClickListener {
                Toast.makeText(
                    MyApplication.getContext(),
                    "点击了 item${item?.uid}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}