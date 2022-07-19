package com.example.sharedviewmodeldemo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.lifecycle.ViewModelProvider
import com.example.sharedviewmodeldemo.R
import com.example.sharedviewmodeldemo.databinding.FragmentWebViewBinding
import com.example.sharedviewmodeldemo.viewmodel.SharedViewModel

class WebViewFragment : Fragment() {
    private lateinit var binding: FragmentWebViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWebViewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        viewModel.urlLiveData.observe(viewLifecycleOwner){
            binding.webviewScreen.apply {
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
            }
            binding.webviewScreen.loadUrl(it)
        }
    }
}