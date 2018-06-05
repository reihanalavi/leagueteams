package com.reihanalavi.leagueteams

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.Spinner
import com.google.gson.Gson
import com.reihanalavi.leagueteams.models.TeamItems
import com.reihanalavi.leagueteams.repo.ApiRepo
import com.reihanalavi.leagueteams.views.MainAdapter
import com.reihanalavi.leagueteams.views.MainPresenter
import com.reihanalavi.leagueteams.views.MainView
import org.jetbrains.anko.ctx

class MainActivity : AppCompatActivity(), MainView {
    override fun showLoading() {
        pbMain.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pbMain.visibility = View.INVISIBLE
    }

    override fun showLeague(data: List<TeamItems>) {
        data?.let {
            adapter.refresh(it)
            adapter.notifyDataSetChanged()
        }
    }

    private lateinit var spLeague: Spinner
    private lateinit var rvLeague: RecyclerView
    private lateinit var pbMain: ProgressBar
    private lateinit var leagueName: String

    private var teamItems: MutableList<TeamItems> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spLeague = findViewById(R.id.sp_league) as Spinner
        rvLeague = findViewById(R.id.rv_league) as RecyclerView
        pbMain = findViewById(R.id.pb_main) as ProgressBar

        val spinnerItems = resources.getStringArray(R.array.league)
        val spinnerAdapter = ArrayAdapter(ctx, android.R.layout.simple_spinner_dropdown_item, spinnerItems)
        spLeague.adapter = spinnerAdapter

        adapter = MainAdapter(teamItems)
        rvLeague.adapter = adapter
        presenter = MainPresenter(this, ApiRepo(), Gson())

        spLeague.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                leagueName = spLeague.selectedItem.toString()
                presenter.getLeague(leagueName)
            }

        }
    }
}
