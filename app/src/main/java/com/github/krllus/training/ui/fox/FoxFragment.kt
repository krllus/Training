package com.github.krllus.training.ui.fox

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import coil.api.load
import com.github.krllus.training.R
import com.github.krllus.training.dagger.Injectable
import com.github.krllus.training.data.FoxRepository
import com.github.krllus.training.viewmodels.FoxViewModel
import com.github.krllus.training.viewmodels.FoxViewModelFactory
import javax.inject.Inject

class FoxFragment : Fragment(), Injectable {

    companion object {
        const val FOX_ID = "foxId"

        fun newInstance(foxId: String) = FoxFragment().apply {
            arguments = Bundle().apply {
                putString(FOX_ID, foxId)
            }
        }
    }

    @Inject
    lateinit var foxRepository: FoxRepository

    val foxViewModelFactory: FoxViewModelFactory by lazy {
        FoxViewModelFactory(foxRepository)
    }

    private val foxViewModel: FoxViewModel by lazy {
        ViewModelProvider(this, foxViewModelFactory)
            .get(FoxViewModel::class.java)
    }

    private val retrievedFoxId: String by lazy {
        arguments?.getString(FOX_ID) ?: "1"
    }

    private lateinit var txtFoxLabel: TextView
    private lateinit var imgFox: ImageView
    private lateinit var btnPrevious: Button
    private lateinit var btnRandom: Button
    private lateinit var btnNext: Button

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fox_fragment, container, false)

        txtFoxLabel = view.findViewById(R.id.fox_label)
        imgFox = view.findViewById(R.id.fox_image_view)
        btnPrevious = view.findViewById(R.id.button_previous)
        btnRandom = view.findViewById(R.id.button_random)
        btnNext = view.findViewById(R.id.button_next)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // initial image
        imgFox.load(R.drawable.placeholder_fox)

        foxViewModel.apply {
            setFoxId(retrievedFoxId)
            fox.observe(viewLifecycleOwner) {
                if (it != null) {
                    imgFox.load(it.image) {
                        crossfade(true)
                        placeholder(R.drawable.placeholder_fox)
                    }
                } else {
                    Log.d("log_tag", "fox is null")
                }
            }
        }
    }

}


