package fastcampus.part3.part3chapter5.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import fastcampus.part3.part3chapter5.databinding.ItemImageBinding
import fastcampus.part3.part3chapter5.databinding.ItemVideoBinding
import fastcampus.part3.part3chapter5.list.ItemHandler
import fastcampus.part3.part3chapter5.model.ImageItem
import fastcampus.part3.part3chapter5.model.ListItem
import fastcampus.part3.part3chapter5.model.VideoItem

class VideoViewHolder(
    private  val binding: ItemVideoBinding,
    private val itemHandler: ItemHandler? = null
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item : ListItem){
        item as VideoItem
        binding.item = item
        binding.handler = itemHandler
    }
}