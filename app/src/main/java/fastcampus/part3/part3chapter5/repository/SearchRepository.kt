package fastcampus.part3.part3chapter5.repository

import fastcampus.part3.part3chapter5.model.ListItem
import io.reactivex.rxjava3.core.Observable

interface SearchRepository {
    fun search(query: String): Observable<List<ListItem>>
}