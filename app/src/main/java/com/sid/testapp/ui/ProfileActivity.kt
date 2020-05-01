package com.sid.testapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sid.testapp.R
import com.sid.testapp.databinding.ActivityMainBinding
import com.sid.testapp.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    lateinit var viewModel: ProfileViewModel
    lateinit var binding: ActivityProfileBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.getData(intent.getIntExtra("id", 1))
    }

}
