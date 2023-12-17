package fastcampus.part3.part3chapter5.model

import java.util.Date

//데이터 형태의 인터페이스
interface ListItem {
    val thumbnailUrl : String
    val dateTime : Date
    var isFavorite : Boolean
}