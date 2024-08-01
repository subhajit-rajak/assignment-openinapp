package com.subhajitrajak.assignmentopeninapp.utils

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.subhajitrajak.assignmentopeninapp.R
import java.text.SimpleDateFormat

object HelperFunctions {
    fun Activity.toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
    fun Fragment.toast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
    fun showProgressDialog(context: Context, message: String): Dialog {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.dialog_loading, null)

        val lottieAnimationView: LottieAnimationView = view.findViewById(R.id.animationView)
        val textView: TextView = view.findViewById(R.id.textView)

        lottieAnimationView.setAnimation(R.raw.loading)
        lottieAnimationView.playAnimation()
        textView.text = message

        val dialog = AlertDialog.Builder(context)
            .setView(view)
            .setCancelable(false)
            .create()

        dialog.show()
        return dialog
    }
    fun ImageView.load(url: Any, placeholder: Drawable) {
        Glide.with(context)
            .setDefaultRequestOptions(RequestOptions().placeholder(placeholder))
            .load(url)
            .thumbnail(0.05f)
            .error(placeholder)
            .into(this)
    }
    fun formatDate(dateString: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val outputFormat = SimpleDateFormat("dd MMM yyyy")

        val date = inputFormat.parse(dateString) ?: return ""
        return outputFormat.format(date)
    }
    fun View.setOnClickThrottleBounceListener(throttleTime: Long = 600L, onClick: () -> Unit) {

        this.setOnClickListener(object : View.OnClickListener {

            private var lastClickTime: Long = 0
            override fun onClick(v: View) {
                context?.let {
                    v.bounce(context)
                    if (SystemClock.elapsedRealtime() - lastClickTime < throttleTime) return
                    else onClick()
                    lastClickTime = SystemClock.elapsedRealtime()
                }

            }
        })
    }
    fun View.bounce(context: Context, animDuration: Long = 500L) = run {
        this.clearAnimation()
        val animation = AnimationUtils.loadAnimation(context, R.anim.bounce)
            .apply {
                duration = animDuration
            }
        this.startAnimation(animation)
    }
    fun Context.copyToClipboard(text: String) {
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ClipData.newPlainText("text", text)
        } else {
            ClipData.newPlainText(null, text)
        }
        clipboardManager.setPrimaryClip(clipData)
    }
    fun showButtonDialog(context: Context, message: String, onButtonClick: () -> Unit): Dialog {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.dialog_error, null)
        val textView: TextView = view.findViewById(R.id.textView)
        val button: TextView = view.findViewById(R.id.button)
        textView.text = message
        val dialog = AlertDialog.Builder(context)
            .setView(view)
            .setCancelable(false)
            .create()
        button.setOnClickListener {
            onButtonClick()
            dialog.dismiss()
        }
        dialog.show()
        return dialog
    }
    fun parseData(dataString: String): Map<String, Double>? {
        return try {
            val map = mutableMapOf<String, Double>()
            val entries = dataString.removeSurrounding("{", "}").split(", ")

            for (entry in entries) {
                val (key, value) = entry.split("=")
                map[key.trim()] = value.trim().toDouble()
            }

            map
        } catch (e: Exception) {
            null
        }
    }

    val Any?.isNull get() = this == null
}