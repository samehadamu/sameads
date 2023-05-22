package com.aliendroid.sdkads.type.mediation;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.aliendroid.alienads.R;
import com.aliendroid.sdkads.interfaces.OnLoadBannerMediation;
import com.aliendroid.sdkads.interfaces.OnLoadInterstitialMediation;
import com.aliendroid.sdkads.interfaces.OnLoadNative;
import com.aliendroid.sdkads.interfaces.OnLoadRewardsMediation;
import com.aliendroid.sdkads.interfaces.OnShowInterstitial;
import com.aliendroid.sdkads.interfaces.OnShowRewards;
public class AlienMediationAds {
    public static OnLoadInterstitialMediation onLoadInterstitialMediation;
    public static OnLoadBannerMediation onLoadBannerMediation;
    public static OnLoadRewardsMediation onLoadRewardsMediation;
    public static OnShowInterstitial onShowInterstitial;
    public static OnShowRewards onShowRewards;
    public static OnLoadNative onLoadNative;
}
