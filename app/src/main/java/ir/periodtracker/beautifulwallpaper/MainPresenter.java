package ir.periodtracker.beautifulwallpaper;

import android.os.Bundle;

import java.util.List;

import ir.periodtracker.beautifulwallpaper.model.Wallpaper;
import ir.periodtracker.beautifulwallpaper.model.WallpaperResult;
import nucleus5.presenter.RxPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mahdiar on 8/5/17.
 */

// Presenter
public class MainPresenter extends RxPresenter<MainActivity> {
    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        Call<WallpaperResult> call = ApplicationBase.api.getWallpapers();
        call.enqueue(new Callback<WallpaperResult>() {
            @Override
            public void onResponse(Call<WallpaperResult> call, Response<WallpaperResult> response) {
                // Model
                view().blockingFirst().view.onItemsNext(response.body().getResult());
            }

            @Override
            public void onFailure(Call<WallpaperResult> call, Throwable t) {
                view().blockingFirst().view.onItemsError(t);
            }
        });
    }
}