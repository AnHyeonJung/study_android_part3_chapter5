package fastcampus.part3.part3chapter5.list

import fastcampus.part3.part3chapter5.model.ListItem

interface ItemHandler {
    fun onClickFavorite(item: ListItem) //액티비티에서 콜백용 인듯?
}