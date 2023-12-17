package fastcampus.part3.part3chapter5.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import fastcampus.part3.part3chapter5.databinding.ItemImageBinding
import fastcampus.part3.part3chapter5.list.ItemHandler
import fastcampus.part3.part3chapter5.model.ImageItem
import fastcampus.part3.part3chapter5.model.ListItem

class ImageViewHolder(
    private  val binding: ItemImageBinding,
    private val itemHandler: ItemHandler? = null  //추가
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item : ListItem){
        item as ImageItem
        binding.item = item
        binding.handler = itemHandler
    }
}