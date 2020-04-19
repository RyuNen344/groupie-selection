package com.ryunen344.selection.home

import android.view.View
import androidx.recyclerview.selection.SelectionTracker
import com.ryunen344.selection.core.EqualableContentsProvider
import com.ryunen344.selection.home.databinding.ItemRepositoryBinding
import com.ryunen344.selection.model.Repository
import com.xwray.groupie.viewbinding.BindableItem

class RepositoryItem(
    private val selectionTracker: SelectionTracker<Long>,
    private val repository: Repository
) : BindableItem<ItemRepositoryBinding>(repository.id.toLong()), EqualableContentsProvider {

    override fun getLayout() = R.layout.item_repository

    override fun bind(viewBinding: ItemRepositoryBinding, position: Int) {
        viewBinding.repository = repository
        viewBinding.isSelected = selectionTracker.isSelected(repository.id.toLong())
    }

    override fun initializeViewBinding(view: View): ItemRepositoryBinding = ItemRepositoryBinding.bind(view)

    override fun providerEqualableContents(): Array<*> =
        arrayOf(selectionTracker.isSelected(repository.id.toLong()), repository)

    override fun equals(other: Any?): Boolean {
        return isSameContents(other)
    }

    override fun hashCode(): Int {
        return 32 * repository.hashCode()
    }

    override fun getId(): Long = repository.id.toLong()
}

