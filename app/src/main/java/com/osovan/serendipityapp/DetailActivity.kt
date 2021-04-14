package com.osovan.serendipityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
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
            //set title to bar
            title = nook.name

            Glide.with(this)
                .load(nook.cover)
                .into(binding.photoNook)

            binding.descriptionDetail.text = nook.description
            binding.locationDetail.text = nook.location
        }
    }
}