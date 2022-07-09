package net.shayes.noku.model;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;

public class TVApp {
    private String label;
    private String packageName;
    private ActivityInfo activityInfo;

    public TVApp(String label, String packageName, ActivityInfo activityInfo) {
        this.label = label;
        this.packageName = packageName;
        this.activityInfo = activityInfo;
    }

    public static TVApp fromInfo(Context context, ResolveInfo info) {
        String label = info.loadLabel(context.getPackageManager()).toString();
        String packageName = info.activityInfo.packageName;
        ActivityInfo activityInfo = info.activityInfo;

        return new TVApp(label, packageName, activityInfo);
    }

    public String getLabel() {
        return label;
    }

    public String getPackageName() {
        return packageName;
    }

    public ActivityInfo getActivityInfo() {
        return activityInfo;
    }
}
