package com.merio.gradebook.data.database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.merio.gradebook.R
import com.merio.gradebook.ui.ListSubjectFragment

class GradebookAdapter(
    private val actionListener: ListSubjectFragment
) : RecyclerView.Adapter<GradebookAdapter.SubjectViewHolder>() {

    private val gradebookList: MutableList<GradeBook> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradebookAdapter.SubjectViewHolder {
        val subjectView = LayoutInflater.from(parent.context).inflate(R.layout.one_subject,
            parent, false
        )
        return SubjectViewHolder(subjectView)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
     //   val currentItem = gradebookList[position]
     //   holder.textItem.text = currentItem.subject
    }

    inner class SubjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
     //   val textItem: TextView = itemView.text

    }



    override fun getItemCount() = gradebookList.size

    fun addSubject(subject: List<GradeBook>) {
        gradebookList.clear()
        gradebookList.addAll(subject)
        notifyDataSetChanged()
    }

    inner class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

     //   val textItem: TextView = itemView.text_view
    }

}

