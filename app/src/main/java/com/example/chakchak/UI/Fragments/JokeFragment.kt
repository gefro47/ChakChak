package com.example.chakchak.UI.Fragments

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chakchak.Api.ChakChakApi
import com.example.chakchak.R
import com.example.chakchak.databinding.FragmentJokeBinding
import com.example.chakchak.model.ChakChakJoke
import com.example.chakchak.utilits.hideKeyboard
import com.example.chakchak.utilits.initRecyclerViewForCheck
import com.example.chakchak.utilits.showToast
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext





class JokeFragment : Fragment(R.layout.fragment_joke) {
    private var _binding: FragmentJokeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJokeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onResume() {
        super.onResume()
        var list: ArrayList<ChakChakJoke>
        binding.reload.setOnClickListener {
            if (binding.editText.text.toString() == "" ||
                binding.editText.text.toString() == "0"){
                showToast("You must enter a value greater than 0!")
            }else {
                GlobalScope.launch(Main) {
                    withContext(IO) {
                        list = ChakChakApi().GetJokes(
                            binding.editText.text.toString().toInt()
                        )?.value!!
                    }
                    withContext(Main) {
                        initRecyclerViewForCheck(binding.recycler, requireContext(), list)
                    }
                }
            }
        }
        binding.editText.setOnKeyListener(View.OnKeyListener{ v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP){
                hideKeyboard()
                return@OnKeyListener true
            }
            false
        })
    }
}