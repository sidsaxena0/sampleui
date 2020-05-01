package com.sid.testapp.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sid.testapp.R
import com.sid.testapp.databinding.AvatarLayoutBinding
import com.sid.testapp.model.Suggestion


public class AvatarAdapter : RecyclerView.Adapter<AvatarAdapter.HelpViewHolder>(), ClickListener {
    private var suggestions: List<Suggestion>? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): HelpViewHolder {
        val helpLayoutBinding: AvatarLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.avatar_layout,
            viewGroup,
            false
        )
        return HelpViewHolder(helpLayoutBinding)
    }

    override fun onBindViewHolder(helpViewHolder: HelpViewHolder, i: Int) {
        //set bindings data
        val question: Suggestion = suggestions!![i]
        helpViewHolder.avatarLayoutBinding.suggestion = question
        helpViewHolder.avatarLayoutBinding.listener = this
    }

    override fun getItemCount(): Int {
        return if (suggestions != null) {
            suggestions!!.size
        } else {
            0
        }
    }

    fun setSuggestions(questions: List<Suggestion>?) {
        // new data received set and notify
        this.suggestions = questions
        notifyDataSetChanged()
    }

    inner class HelpViewHolder(var avatarLayoutBinding: AvatarLayoutBinding) :
        RecyclerView.ViewHolder(avatarLayoutBinding.root) {
    }

    override fun click(view: View, suggestion: Suggestion?) {

        // Handle click on avatar view

        if (suggestion != null) {
            val intent = Intent(view?.context, ProfileActivity::class.java)
            intent.putExtra("id", suggestion.id)
            view?.context?.startActivity(intent)
        }
    }


}