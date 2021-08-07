package com.example.notes

import android.content.Context
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVadapter(val context: Context,val listener:INotesRVAdapter): RecyclerView.Adapter<NotesRVadapter.NoteViewHolder>() {
    val allNotes=ArrayList<Notes>()
    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView=itemView.findViewById<TextView>(R.id.text)
         val delete=itemView.findViewById<ImageView>(R.id.delete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
    val viewHolder=NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_notes,parent,false))
    viewHolder.delete.setOnClickListener{
        listener.onItemClicked(allNotes[viewHolder.adapterPosition])

    }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
 val currentNode=allNotes[position]
        holder.textView.text=currentNode.text
    }

    override fun getItemCount(): Int {
return allNotes.size
    }
    fun updateList(newList: List<Notes>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

}
interface INotesRVAdapter{
    fun onItemClicked(note:Notes)
}