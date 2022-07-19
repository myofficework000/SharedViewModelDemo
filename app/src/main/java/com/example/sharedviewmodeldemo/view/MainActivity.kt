package com.example.sharedviewmodeldemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedviewmodeldemo.R
import com.example.sharedviewmodeldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.webview_fragment, WebViewFragment())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.url_fragment, UrlListFragment())
            .commit()
    }
}