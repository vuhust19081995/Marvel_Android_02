package com.framgia.moviedb.screen.detail;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.databinding.ItemActorBinding;
import com.framgia.moviedb.screen.OnRecyclerViewItemClickListener;
import java.util.List;

/**
 * Created by workspace on 29/09/2017.
 */

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {
    private List<Actor> mActors;
    private OnRecyclerViewItemClickListener<Actor> mClickListener;

    public ActorAdapter(List<Actor> actors) {
        mActors = actors;
    }

    @Override
    public ActorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemActorBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_actor, parent, false);
        return new ActorViewHolder(binding, mClickListener);
    }

    @Override
    public void onBindViewHolder(ActorViewHolder holder, int position) {
        holder.bind(mActors.get(position));
    }

    @Override
    public int getItemCount() {
        return mActors != null ? mActors.size() : 0;
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener<Actor> onItemClickListener) {
        mClickListener = onItemClickListener;
    }

    /**
     * Create ViewHolder
     */
    class ActorViewHolder extends RecyclerView.ViewHolder {
        private ItemActorBinding mBinding;
        private OnRecyclerViewItemClickListener<Actor> mClickListener;

        ActorViewHolder(ItemActorBinding binding,
                OnRecyclerViewItemClickListener<Actor> onItemClickListener) {
            super(binding.getRoot());
            mBinding = binding;
            mClickListener = onItemClickListener;
        }

        public void bind(Actor actor) {
            mBinding.setActor(actor);
            mBinding.setItemClickListener(mClickListener);
            mBinding.executePendingBindings();
        }
    }
}
