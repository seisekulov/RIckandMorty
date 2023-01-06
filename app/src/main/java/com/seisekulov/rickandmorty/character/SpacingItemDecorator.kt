package com.seisekulov.rickandmorty.character

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacingItemDecorator() : RecyclerView.ItemDecoration() {
    private var verticalSpaceHeight: Int = 0

    constructor(verticalSpaceHeight: Int) : this() {
        this.verticalSpaceHeight = verticalSpaceHeight
    }

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        if (parent.getChildAdapterPosition(view) != parent.adapter!!.itemCount - 1) {
            outRect.bottom = verticalSpaceHeight;
        }
    }
}