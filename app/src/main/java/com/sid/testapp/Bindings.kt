package com.sid.testapp


import android.view.View
import android.widget.*
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("icon")
fun loadImage(view: ImageView, imageUrl: String?) {
    if(!imageUrl.isNullOrBlank()){
        Glide.with(view.context)
            .load(imageUrl)
            .into(view)
    }

}

@BindingAdapter("text")
fun setIntText(view: TextView, text: Int) {
    view.text = text.toString()
}


@BindingAdapter("visible")
fun showView(view: View, value: Boolean?) {
    if (value != null) {
        view.visibility = if (value) View.VISIBLE else View.GONE
    }
}