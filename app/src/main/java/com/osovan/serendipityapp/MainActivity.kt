package com.osovan.serendipityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.osovan.serendipityapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerviewList.adapter = NooksAdapter(
            listOf(
                Nook(1,"Rincón 1", "https://loremflickr.com/320/240?lock=1", "descipción", "localización", 4.2f),
                Nook(2,"Rincón 2", "https://loremflickr.com/320/240?lock=2","descipción", "localización", 4.2f),
                Nook(3,"Rincón 3", "https://loremflickr.com/320/240?lock=3","descipción", "localización", 4.2f),
                Nook(4,"Rincón 4", "https://loremflickr.com/320/240?lock=4","descipción", "localización", 4.2f),
                Nook(5,"Rincón 5", "https://loremflickr.com/320/240?lock=5","descipción", "localización", 4.2f),
                Nook(6,"Rincón 6", "https://loremflickr.com/320/240?lock=6","descipción", "localización", 4.2f),
                Nook(7,"Rincón 7", "https://loremflickr.com/320/240?lock=7","descipción", "localización", 4.2f),
                Nook(8,"Rincón 8", "https://loremflickr.com/320/240?lock=8","descipción", "localización", 4.2f),
                Nook(9,"Rincón 9", "https://loremflickr.com/320/240?lock=9","descipción", "localización", 4.2f),
                Nook(10,"Rincón 10", "https://loremflickr.com/320/240?lock=10","descipción", "localización", 4.2f),
                Nook(11,"Rincón 11", "https://loremflickr.com/320/240?lock=11","descipción", "localización", 4.2f),
                Nook(12,"Rincón 12", "https://loremflickr.com/320/240?lock=12","descipción", "localización", 4.2f)
            ),
            object : NookClickedListener {
                override fun onNookClicked(nook: Nook) { navigateTo(nook)
                }
            }
        )
    }

    fun navigateTo(nook: Nook){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_NOOK, nook)

        startActivity(intent)
    }

}