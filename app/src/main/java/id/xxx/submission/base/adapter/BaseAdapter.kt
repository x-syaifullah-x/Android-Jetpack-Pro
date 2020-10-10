package id.xxx.submission.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class BaseAdapter<Entity, ItemBinding : ViewDataBinding>(@LayoutRes private val itemLayout: Int) :
    RecyclerView.Adapter<BaseAdapter<Entity, ItemBinding>.Holder<ItemBinding>>() {

    var data: MutableList<Entity> = ArrayList()
    var onItemClicked: ItemClicked<Entity>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder<ItemBinding> {
        return Holder(LayoutInflater.from(parent.context).inflate(itemLayout, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun getItemId(position: Int): Long = position.toLong()

    inner class Holder<ItemBinding : ViewDataBinding>(itemView: View) : ViewHolder(itemView) {
        var binding = DataBindingUtil.bind<ItemBinding>(itemView)
    }
}