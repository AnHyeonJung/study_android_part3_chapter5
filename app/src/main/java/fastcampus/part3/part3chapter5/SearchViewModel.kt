package fastcampus.part3.part3chapter5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fastcampus.part3.part3chapter5.model.ImageItem
import fastcampus.part3.part3chapter5.model.ListItem
import fastcampus.part3.part3chapter5.model.VideoItem
import fastcampus.part3.part3chapter5.repository.SearchRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable

//말그대로 ViewModel -> 매개변수로 Model(형태)틀을 가지고 있는 Repository(저장소)를 받아서 disposable 이용해서 내부 변수에 저장 시키는 용도
class SearchViewModel(private val searchRepository: SearchRepository) : ViewModel() {

    private val _listLiveData = MutableLiveData<List<ListItem>>()
    val listLiveData : LiveData<List<ListItem>> get() = _listLiveData

    private val _showLoading = MutableLiveData<Boolean>()
    val showLoading : LiveData<Boolean> get() = _showLoading

    private var disposable : CompositeDisposable? = CompositeDisposable()

    fun search(query : String) {
       disposable?.add(searchRepository.search(query)
           .doOnSubscribe{_showLoading.value = true}
           .doOnTerminate{_showLoading.value = false}
           .subscribe ({list ->
               _listLiveData.value = list
           },{
               _listLiveData.value = emptyList()
           })
       )
    }

    fun toggleFavorite(item:ListItem){
        _listLiveData.value = _listLiveData.value?.map {
            if(it == item){ //내가 하트 누른거랑 list중의 아이템이랑 같으면
                when(it){
                    is ImageItem -> {
                        it.copy(isFavorite = !item.isFavorite)
                    }
                    is VideoItem -> {
                        it.copy(isFavorite = !item.isFavorite)
                    }
                    else -> {
                        it
                    }
                }.also { changeItem ->
                    if(Common.favoritesList.contains(item)){
                        Common.favoritesList.remove(item)
                    }else{
                        Common.favoritesList.add(changeItem)
                    }
                }
            }else{
                it//다르면 그냥 그 아이템으로 세팅
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
        disposable = null
    }

    class SearchViewModelFactory(private val searchRepository: SearchRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SearchViewModel(searchRepository) as T
        }
    }
}