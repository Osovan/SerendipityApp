package com.osovan.serendipityapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.osovan.serendipityapp.databinding.ViewNookItemBinding

interface NookClickedListener {
    fun onNookClicked(nook: Nook)
}

class NooksAdapter(
    private val nooks: List<Nook>,
    private val nookClickedListener: NookClickedListener
) : RecyclerView.Adapter<NooksAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_nook_item, parent, false)

        val view = ViewNookItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nook = nooks[position]
        holder.bind(nook)
        holder.itemView.setOnClickListener {
            nookClickedListener.onNookClicked(nook)
        }
    }

    override fun getItemCount(): Int {
        return nooks.size
    }

    class ViewHolder(private val binding: ViewNookItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(nook: Nook) {
            binding.nameNook.text = nook.name
            Glide.with(binding.root.context)
                .load(nook.cover)
                .into(binding.pictureNook)
        }
    }

}
