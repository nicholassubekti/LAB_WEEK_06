package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.*

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) {
                showSelectionDialog(cat)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // swipe delete
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // set data 10 items
        catAdapter.setData(
    listOf(
        CatModel(Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly", "https://cdn2.thecatapi.com/images/7dj.jpg"),
        CatModel(Gender.Female, CatBreed.ExoticShorthair, "Wilma", "Cuddly assassin", "https://cdn2.thecatapi.com/images/egv.jpg"),
        CatModel(Gender.Unknown, CatBreed.AmericanCurl, "Curious George", "Award winning investigator", "https://cdn2.thecatapi.com/images/bar.jpg"),
        CatModel(Gender.Female, CatBreed.ExoticShorthair, "Luna", "Loves to sleep all day", "https://cdn2.thecatapi.com/images/9qi.jpg"),
        CatModel(Gender.Male, CatBreed.BalineseJavanese, "Simba", "King of the living room", "https://cdn2.thecatapi.com/images/c9d.jpg"),
        CatModel(Gender.Male, CatBreed.AmericanCurl, "Oscar", "Always curious and playful", "https://cdn2.thecatapi.com/images/6qi.jpg"),
        CatModel(Gender.Female, CatBreed.ExoticShorthair, "Misty", "Calm and gentle", "https://cdn2.thecatapi.com/images/bpc.jpg"),
        CatModel(Gender.Unknown, CatBreed.BalineseJavanese, "Shadow", "Appears out of nowhere", "https://cdn2.thecatapi.com/images/aqr.jpg"),
        // 🐈 Leo - ganti dengan gambar yang pasti aktif
        CatModel(Gender.Male, CatBreed.AmericanCurl, "Leo", "Fast and fearless", "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"),
        CatModel(Gender.Female, CatBreed.ExoticShorthair, "Cleo", "Elegant and smart", "https://cdn2.thecatapi.com/images/6dq.jpg")
    )
)



    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
