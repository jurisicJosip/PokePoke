package com.jjurisic.android.poke.ui.main;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jjurisic.android.poke.R;
import com.jjurisic.android.poke.api.data.Pokemon;
import com.jjurisic.android.poke.databinding.ListItemPokemonBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jurisicJosip.
 */
public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.BindingHolder> {

    //data
    private final List<Pokemon> mDataSource = new ArrayList<>();

    public void setData(@NonNull List<Pokemon> data) {
        mDataSource.clear();
        mDataSource.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListItemPokemonBinding binding = DataBindingUtil.inflate(inflater, R.layout.list_item_pokemon, parent, false);
        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(PokemonListAdapter.BindingHolder holder, int position) {
        Pokemon pokemon = mDataSource.get(position);
        ListItemPokemonBinding viewDataBinding = (ListItemPokemonBinding) holder.binding;
        viewDataBinding.setPokemonViewModel(new PokemonViewModel(holder.getContext(), pokemon));
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public BindingHolder(ListItemPokemonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @NonNull
        public Context getContext() {
            return binding.getRoot().getContext();
        }
    }
}