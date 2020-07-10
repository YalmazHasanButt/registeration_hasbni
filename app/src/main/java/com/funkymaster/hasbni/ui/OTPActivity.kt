package com.funkymaster.hasbni.ui

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.funkymaster.hasbni.R

class OTPActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var  one_view :TextView
    private lateinit var  cancel_view :ImageView
    private lateinit var  two_view :TextView
    private lateinit var  three_view :TextView
    private lateinit var  four_view :TextView
    private lateinit var  five_view :TextView
    private lateinit var  six_view :TextView
    private lateinit var  seven_view :TextView
    private lateinit var  eight_view :TextView
    private lateinit var  nine_view :TextView
    private lateinit var  zero_view :TextView
    private lateinit var otp_et1 :EditText
    private lateinit var otp_et2 :EditText
    private lateinit var otp_et3 :EditText
    private lateinit var otp_et4 :EditText
    private lateinit var verify_btn: Button






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide() //removing the title bar
        } catch (e: NullPointerException) {
        } //catch
        setContentView(R.layout.activity_otp)
        initialize_variables()
    } //on create

    fun initialize_variables(){
        one_view = findViewById(R.id.one_view)
        two_view = findViewById(R.id.two_view)
        three_view = findViewById(R.id.three_view)
        four_view = findViewById(R.id.four_view)
        five_view = findViewById(R.id.five_view)
        six_view = findViewById(R.id.six_view)
        seven_view = findViewById(R.id.seven_view)
        eight_view = findViewById(R.id.eight_view)
        nine_view = findViewById(R.id.nine_view)
        zero_view = findViewById(R.id.zero_view)
        otp_et1 = findViewById(R.id.otp_et1)
        otp_et2 = findViewById(R.id.otp_et2)
        otp_et3 = findViewById(R.id.otp_et3)
        otp_et4 = findViewById(R.id.otp_et4)
        cancel_view = findViewById(R.id.cancel_view)
        verify_btn = findViewById(R.id.verify_btn)
        otp_et1.addTextChangedListener(GenericTextWatcher(otp_et1, otp_et2));
        otp_et2.addTextChangedListener(GenericTextWatcher(otp_et2, otp_et3));
        otp_et3.addTextChangedListener(GenericTextWatcher(otp_et3, otp_et4));
        otp_et4.addTextChangedListener(GenericTextWatcher(otp_et4, null));

        otp_et1.requestFocus() //setting default focus to first edit text
        otp_et1.setInputType(InputType.TYPE_NULL); //hiding the keyboard
        otp_et2.setInputType(InputType.TYPE_NULL);
        otp_et3.setInputType(InputType.TYPE_NULL);
        otp_et4.setInputType(InputType.TYPE_NULL);
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.one_view->{
                set_value(1)
            }
            R.id.two_view->{
                set_value(2)
            }
            R.id.three_view->{
                set_value(3)
            }
            R.id.four_view->{
                set_value(4)
            }
            R.id.five_view->{
                set_value(5)
            }
            R.id.six_view->{
                set_value(6)
            }
            R.id.seven_view->{
                set_value(7)
            }
            R.id.eight_view->{
                set_value(8)
            }
            R.id.nine_view->{
                set_value(9)
            }
            R.id.zero_view->{
                set_value(0)
            }
            R.id.cancel_view-> {
                otp_et1.text = null
                otp_et2.text = null
                otp_et3.text = null
                otp_et4.text = null
                otp_et1.requestFocus() //setting focus on first box
                verify_btn.isClickable = false
            }
        } //where
    } //on click

    fun set_value(no: Int){
        //this function will set value to the edit text according to the number pressed
        if(otp_et1.hasFocus())
            otp_et1.setText(no.toString())
        else if(otp_et2.hasFocus())
            otp_et2.setText(no.toString())
        else if(otp_et3.hasFocus())
            otp_et3.setText((no.toString()))
        else if(otp_et4.hasFocus()) {
            otp_et4.setText(no.toString())
        }

        if(!otp_et1.equals("") && !otp_et2.equals("") && !otp_et3.equals("") && !otp_et4.equals(""))
            verify_btn.isClickable = true
    }   //set value

    class GenericTextWatcher internal constructor(private val currentView: View, private val nextView: View?) :
        TextWatcher {
        override fun afterTextChanged(editable: Editable) { // TODO Auto-generated method stub
            val text = editable.toString()
            when (currentView.id) {
                R.id.otp_et1 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.otp_et2 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.otp_et3 -> if (text.length == 1) nextView!!.requestFocus()
                //You can use EditText4 same as above to hide the keyboard
            }
        }

        override fun beforeTextChanged(
            arg0: CharSequence,
            arg1: Int,
            arg2: Int,
            arg3: Int
        ) { // TODO Auto-generated method stub
        }

        override fun onTextChanged(
            arg0: CharSequence,
            arg1: Int,
            arg2: Int,
            arg3: Int
        ) { // TODO Auto-generated method stub
        }

    }

}   //class otp activity