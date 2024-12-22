package com.example.permissions

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.permissions.databinding.ActivityMainBinding
import android.Manifest
import android.content.Intent
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbarTB)

        binding.cameraBTN.setOnClickListener {
            val permission = Manifest.permission.CAMERA
            permissionLauncherCamera.launch(permission)
        }
        binding.contactsBTN.setOnClickListener {
            val permission = Manifest.permission.READ_CONTACTS
            permissionLauncherContacts.launch(permission)
        }
    }

    private val permissionLauncherCamera = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            cameraPermissionGranted()
        } else {
            Toast.makeText(this@MainActivity, "Отказано -> камера", Toast.LENGTH_SHORT).show()
        }
    }
    private val permissionLauncherContacts = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            contactPermissionGranted()
        } else {
            Toast.makeText(this@MainActivity, "Отказано -> контакты", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cameraPermissionGranted() {
        startActivity(Intent(this, CameraActivity::class.java))
    }
    private fun contactPermissionGranted() {
        startActivity(Intent(this, ContactActivity::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finishAffinity()
        return super.onOptionsItemSelected(item)
    }
}