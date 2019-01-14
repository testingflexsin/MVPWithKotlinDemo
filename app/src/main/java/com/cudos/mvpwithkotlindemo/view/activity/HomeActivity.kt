package com.cudos.mvpwithkotlindemo.view.activity

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

import com.cudos.mvpwithkotlindemo.R
import com.cudos.mvpwithkotlindemo.adapters.HomeAdapter
import com.cudos.mvpwithkotlindemo.models.home_model.Datum
import com.cudos.mvpwithkotlindemo.models.home_model.HomeListResponse
import com.cudos.mvpwithkotlindemo.presenter.HomePresenter
import com.cudos.mvpwithkotlindemo.presenter_impl.HomePresenterImpl
import com.cudos.mvpwithkotlindemo.utils.ToastMessage
import com.cudos.mvpwithkotlindemo.view.HomeView

import retrofit2.Response

/*
Firstly, This activity implements the HomePresenter HomeView Interface through which it’s overridden
method will be called. Secondly, we have to create the HomePresenter object with view as a
constructor. We use this presenter object to listen the user input and update the data as well as view
* */

class HomeActivity : BaseActivity(), HomeView, SwipeRefreshLayout.OnRefreshListener, HomeAdapter.UserClickCallback {

    private var recyclerView: RecyclerView? = null
    private var progressBar: ProgressBar? = null
    private var homePresenter: HomePresenter? = null
    private var homeAdapter: HomeAdapter? = null
    private var mSwipeRefreshLayout: SwipeRefreshLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        inItView()
        //Create HomePresenterImpl instance and hold in HomePresenter to call getUserList() method
        homePresenter = HomePresenterImpl(this, this@HomeActivity)

        //Check internet connectity
        if (!networkStatus.isOnline(this@HomeActivity)) {
            ToastMessage.get().toastMessageShort(this@HomeActivity,
                    getString(R.string.no_internet))

            return
        }
        homePresenter!!.getUserList(true)

    }

    // Initialize all view of HomeActivity
    private fun inItView() {
        progressBar = findViewById(R.id.progress_circular)
        recyclerView = findViewById(R.id.homeUserRecycler)
        mSwipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)

        mSwipeRefreshLayout!!.setOnRefreshListener(this)
        mSwipeRefreshLayout!!.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark)
    }

    //Show Progressbar before get response from service.
    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
    }

    override fun showToast(msg: String) {
        ToastMessage.get().toastMessageShort(this@HomeActivity, msg)
    }

    //Hide Progressbar after get response from service.
    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
        mSwipeRefreshLayout!!.isRefreshing = false
    }

    //getData method of HomeView interface for get webservice response and set in HomeAdapter.
    override fun getData(data: Response<HomeListResponse>) {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = linearLayoutManager
        homeAdapter = HomeAdapter(data.body().data!!, this@HomeActivity, this)
        recyclerView!!.adapter = homeAdapter
    }

    //onRefresh  override method of SwipeRefreshLayout for pull to refresh data on HomeActivty.
    override fun onRefresh() {
        homePresenter!!.getUserList(false)
    }

    //onUserClick override method of UserClickCallback and it give position and list itms
    override fun onUserClick(position: Int, usersList: List<Datum>) {
        ToastMessage.get().toastMessageShort(this@HomeActivity,
                usersList.get(position).fullName.toString())
    }
}
