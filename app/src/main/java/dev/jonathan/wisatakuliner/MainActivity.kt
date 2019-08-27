package dev.jonathan.wisatakuliner

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_list.view.*


class MainActivity : AppCompatActivity() {
    var listmenu = ArrayList<MenuMakanan>()
    var adapter: AdapterMakanan? = null
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.mainmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startActivity(Intent(this, Profil::class.java))
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listmenu.add(
            MenuMakanan(
                "Pempek",
                "Pempek Adalah Makanan Khas Palembang yang sudah sangat populer di Indonesia",
                "15000",
                "Makanan Khas Palembang yang lezat",
                "Palembang",
                R.drawable.gambarpempek
            )
        )
        listmenu.add(
            MenuMakanan(
                "Nasi Padang",
                "Nasi Padang Adalah Makanan Khas Padang yang sangat populer di Indonesia",
                "18000",
                "Makanan Khas Padang yang lezat dan gurih",
                "Padang",
                R.drawable.nasipadang
            )
        )
        listmenu.add(
            MenuMakanan(
                "Baso ",
                "Baso Adalah Makanan yang sangat populer di Indonesia",
                "10000",
                "Makanan Khas Jakarta yang sudah sangat familiar bagi semua orang",
                "Jakarta",
                R.drawable.baso
            )
        )
        listmenu.add(
            MenuMakanan(
                "Sate",
                " Sate Adalah Makanan yang sangat populer di Indonesia",
                "12000",
                "Makanan Khas Medan yang lezat",
                "Medan",
                R.drawable.sate
            )
        )
        listmenu.add(
            MenuMakanan(
                "Kwetiau",
                "Kwetiau Adalah makanan yang sangat populer di Indonesia",
                "25000",
                "Makanan Khas Tiongkok yang lezat",
                "Tiongkok",
                R.drawable.kwetiau
            )
        )
        listmenu.add(
            MenuMakanan(
                "Mie Ayam",
                "Mie Ayam Adalah Makanan yang sangat populer di Indonesia",
                "15000",
                "Makanan yang dapat ditemui diseluruh Indonesia",
                "Indonesia",
                R.drawable.mieayam
            )
        )
        listmenu.add(
            MenuMakanan(
                "Nasi Goreng",
                "Nasi Goreng Adalah Makanan yang sangat populer di Indonesia",
                "15000",
                "Makanan Lezat yang dapat ditemukan di seluruh indonesia",
                "Indonesia",
                R.drawable.nasigoreng
            )
        )
        listmenu.add(
            MenuMakanan(
                "Ubi Cilembu",
                "Ubi Cilembu adalah makanan tradisional yang lezat",
                "15000",
                "Makanan Tradisional dari Ubi",
                "Surabaya",
                R.drawable.ubicilembu
            )
        )
        listmenu.add(
            MenuMakanan(
                "Martabak Bangka ",
                "Martabak Bangka Adalah Makanan Khas Bangka Belitung yang sudah sangat populer di Indonesia",
                "15000",
                "Makanan Khas Bangka Belitung yang lezat",
                "Bangka Belitung",
                R.drawable.martabakbangka
            )
        )
        listmenu.add(
            MenuMakanan(
                "Martabak India",
                "Martabak India Adalah Makanan Khas India yang sudah sangat populer di Indonesia",
                "15000",
                "Makanan Khas India yang lezat",
                "India",
                R.drawable.martabakindia
            )
        )
        listmenu.add(
            MenuMakanan(
                "Roti Canai",
                "Roti Canai Adalah Makanan Khas India yang sudah sangat populer di Indonesia",
                "15000",
                "Makanan Khas India yang lezat",
                "India",
                R.drawable.roticanai
            )
        )
        adapter = AdapterMakanan(this, listmenu)
        gvListMakanan.adapter = adapter
    }

    inner class MenuMakanan {
        var nama: String? = null
        var deskripsi: String? = null
        var harga: String? = null
        var descSingkat: String? = null
        var asaldaerah: String? = null
        var gambar: Int? = null

        constructor(
            nama: String?,
            deskripsi: String?,
            harga: String?,
            descSingkat: String?,
            asaldaerah: String?,
            gambar: Int?
        ) {
            this.nama = nama
            this.deskripsi = deskripsi
            this.harga = harga
            this.descSingkat = descSingkat
            this.asaldaerah = asaldaerah
            this.gambar = gambar
        }
    }

    inner class AdapterMakanan : BaseAdapter {
        var listMakanan = ArrayList<MenuMakanan>()
        var context: Context? = null

        constructor(context: Context, listMakanan: ArrayList<MenuMakanan>) : super() {
            this.listMakanan = listMakanan
            this.context = context
        }


        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val makanan = this.listMakanan[p0]
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.row_list, null)

            foodView.ivGambarMakanan.setImageResource(makanan.gambar!!)
            foodView.ivGambarMakanan.setOnClickListener {
                //
                val intent = Intent(context, DetailMakanan::class.java)
                intent.putExtra("nama", makanan.nama!!)
                intent.putExtra("deskripsi", makanan.deskripsi!!)
                intent.putExtra("descsingkat", makanan.descSingkat!!)
                intent.putExtra("asaldaerah", makanan.asaldaerah!!)
                intent.putExtra("harga", makanan.harga!!)
                intent.putExtra("gambar", makanan.gambar!!)
                context!!.startActivity(intent)
            }
            foodView.tvNamaMakanan.text = makanan.nama!!
            foodView.HargaMakanan.text = "Harga : " + makanan.harga!!
            return foodView

        }

        override fun getItem(p0: Int): Any {
            return listMakanan[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listMakanan.size
        }

    }
}


