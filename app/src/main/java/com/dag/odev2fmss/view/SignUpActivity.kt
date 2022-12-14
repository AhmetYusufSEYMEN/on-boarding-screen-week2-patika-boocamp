package com.dag.odev2fmss.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dag.odev2fmss.R
import com.dag.odev2fmss.databinding.ActivitySignUpBinding
import com.dag.odev2fmss.viewmodel.SignUpActivityViewModel

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: SignUpActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[SignUpActivityViewModel::class.java]

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        binding.apply {

            /**
             *  Actions(back to Login activity) to be taken when clicking the button
             */
            btnBackSignUp.setOnClickListener {
                onBackPressed()
                overridePendingTransition(R.anim.no_animation, R.anim.slide_down)
            }

            /**
             * textwatcher applied to edittexts
             */
            edtxEmail.addTextChangedListener(textWatcherEmail)
            edtxUserName.addTextChangedListener(textWatcherUser)
            edtxPassword.addTextChangedListener(textWatcherPass)

            btnSignUp.setOnClickListener {
                showUserInfo()
            }
        }
    }

    /**
     * check editext for not empty
     * showing data on toast
     * changing the button text
     */
    private fun showUserInfo(){
        binding.apply {
            if(edtxEmail.text.toString().isNotEmpty() && edtxUserName.text.toString().isNotEmpty() && edtxPassword.text.toString().isNotEmpty()){
                Toast.makeText(this@SignUpActivity,
                    "Email: ${edtxEmail.text.toString()} " +
                            "Username: ${edtxUserName.text.toString()} " +
                            "Password: ${edtxPassword.text.toString()}", Toast.LENGTH_LONG).show()
                btnSignUp.text = getString(R.string.success)
            }
            else {
                toastFun(getString(R.string.tst_login_failed))
                btnSignUp.text = getString(R.string.failed)
            }
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
            if (binding.edtxEmail.text.toString().isEmpty()) {
                binding.edtxEmail.error = getString(R.string.error)
            }
        }
    }

    /**
     * Object created to warn if edittext is empty
     */
    private val textWatcherUser = object : TextWatcher {

        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (binding.edtxUserName.text.toString().isEmpty()) {
                binding.edtxUserName.error = getString(R.string.error)
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
            if (binding.edtxPassword.text.toString().isEmpty()) {
                binding.edtxPassword.error = getString(R.string.error)
            }
            if (binding.edtxPassword.text.toString().length == 15) {
                toastFun(getString(R.string.tst_maxChar))
            }
        }
    }

    /**
     * A toast fun to avoid code clutter
     *
     * @param text text to show in toast
     */
    private fun toastFun(text: String){
        Toast.makeText(this@SignUpActivity, text, Toast.LENGTH_SHORT).show()
    }
}