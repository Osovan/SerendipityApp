package com.osovan.serendipityapp.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.osovan.serendipityapp.NookClickedListener
import com.osovan.serendipityapp.NooksAdapter
import com.osovan.serendipityapp.databinding.ActivityMainBinding
import com.osovan.serendipityapp.model.database.Nook
import com.osovan.serendipityapp.model.database.NookDao
import com.osovan.serendipityapp.model.database.NookDatabase
import com.osovan.serendipityapp.ui.detail.DetailActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {


    lateinit var nookDao: NookDao
    lateinit var nookList: List<Nook>
    lateinit var binding: ActivityMainBinding
    val nooksInitValues: List<Nook> =
        listOf(
            Nook(
                1,
                "Rincón 1",
                "https://loremflickr.com/320/240?lock=1",
                "descipción del rincón 1",
                "localización del rincón 1",
                4.2f
            ),
            Nook(
                2,
                "Rincón 2",
                "https://loremflickr.com/320/240?lock=2",
                "descipción",
                "localización",
                4.2f
            ),
            Nook(
                3,
                "Rincón 3",
                "https://loremflickr.com/320/240?lock=3",
                "descipción",
                "localización",
                4.2f
            ),
            Nook(
                4,
                "Rincón 4",
                "https://loremflickr.com/320/240?lock=4",
                "descipción",
                "localización",
                4.2f
            ),
            Nook(
                5,
                "Rincón 5",
                "https://loremflickr.com/320/240?lock=5",
                "descipción",
                "localización",
                4.2f
            ),
            Nook(
                6,
                "Rincón 6",
                "https://loremflickr.com/320/240?lock=6",
                "descipción",
                "localización",
                4.2f
            ),
            Nook(
                7,
                "Rincón 7",
                "https://loremflickr.com/320/240?lock=7",
                "descipción",
                "localización",
                4.2f
            ),
            Nook(
                8,
                "Rincón 8",
                "https://loremflickr.com/320/240?lock=8",
                "descipción",
                "localización",
                4.2f
            ),
            Nook(
                9,
                "Rincón 9",
                "https://loremflickr.com/320/240?lock=9",
                "descipción",
                "localización",
                4.2f
            ),
            Nook(
                10,
                "Rincón 10",
                "https://loremflickr.com/320/240?lock=10",
                "descipción",
                "localización",
                4.2f
            ),
            Nook(
                11,
                "Rincón 11",
                "https://loremflickr.com/320/240?lock=11",
                "descipción",
                "localización",
                4.2f
            ),
            Nook(
                12,
                "Rincón 12",
                "https://loremflickr.com/320/240?lock=12",
                "descipción",
                "localización",
                4.2f
            )
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nookDao = NookDatabase.getInstance(this).nookDao()

        fetchAll()
        binding.recyclerviewList.adapter = NooksAdapter(nookList,
            object : NookClickedListener {
                override fun onNookClicked(nook: Nook) {
                    navigateTo(nook)
                }
            }
        )
    }

    private fun fetchAll() {
        runBlocking {
            val job: Job = launch(context = Dispatchers.Default) {
                nookList = nookDao.getAll()
                if (nookList.isEmpty()) {
                    nookDao.insert(nooksInitValues)
                    nookList = nookDao.getAll()
                }
            }
            job.join()
        }
    }


    fun navigateTo(nook: Nook) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_NOOK, nook.id)
        startActivity(intent)
    }


}