package com.example.resepdapur

import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.core.view.ViewCompat
import androidx.core.view.ViewCompat.NestedScrollType

class BottomNavigationViewBehavior : CoordinatorLayout.Behavior<BottomNavigationItemView?>() {
    private var height = 0
    fun onLayoutChild(
        parent: CoordinatorLayout?,
        child: BottomNavigationView,
        layoutDirection: Int
    ): Boolean {
        height = child.height
        return super.onLayoutChild(parent!!, child.findViewById(R.id.bottomNavView), layoutDirection)
    }

    fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: BottomNavigationView?, directTargetChild: View, target: View,
        axes: Int, type: Int
    ): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout, child: BottomNavigationView,
        target: View, dxConsumed: Int, dyConsumed: Int,
        dxUnconsumed: Int, dyUnconsumed: Int,
        @NestedScrollType type: Int
    ) {
        if (dyConsumed > 0) {
            slideDown(child)
        } else if (dyConsumed < 0) {
            slideUp(child)
        }
    }

    private fun slideUp(child: BottomNavigationView) {
        child.clearAnimation()
        child.animate().translationY(0f).duration = 200
    }

    private fun slideDown(child: BottomNavigationView) {
        child.clearAnimation()
        child.animate().translationY(height.toFloat()).duration = 200
    }

}

