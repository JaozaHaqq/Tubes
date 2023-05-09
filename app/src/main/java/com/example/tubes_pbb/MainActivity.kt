package com.example.tubes_pbb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    val Datamahasiswa = listOf<DataModel>(
        DataModel(
            R.drawable. logo,
            title = "Perbedaan Telat Haid dengan Hamil",
            desc = "Perbedaan ini terjadi karena hormon antara ...",
        ),
        DataModel(
            R.drawable. logo,
            title = "4 Perbedaan Darah Implantasi dan Darah Haid",
            desc = "Ada beberapa macam perbedaan Darah ...",
        ),
        DataModel(
            R.drawable. logo,
            title = "Telat Haid Bukan Berarti Kamu Hamil!",
            desc = "Telat haid bukan karena sebagai tanda kita hamil namun ....",
        ),
        DataModel(
            R.drawable. logo,
            title = "Alasan Kamu Keram Tapi Gak Lagi Haid",
            desc = "Keram sering muncul dikarenakan faktor dan kondisi tertentu....",
        ),
        DataModel(
            R.drawable. logo,
            title = "Inilah Tanda Kamu Minggu Ini Mens!",
            desc = "Kita dapat memperkirakan minggu hari kita mens....",
        ),
        DataModel(
            R.drawable. logo,
            title = "Ciri-ciri Wanita Tanpa Rahim",
            desc = "Tidak semua wanita terlahir dengan rahim, berikut ciri - ciri ...",
        ),
        DataModel(
            R.drawable. logo,
            title = "Perut Kembung Tanda Gejala Kista",
            desc = "Kembung sering terjadi dikarenakan faktor berikut...",
        ),
        DataModel(
            R.drawable. logo,
            title = "Manfaat Minum Jus Alpukat Tiap Hari",
            desc = "Berikut manfaat buah alpukat antara lain ...",
        ),
        DataModel(
            R.drawable. logo,
            title = "Pyo",
            desc = "0001",
        ),
        DataModel(
            R.drawable. logo,
            title = "Pyo",
            desc = "0001",
        ),
        DataModel(
            R.drawable. logo,
            title = "Pyo",
            desc = "0001",
        ),

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        ShowGridMahasiswa()
        ShowCardMahasiswa()

    }


    private fun ShowCardMahasiswa() {
        recyclerView.layoutManager = GridLayoutManager (this, 2)
        val adapter = adapter_grid(this, Datamahasiswa) {}
        recyclerView.adapter = adapter
    }

    private fun ShowGridMahasiswa() {
        val adapter = adapter(grid_mhs = Datamahasiswa){

       }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter(Datamahasiswa){

        }
    }

}