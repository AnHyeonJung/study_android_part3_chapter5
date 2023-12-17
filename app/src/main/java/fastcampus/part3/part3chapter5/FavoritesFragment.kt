package fastcampus.part3.part3chapter5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import fastcampus.part3.part3chapter5.databinding.FragmentFavoritesBinding
import fastcampus.part3.part3chapter5.list.ListAdapter

class FavoritesFragment : Fragment() {
    private var binding : FragmentFavoritesBinding? = null

    private val adapter by lazy { ListAdapter() }  //nullable 하게 만들었기 때문에 여기서는 핸들러 없어도됨
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentFavoritesBinding.inflate(inflater, container, false).apply {
            binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            recyclerView.adapter = adapter
        }
    }

    override fun onResume() {
        super.onResume()
        binding?.apply {
            if(Common.favoritesList.isEmpty()){
                emptyTextView.isVisible = true
                recyclerView.isVisible = false
            }else{
                emptyTextView.isVisible = false
                recyclerView.isVisible = true
            }
        }
        adapter.submitList(Common.favoritesList.sortedBy { it.dateTime })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}