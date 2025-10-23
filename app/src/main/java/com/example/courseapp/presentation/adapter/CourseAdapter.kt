package com.example.courseapp.presentation.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.courseapp.R
import com.example.courseapp.presentation.model.CourseUI
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

private const val PAYLOAD_LIKE = "payload_like"
class CoursesAdapter(
    private val onFavoriteClick: (CourseUI) -> Unit
) : ListAdapter<CourseUI, CoursesAdapter.ViewHolder>(CourseDiff) {

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val imgCourseImage = view.findViewById<ShapeableImageView>(R.id.image_view_courseImage)
        private val txtCourseTitle = view.findViewById<MaterialTextView>(R.id.text_view_courseTitle)
        private val txtCourseDescription = view.findViewById<MaterialTextView>(R.id.text_view_courseDescription)
        private val txtCourseRate = view.findViewById<MaterialTextView>(R.id.text_view_courseRate)
        private val txtStartDate = view.findViewById<MaterialTextView>(R.id.text_view_startDate)
        private val txtCoursePrice = view.findViewById<MaterialTextView>(R.id.text_view_coursePrice)

        private val btnFavorite = view.findViewById<ImageButton>(R.id.image_button_favorite)

        fun bind(item: CourseUI) {

            imgCourseImage.setImageResource(item.imageRes)

            txtCourseTitle.text = item.title
            txtCourseDescription.text = item.text
            txtCoursePrice.text = "${item.price} ₽"
            applyLike(item.hasLike)
            txtCourseRate.text = item.rate.toString()

            txtStartDate.text = item.startDate

            btnFavorite.setOnClickListener { onFavoriteClick(item) }
        }

        fun bindLikeOnly(hasLike: Boolean) = applyLike(hasLike)

        private fun applyLike(hasLike: Boolean) {
            val tint = if (hasLike) R.color.green else R.color.white
            (btnFavorite.drawable as? Drawable)?.setTint(view.context.getColor(tint))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.course_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.contains(PAYLOAD_LIKE)) {
            holder.bindLikeOnly(getItem(position).hasLike)
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    object CourseDiff : DiffUtil.ItemCallback<CourseUI>() {
        override fun areItemsTheSame(old: CourseUI, new: CourseUI) = old.id == new.id
        override fun areContentsTheSame(old: CourseUI, new: CourseUI) = old == new

        override fun getChangePayload(oldItem: CourseUI, newItem: CourseUI): Any? {
            return if (oldItem.hasLike != newItem.hasLike) PAYLOAD_LIKE else null
        }

    }

}