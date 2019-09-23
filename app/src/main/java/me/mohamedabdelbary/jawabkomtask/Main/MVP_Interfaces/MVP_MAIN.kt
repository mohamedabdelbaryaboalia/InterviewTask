package me.mohamedabdelbary.jawabkomtask.Main.MVP_Interfaces


import android.content.Context
import android.view.ViewGroup
import me.mohamedabdelbary.jawabkomtask.Adapters.VehiclesCustomAdapter

import me.mohamedabdelbary.jawabkomtask.ClassModels.Vehicle

interface MVP_MAIN {

    // methods available to view
    interface RequiredViewOps {
        fun notifyAdapter()

        val appContext: Context

        val activityContext: Context

    }


    // Required View methods available to Presenter.

    interface ProvidedPresenterOps {
        abstract fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiclesCustomAdapter.CustomViewHolder
        abstract fun getItemCount(): Int
        abstract fun onBindViewHolder(holder: VehiclesCustomAdapter.CustomViewHolder, position: Int)
        fun getData()
    }


    // Required Model methods available to Presenter.

    interface RequiredPresenterOps {
        fun notifyAdapter()

        val appContext: Context

        val activityContext: Context

    }

    // Methods Available to Model
    interface ProvidedModelOps {

        abstract fun getData()
        abstract fun getSize(): Int
        abstract fun getListItem(position: Int): Vehicle
    }
}
