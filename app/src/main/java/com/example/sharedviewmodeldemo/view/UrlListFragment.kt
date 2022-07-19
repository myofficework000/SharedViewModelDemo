package com.example.sharedviewmodeldemo.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sharedviewmodeldemo.databinding.FragmentUrlListBinding
import com.example.sharedviewmodeldemo.model.Message
import com.example.sharedviewmodeldemo.viewmodel.SharedViewModel

class UrlListFragment : Fragment() {
    private lateinit var binding: FragmentUrlListBinding
    private lateinit var urlList: ArrayList<String>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        urlList = ArrayList()
        urlList.add("https://www.google.com/")
        urlList.add("https://www.facebook.com/")
        urlList.add("https://www.youtube.com/")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUrlListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        val adapter =
            ArrayAdapter<String>(view.context, android.R.layout.simple_list_item_1, urlList)
        binding.listviewUrl.adapter = adapter

        binding.listviewUrl.setOnItemClickListener { adapterView, view1, i, l ->
            val url = adapterView.getItemAtPosition(i).toString()
            viewModel.setUrl(Message(url))
        }
    }
}