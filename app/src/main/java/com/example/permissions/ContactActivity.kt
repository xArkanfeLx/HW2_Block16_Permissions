package com.example.permissions

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.permissions.databinding.ActivityContactBinding

class ContactActivity : AppCompatActivity() {

    private lateinit var binding:ActivityContactBinding
    private val contacts = mutableListOf(
        Contact("Иван","89010000001"),
        Contact("Машка","89010000002"),
        Contact("Толян","89010000003"),
        Contact("Сервис","89010000004"),
        Contact("Петя","89010000005"),
        Contact("Марк","89010000006")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(findViewById(R.id.toolbarTB))

        binding.recyclerRV.layoutManager = LinearLayoutManager(this@ContactActivity)
        binding.recyclerRV.adapter = CustomAdapter(contacts)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}