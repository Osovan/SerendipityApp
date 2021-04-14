package com.osovan.serendipityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.osovan.serendipityapp.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NOOK = "DetailActivity:nook"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nook = intent.getParcelableExtra<Nook>(EXTRA_NOOK)
        if (nook != null) {
            binding.nameNookDetail.text = nook.name
        }
    }
}