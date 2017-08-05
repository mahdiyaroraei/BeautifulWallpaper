package ir.periodtracker.beautifulwallpaper.utils;

import java.util.List;

import ir.periodtracker.beautifulwallpaper.model.Wallpaper;
import ir.periodtracker.beautifulwallpaper.model.WallpaperResult;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mahdiar on 8/1/17.
 */

public interface WallpaperService {

    @GET("list.json")
    Call<WallpaperResult> getWallpapers();
}
