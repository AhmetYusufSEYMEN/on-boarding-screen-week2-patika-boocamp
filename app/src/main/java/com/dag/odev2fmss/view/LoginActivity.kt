package com.dag.odev2fmss.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dag.odev2fmss.R
import com.dag.odev2fmss.databinding.ActivityLoginBinding
import com.dag.odev2fmss.model.Users
import com.dag.odev2fmss.viewmodel.LoginActivityViewModel


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var myIntent: Intent
    private lateinit var user: Users
    private lateinit var viewModel: LoginActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[LoginActivityViewModel::class.java]

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        user = Users("ahmet yusuf", "seymen")

        myIntent = Intent(this, SignUpActivity::class.java)

        /**
         *  Actions(start SignUp activity with animation) to be taken when clicking the button
         */
        binding.btnCreateNewAcc.setOnClickListener {
            startActivity(myIntent)
            overridePendingTransition(R.anim.slide_up, R.anim.no_animation)
        }

        /**
         *  Actions(back to Onboarding activity) to be taken when clicking the button
         */
        binding.btnBackLogin.setOnClickListener {
            onBackPressed()
            overridePendingTransition(R.anim.no_animation, R.anim.slide_down)
        }

        /**
         * textwatcher applied to edittexts
         */
        binding.edtxEmailLogin.addTextChangedListener(textWatcherEmail)
        binding.edtxPasswordLogin.addTextChangedListener(textWatcherPass)

        binding.btnLogin.setOnClickListener {
            checkData()
        }
    }

    /**
     * checking username and password,
     * showing toast
     * changing the button text
     */
    private fun checkData(){
        if (binding.edtxEmailLogin.text.toString().lowercase() == user.userName && binding.edtxPasswordLogin.text.toString().lowercase() == user.userPassword) {
            toastFun(getString(R.string.tst_login_success))
            binding.btnLogin.text = getString(R.string.success)
        } else {
            toastFun(getString(R.string.tst_login_failed))
            binding.btnLogin.text = getString(R.string.failed)
        }
    }

    /**
     *  Overriding onBackPressed method for add animation
     */
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.no_animation, R.anim.slide_down)
    }

    /**
     * Object created to warn if edittext is empty
     */
    private val textWatcherEmail = object : TextWatcher {

        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (binding.edtxEmailLogin.text.toString().isEmpty()) {
                binding.edtxEmailLogin.error = getString(R.string.error)
            }
        }
    }

    /**
     * Object created to warn if edittext is empty and checking password length
     */
    private val textWatcherPass = object : TextWatcher {

        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (binding.edtxPasswordLogin.text.toString().isEmpty()) {
                binding.edtxPasswordLogin.error = getString(R.string.error)
            }
            if (binding.edtxPasswordLogin.text.toString().length == 15) {
                toastFun(getString(R.string.tst_maxChar))
            }
        }
    }

    /**
     * A toast fun to avoid code clutter
     *
     * @param text text to show in toast
     */
   private fun toastFun(text: String) {
        Toast.makeText(this@LoginActivity, text, Toast.LENGTH_SHORT).show()
    }
}

