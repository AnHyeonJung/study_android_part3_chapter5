package fastcampus.part3.part3chapter5

import fastcampus.part3.part3chapter5.model.ImageListResponse
import fastcampus.part3.part3chapter5.model.VideoListResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchService {

    @Headers("Authorization: KakaoAK 8c53e1af254672aa77afe0c55164e4eb")
    @GET("image")
    fun searchImage(@Query("query") query: String) : Observable<ImageListResponse>

    @Headers("Authorization: KakaoAK 8c53e1af254672aa77afe0c55164e4eb")
    @GET("vclip")
    fun searchVideo(@Query("query") query: String) : Observable<VideoListResponse>
}