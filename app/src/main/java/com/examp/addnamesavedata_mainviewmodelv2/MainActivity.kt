package com.examp.addnamesavedata_mainviewmodelv2

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.examp.addnamesavedata_mainviewmodelv2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.names.observe(this) { names ->
            binding.displayText.text = if (names.isEmpty()) {
                getString(R.string.no_names_to_display)
            } else {
                names.joinToString("\n")
            }
        }

        binding.addNameButton.setOnClickListener {
            val name = binding.nameInput.text.toString().trim()
            if (name.isNotEmpty()) {
                viewModel.addName(name)
                binding.nameInput.text.clear()
            } else {
                binding.displayText.text = getString(R.string.no_name_entered)
            }
        }
    }
}
