package net.shayes.noku;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.util.ArrayMap;

import net.shayes.noku.model.TVApp;

import java.util.List;
import java.util.stream.Collectors;

public class TVAppManager {
    private static final int BANNER_CACHE_SIZE = 256;

    private Context context;
    private PackageManager pm;

    private ArrayMap<String, Drawable> bannerCache;

    public TVAppManager(Context context) {
        this.context = context;
        pm = context.getPackageManager();

        bannerCache = new ArrayMap<>(BANNER_CACHE_SIZE);
    }

    public List<TVApp> getAppList() {
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LEANBACK_LAUNCHER);

        // Query for all TV apps and map them to TVApp objects
        return pm.queryIntentActivities(intent, PackageManager.MATCH_ALL).stream()
            .map(info -> TVApp.fromInfo(context, info))
            .collect(Collectors.toList());
    }

    public Drawable getAppBanner(TVApp app) {
        // TODO: refactor so that each app has a reference to its banner
        Drawable banner = bannerCache.get(app.getPackageName());

        // If there is no cached banner, load and cache it
        if (banner == null) {
            banner = app.getActivityInfo().loadBanner(pm);

            // If the cache is full, remove an item to make space for the new one
            if (bannerCache.size() == BANNER_CACHE_SIZE) {
                bannerCache.removeAt(0);
            }

            bannerCache.put(app.getPackageName(), banner);
        }

        return banner;
    }

    public void startApp(TVApp app) {
        Intent intent = pm.getLeanbackLaunchIntentForPackage(app.getPackageName());
        context.startActivity(intent);
    }
}
