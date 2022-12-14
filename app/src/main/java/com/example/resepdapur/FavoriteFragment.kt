package com.example.resepdapur

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resepdapur.Adapter.AdapterFavorite
import com.example.resepdapur.Adapter.AdapterlistItem

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoriteFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var rvItem : RecyclerView
    private lateinit var foodArrayList : ArrayList<ItemViewModel>

    lateinit var image : Array<Int>
    lateinit var foodname: Array<String>
    lateinit var desc: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvItem = view.findViewById(R.id.rvFavorite)
        rvItem.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        foodArrayList = arrayListOf<ItemViewModel>()
        image = arrayOf(R.drawable.logo,
            R.drawable.logo,
            R.drawable.user,
            R.drawable.logo)

        foodname = arrayOf("Kacang Ijo",
            "Kacang merah",
            "Kacang kuning",
            "Kacang Ijo")

        desc = arrayOf("ini adalah makanan yang enak"
            ,"ini adalah makanan yang enak"
            ,"ini adalah makanan yang enak"
            ,"ini adalah makanan yang enak")

        for (i in image.indices){
            val food = ItemViewModel(image[i], foodname[i], desc[i])
            foodArrayList.add(food)
        }
        val adapter = AdapterFavorite(foodArrayList)
        rvItem.adapter = adapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FavoriteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavoriteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}