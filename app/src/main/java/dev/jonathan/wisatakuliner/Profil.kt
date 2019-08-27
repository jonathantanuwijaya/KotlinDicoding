package dev.jonathan.wisatakuliner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profil.*

class Profil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        ivUser.setImageResource(R.drawable.imguser)
        tvNamaDevs.text = "Jonathan Tanuwijaya"
        tvEmailDevs.text = "jonathantanuwijaya0604@gmail.com"
    }
}
