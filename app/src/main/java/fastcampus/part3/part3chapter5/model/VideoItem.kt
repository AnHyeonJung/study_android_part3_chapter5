package fastcampus.part3.part3chapter5.model

import com.google.gson.annotations.SerializedName
import java.util.Date

//데이터의 형태(모델)
data class VideoListResponse(
    val documents : List<VideoItem>
)

data class VideoItem(
    @SerializedName("thumbnail") override val thumbnailUrl: String,
    @SerializedName("title") val title: String,
    @SerializedName("play_time") val playTime: Int,
    @SerializedName("author") val author: String,
    @SerializedName("datetime") override val dateTime: Date,
    override var isFavorite: Boolean = false  //왜 얘는 false기본값을 주는 걸까?
) : ListItem
