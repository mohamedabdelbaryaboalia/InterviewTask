package me.mohamedabdelbary.jawabkomtask.Main.View

import androidx.appcompat.app.AppCompatActivity

import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import me.mohamedabdelbary.jawabkomtask.Adapters.VehiclesCustomAdapter
import me.mohamedabdelbary.jawabkomtask.Main.MVP_Interfaces.MVP_MAIN
import me.mohamedabdelbary.jawabkomtask.Main.Model.MainModel
import me.mohamedabdelbary.jawabkomtask.Main.Presenter.MainPresenter
import me.mohamedabdelbary.jawabkomtask.R

class MainActivity : AppCompatActivity(), MVP_MAIN.RequiredViewOps {



    lateinit var mPresenter: MVP_MAIN.ProvidedPresenterOps
    private val recycler : RecyclerView by lazy { findViewById<RecyclerView>(R.id.main_list) }
    private val refreshLayout : SwipeRefreshLayout by lazy { findViewById<SwipeRefreshLayout>(R.id.refreshLayout) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupMVP()
        setupRefreshLayout()
        setupRecyclerView()
        mPresenter.getData()

    }

    //method to get appContext
    override val appContext: Context
        get() = applicationContext

    //method to get Activity context
    override val activityContext: Context
        get() = this

    override fun notifyAdapter() {

        refreshLayout.setRefreshing(false)
        recycler.adapter!!.notifyDataSetChanged()

    }

    //function to setup Mvp
    private fun setupMVP() {
        // Create the Presenter
        val presenter = MainPresenter(this)
        // Create the Model
        val model = MainModel(presenter)
        // Set Presenter model
        presenter.setModel(model)
        // Set the Presenter as a interface
        mPresenter = presenter
    }

    private fun setupRecyclerView(){
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = VehiclesCustomAdapter(mPresenter)
    }

    private fun setupRefreshLayout(){
        val customListener = CustomRefreshListener
        customListener.set(mPresenter)
        refreshLayout.setOnRefreshListener(customListener)
    }

    object  CustomRefreshListener : SwipeRefreshLayout.OnRefreshListener{
        lateinit var  presenter :  MVP_MAIN.ProvidedPresenterOps
        fun set(presenter: MVP_MAIN.ProvidedPresenterOps){
            this.presenter = presenter
        }
        override fun onRefresh() {
            presenter.getData()
        }

    }

}
