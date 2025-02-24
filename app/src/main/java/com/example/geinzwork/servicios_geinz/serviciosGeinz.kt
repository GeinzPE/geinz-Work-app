package com.geinzz.geinzwork.servicios_geinz


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.geinzz.geinzwork.R
import com.geinzz.geinzwork.adapterViewholder.adapterViewPager
import com.geinzz.geinzwork.databinding.ActivityServiciosGeinzBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDragHandleView

class serviciosGeinz : AppCompatActivity() {
    private lateinit var binding: ActivityServiciosGeinzBinding
    lateinit var bottomSheet: BottomSheetDragHandleView
    private lateinit var dialog: BottomSheetDialog
    private val categoriasTiendas = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiciosGeinzBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewPage=binding.viewPager
        val tableLayour=binding.tabLayout

        val adapter = adapterViewPager(supportFragmentManager)
        adapter.addFragmet(inicio_servicios_fragment(), "Servicios")
        adapter.addFragmet(servicios_activos(),"Servicios activos")

        viewPage.adapter=adapter
        tableLayour.setupWithViewPager(viewPage)

    }

}