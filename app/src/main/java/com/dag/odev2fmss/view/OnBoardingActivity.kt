package com.dag.odev2fmss.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dag.odev2fmss.R
import com.dag.odev2fmss.databinding.ActivityOnBoardingBinding
import com.dag.odev2fmss.viewmodel.OnBoardingActivityViewModel


class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding
    private lateinit var myIntent: Intent
    private lateinit var viewModel: OnBoardingActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[OnBoardingActivityViewModel::class.java]

        binding = DataBindingUtil.setContentView(this, R.layout.activity_on_boarding)

        myIntent = Intent(this, LoginActivity::class.java)

        /**
         *  Actions(start Login activity with animation) to be taken when clicking the button
         */
        binding.btnJoinNow.setOnClickListener {
           startActivity(myIntent)
           overridePendingTransition(R.anim.slide_up, R.anim.no_animation)
        }
    }

}