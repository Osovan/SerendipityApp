package com.osovan.serendipityapp

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
                Nook("Rincón 1", "https://loremflickr.com/320/240?lock=1"),
                Nook("Rincón 2", "https://loremflickr.com/320/240?lock=2"),
                Nook("Rincón 3", "https://loremflickr.com/320/240?lock=3"),
                Nook("Rincón 4", "https://loremflickr.com/320/240?lock=4"),
                Nook("Rincón 5", "https://loremflickr.com/320/240?lock=5"),
                Nook("Rincón 6", "https://loremflickr.com/320/240?lock=6"),
                Nook("Rincón 7", "https://loremflickr.com/320/240?lock=7"),
                Nook("Rincón 8", "https://loremflickr.com/320/240?lock=8"),
                Nook("Rincón 9", "https://loremflickr.com/320/240?lock=9"),
                Nook("Rincón 10", "https://loremflickr.com/320/240?lock=10"),
                Nook("Rincón 11", "https://loremflickr.com/320/240?lock=11"),
                Nook("Rincón 12", "https://loremflickr.com/320/240?lock=12")
            ),
            object : NookClickedListener {
                override fun onNookClicked(nook: Nook) {
                    Toast.makeText(this@MainActivity, nook.name, Toast.LENGTH_LONG).show()
                }
            }
        )
    }
}