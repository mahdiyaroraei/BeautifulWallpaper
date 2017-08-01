package ir.periodtracker.beautifulwallpaper;

import android.app.Application;

import ir.periodtracker.beautifulwallpaper.utils.ServiceGenerator;
import ir.periodtracker.beautifulwallpaper.utils.WallpaperService;

/**
 * Created by mahdiar on 8/1/17.
 */

public class ApplicationBase extends Application {

    public static WallpaperService api;


    @Override
    public void onCreate() {
        super.onCreate();

        api = ServiceGenerator.createService(WallpaperService.class);
    }
}
