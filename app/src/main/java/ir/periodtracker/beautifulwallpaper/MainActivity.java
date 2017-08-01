package ir.periodtracker.beautifulwallpaper;

import android.os.Bundle;

import java.util.List;

import ir.periodtracker.beautifulwallpaper.model.Wallpaper;
import nucleus5.presenter.RxPresenter;
import nucleus5.view.NucleusActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// View
public class MainActivity extends NucleusActivity<MainPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onItemsNext(List<Wallpaper> wallpapers){
        // Should be update view here


    }

    public void onItemsError(Throwable throwable){

    }
}


// Presenter
class MainPresenter extends RxPresenter<MainActivity>{
    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        Call<List<Wallpaper>> call = ApplicationBase.api.getWallpapers();
        call.enqueue(new Callback<List<Wallpaper>>() {
            @Override
            public void onResponse(Call<List<Wallpaper>> call, Response<List<Wallpaper>> response) {
                // Model
                view().blockingFirst().view.onItemsNext(response.body());
            }

            @Override
            public void onFailure(Call<List<Wallpaper>> call, Throwable t) {
                view().blockingFirst().view.onItemsError(t);
            }
        });
    }
}