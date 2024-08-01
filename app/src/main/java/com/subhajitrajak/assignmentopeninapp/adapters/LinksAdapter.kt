package com.subhajitrajak.assignmentopeninapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.subhajitrajak.assignmentopeninapp.R
import com.subhajitrajak.assignmentopeninapp.databinding.ItemRvListBinding
import com.subhajitrajak.assignmentopeninapp.models.TopLink
import com.subhajitrajak.assignmentopeninapp.utils.HelperFunctions.copyToClipboard
import com.subhajitrajak.assignmentopeninapp.utils.HelperFunctions.formatDate
import com.subhajitrajak.assignmentopeninapp.utils.HelperFunctions.load
import com.subhajitrajak.assignmentopeninapp.utils.HelperFunctions.setOnClickThrottleBounceListener

class LinksAdapter(
    private val links: List<TopLink>,
    val context: Context,
) : RecyclerView.Adapter<LinksAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRvListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val link = links[position]
        holder.binding.imageView.load(link.original_image!!,context.resources.getDrawable(R.drawable.placeholder_image))
        holder.binding.linkName.text = link.title
        holder.binding.date.text = formatDate(link.created_at!!)
        holder.binding.clicks.text = link.total_clicks.toString()
        holder.binding.url.text = link.web_link
        holder.binding.copy.setOnClickThrottleBounceListener {
            context.copyToClipboard(link.web_link!!)
            Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT).show()
        }
    }

    inner class ViewHolder(val binding: ItemRvListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount() = links.size


}
