package com.ryunen344.selection.home

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.ryunen344.selection.model.Repository
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class RepositoryRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : RecyclerView(context, attrs, defStyle) {

    private val groupAdapter: GroupAdapter<GroupieViewHolder> by lazy { GroupAdapter<GroupieViewHolder>() }

    init {
        adapter = groupAdapter
    }

    var repositories: List<Repository>? = null
        set(value) {
            field = value
            setContent()
        }

    private fun setContent() {
        val repositories = repositories ?: return

        groupAdapter.clear()
        groupAdapter.addAll(repositories.map { RepositoryItem(it) })
    }
}
