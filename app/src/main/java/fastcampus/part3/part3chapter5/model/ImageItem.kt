package fastcampus.part3.part3chapter5.model

import com.google.gson.annotations.SerializedName
import java.util.Date

//데이터의 형태(모델)
data class ImageListResponse(
    val documents : List<ImageItem>
)

data class ImageItem(
    @SerializedName("thumbnail_url") override val thumbnailUrl : String,
    @SerializedName("collection") val collection : String,
    @SerializedName("display_sitename") val siteName : String,
    @SerializedName("doc_url") val docUrl : String,
    @SerializedName("datetime") override val dateTime : Date,
    override var isFavorite: Boolean
) : ListItem
