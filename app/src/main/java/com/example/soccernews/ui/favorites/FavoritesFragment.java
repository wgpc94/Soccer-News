package com.example.soccernews.ui.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.soccernews.MainActivity;
import com.example.soccernews.databinding.FragmentFavoritesBinding;
import com.example.soccernews.domain.News;
import com.example.soccernews.ui.NewsAdapter;
import java.util.List;

public class FavoritesFragment extends Fragment {

    private FragmentFavoritesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        /*FavoritesViewModel favoritesViewModel = new ViewModelProvider(this).get(FavoritesViewModel.class);*/

        binding = FragmentFavoritesBinding.inflate(inflater, container, false);
        loadFavoriteNews();
        return binding.getRoot();
    }

    private void loadFavoriteNews() {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity != null){
            List<News> newsList;
            newsList = mainActivity.getDb().NewsDao().getFavoritesNews();
            binding.rvNews.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            binding.rvNews.setAdapter(new NewsAdapter(newsList, news -> {
                mainActivity.getDb().NewsDao().save(news);
                loadFavoriteNews();
            }
            ));
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}