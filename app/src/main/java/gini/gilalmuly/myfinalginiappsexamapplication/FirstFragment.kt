package gini.gilalmuly.myfinalginiappsexamapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import gini.gilalmuly.myfinalginiappsexamapplication.databinding.FragmentFirstBinding
import gini.gilalmuly.myfinalginiappsexamapplication.viewmodels.FirstFragmentViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


@AndroidEntryPoint
class FirstFragment(override val coroutineContext: CoroutineContext) : Fragment(), CoroutineScope {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    @OptIn(ObsoleteCoroutinesApi::class)
    private val vm by lazy {
        ViewModelProvider(this)[FirstFragmentViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //setObserver()

    }

    @OptIn(ObsoleteCoroutinesApi::class)
    private fun setObserver() {
        //todo:there is a problame with the view model
        binding.whetherSummery.text = vm.getVMWhether().toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}