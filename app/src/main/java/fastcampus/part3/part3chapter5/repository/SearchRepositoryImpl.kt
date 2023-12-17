package fastcampus.part3.part3chapter5.repository

import fastcampus.part3.part3chapter5.SearchService
import fastcampus.part3.part3chapter5.model.ListItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

//Repository 를 거치면 -> Observable<List<ListItem>> 이 나온다 => 저장해야하는(가지고있어야하는) 데이터
class SearchRepositoryImpl(private val searchService: SearchService) : SearchRepository {
    override fun search(query: String): Observable<List<ListItem>> {
        return searchService.searchImage(query)
            .zipWith(searchService.searchVideo(query)) { imageResult,videoResult ->
            mutableListOf<ListItem>().apply {
                    addAll(imageResult.documents)
                    addAll(videoResult.documents)
                }.sortedBy { it.dateTime }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}