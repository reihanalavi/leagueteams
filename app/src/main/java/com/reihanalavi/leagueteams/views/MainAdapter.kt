package com.reihanalavi.leagueteams.views

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.reihanalavi.leagueteams.R
import com.reihanalavi.leagueteams.models.TeamItems
import org.jetbrains.anko.*

/**
 * Created by rehan on 6/5/2018.
 */
class MainAdapter (private var teamItems: List<TeamItems>): RecyclerView.Adapter<MainAdapter.TeamViewHolder>() {

    override fun getItemCount(): Int {
        return teamItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(TeamUI().createView(AnkoContext.Companion.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(teamItems[position])
    }

    fun refresh(fill: List<TeamItems>) {
        teamItems = fill
        notifyDataSetChanged()
    }

    class TeamUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                linearLayout {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(16)
                    orientation = LinearLayout.HORIZONTAL

                    imageView {
                        id = R.id.team_badge
                    }.lparams{
                        height = dip(50)
                        width = dip(50)
                    }

                    textView {
                        id = R.id.team_name
                        textSize = 16f
                    }.lparams{
                        margin = dip(15)
                    }

                }
            }
        }

    }

    class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val teamBadge = view.find<ImageView>(R.id.team_badge)
        private val teamName = view.find<TextView>(R.id.team_name)

        fun bindItem(teams: TeamItems) {
            Glide.with(itemView.context).load(teams.teamBadge).into(teamBadge)
            teamName.text = teams.teamName
        }
    }

}

