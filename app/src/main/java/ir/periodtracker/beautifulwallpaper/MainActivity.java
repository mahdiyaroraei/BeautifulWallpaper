package ir.periodtracker.beautifulwallpaper;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ir.periodtracker.beautifulwallpaper.model.Wallpaper;
import nucleus5.factory.RequiresPresenter;
import nucleus5.presenter.RxPresenter;
import nucleus5.view.NucleusActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// View
@RequiresPresenter(MainPresenter.class)
public class MainActivity extends NucleusActivity<MainPresenter> {

    TextView amountTextView;
    ImageView testImageView;
    RecyclerView wallpaperRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountTextView = findViewById(R.id.amount_tv);
        testImageView = findViewById(R.id.test_iv);
        wallpaperRecyclerView = findViewById(R.id.wallpaper_rv);

    }

    private void setupWallpaperRecyclerView(List<Wallpaper> wallpapers) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        WallpaperAdapter adapter = new WallpaperAdapter(wallpapers);

        wallpaperRecyclerView.setLayoutManager(layoutManager);
        wallpaperRecyclerView.setAdapter(adapter);
    }

    class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.WallpaperViewHolder>{
        List<Wallpaper> wallpapers;

        public WallpaperAdapter(List<Wallpaper> wallpapers){
            this.wallpapers = wallpapers;
        }

        @Override
        public WallpaperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new WallpaperViewHolder(getLayoutInflater().inflate(R.layout.item_wallpaper , null));
        }

        @Override
        public void onBindViewHolder(WallpaperViewHolder holder, int position) {
            Wallpaper wallpaper = wallpapers.get(position);
            Picasso.with(getApplicationContext())
                    .load("https://www.mylittlewallpaper.com/images/o_" + wallpaper.getImageid() + ".png")
                    .into(holder.wallpaperImageView);
            holder.clicksTextView.setText(wallpaper.getClicks());
        }

        @Override
        public int getItemCount() {
            return wallpapers.size();
        }

        class WallpaperViewHolder extends RecyclerView.ViewHolder{
            ImageView wallpaperImageView;
            TextView clicksTextView;

            public WallpaperViewHolder(View itemView) {
                super(itemView);

                wallpaperImageView = itemView.findViewById(R.id.wallpaper_iv);
                clicksTextView = itemView.findViewById(R.id.clicks_tv);
            }
        }
    }

    public void onItemsNext(List<Wallpaper> wallpapers){
        // Should be update view here
        setupWallpaperRecyclerView(wallpapers);

    }

    public void onItemsError(Throwable throwable){

    }
}