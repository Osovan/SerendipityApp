package com.osovan.serendipityapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.osovan.serendipityapp.model.database.Nook
import com.osovan.serendipityapp.databinding.ActivityDetailBinding
import com.osovan.serendipityapp.model.database.NookDao
import com.osovan.serendipityapp.model.database.NookDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NOOK = "DetailActivity:nook"
    }

    lateinit var nook: Nook

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val nookDao: NookDao = NookDatabase.getInstance(this).nookDao()

        val nookId = intent.getIntExtra(EXTRA_NOOK, -1)


        if (nookId > 0) {
            GlobalScope.launch(Dispatchers.Main) {
                nook = nookDao.getById(nookId)

                title = nook.name

                Glide.with(applicationContext)
                    .load(nook.cover)
                    .into(binding.photoNook)

                binding.descriptionDetail.text = nook.description
                binding.locationDetail.text = nook.location

            }

        }
    }
}