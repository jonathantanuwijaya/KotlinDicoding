package dev.jonathan.wisatakuliner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail_makanan.*

class DetailMakanan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_makanan)
        val bundle = intent.extras
        ivlezat.setOnClickListener {
            Toast.makeText(this, "Ini Lezat", Toast.LENGTH_SHORT).show()
        }
        ivmakan.setOnClickListener {
            Toast.makeText(this, "Ini Kesukaanku", Toast.LENGTH_SHORT).show()
        }
        ivlucu.setOnClickListener {
            Toast.makeText(this, "Terbaik !! ", Toast.LENGTH_SHORT).show()
        }

        if (bundle != null) {
            ivGambar.setImageResource(bundle.getInt("gambar"))
            tvNama.text = bundle.getString("nama")
            tvDeskripsi.text = bundle.getString("deskripsi")
            tvHargaMakanan.text = "Harga : " + bundle.getString("harga")
            tvdeskmakanan.text = bundle.getString("descsingkat")
            tvasaldaerah.text = bundle.getString("asaldaerah")
        }
    }
}
