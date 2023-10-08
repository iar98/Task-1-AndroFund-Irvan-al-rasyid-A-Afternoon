package com.example.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.latihan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // binding
        binding.fragment1btn.setOnClickListener{
            replaceFragment(Fragment1())
        }

        // parcelable
        tv = findViewById(R.id.textView2)
        val username = intent.getParcelableExtra<User>("User")?.username
        val password = intent.getParcelableExtra<User>("User")?.password
        tv.text = "Username: $username dan password: $password"

        // intent implicit
        val btnImplicit: Button = findViewById(R.id.btn_implisit)
        btnImplicit.setOnClickListener(this)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_implisit -> {
                val intent = Intent()
                intent.putExtra("history", "Anda sudah login")
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}