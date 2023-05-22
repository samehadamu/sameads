package com.aliendroid.alienads;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.aliendroid.alienads.interfaces.banner.OnLoadBannerAdmob;
import com.aliendroid.alienads.interfaces.banner.OnLoadBannerAlienMediation;
import com.aliendroid.alienads.interfaces.banner.OnLoadBannerAlienView;
import com.aliendroid.alienads.interfaces.banner.OnLoadBannerApplovinDiscovery;
import com.aliendroid.alienads.interfaces.banner.OnLoadBannerApplovinMax;
import com.aliendroid.alienads.interfaces.banner.OnLoadBannerFacebook;
import com.aliendroid.alienads.interfaces.banner.OnLoadBannerGoogle;
import com.aliendroid.alienads.interfaces.banner.OnLoadBannerIronSource;
import com.aliendroid.alienads.interfaces.banner.OnLoadBannerStartApp;
import com.aliendroid.sdkads.interfaces.OnLoadBannerMediation;
import com.aliendroid.sdkads.type.mediation.AlienMediationAds;
import com.aliendroid.sdkads.type.view.AlienViewAds;
  
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.startapp.sdk.ads.banner.Banner;
import com.startapp.sdk.ads.banner.BannerListener;
import com.startapp.sdk.ads.banner.Mrec;

public class AliendroidMediumBanner {
      
    public static AdView adViewAdmob;
    public static AdView adViewAdmob2;
    public static AdManagerAdView bannerGoogleAds;
      
    public static IronSourceBannerLayout adViewIron;
    public static Banner startAppBanner;
    public static Mrec startAppMrec;
    public static com.facebook.ads.AdView adViewFAN;

    public static OnLoadBannerAdmob onLoadBannerAdmob;
    public static OnLoadBannerGoogle onLoadBannerGoogle;
    public static OnLoadBannerFacebook onLoadBannerFacebook;
    public static OnLoadBannerApplovinDiscovery onLoadBannerApplovinDiscovery;
    public static OnLoadBannerApplovinMax onLoadBannerApplovinMax;
    public static OnLoadBannerStartApp onLoadBannerStartApp;
    public static OnLoadBannerIronSource onLoadBannerIronSource;
    public static OnLoadBannerAlienView onLoadBannerAlienView;
    public static OnLoadBannerAlienMediation onLoadBannerAlienMediation;

    public static void MediumBannerAdmob(Activity activity, RelativeLayout layAds, String selectAdsBackup, String idBanner, String idBannerBackup, String Hpk1,
                                         String Hpk2, String Hpk3, String Hpk4, String Hpk5) {

        AdRequest request = new AdRequest.Builder().addKeyword(Hpk1).addKeyword(Hpk2)
                .addKeyword(Hpk3).addKeyword(Hpk4).addKeyword(Hpk5)
                .build();
        adViewAdmob = new AdView(activity);
        adViewAdmob.setAdUnitId(idBanner);
        layAds.addView(adViewAdmob);
        adViewAdmob.setAdSize(AdSize.MEDIUM_RECTANGLE);
        adViewAdmob.loadAd(request);
        adViewAdmob.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                if (onLoadBannerAdmob!=null){
                    onLoadBannerAdmob.onAdLoaded();
                }
                switch (selectAdsBackup) {
                    case "APPLOVIN-M":
                          
                        break;
                    case "MOPUB":
                    case "UNITY":

                        break;
                    case "IRON":
                        if (adViewIron != null) {
                            adViewIron.isDestroyed();
                        }
                        break;
                    case "STARTAPP":
                        if (startAppBanner != null) {
                            startAppBanner.hideBanner();
                        }
                        break;
                    case "APPLOVIN-D":
                         
                        break;
                    case "FACEBOOK":
                        if (adViewFAN != null) {
                            adViewFAN.destroy();
                        }
                        break;
                }
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                if (onLoadBannerAdmob!=null){
                    onLoadBannerAdmob.onAdFailedToLoad("");
                }
                switch (selectAdsBackup) {
                    case "APPLOVIN-M":
                        
                        break;
                    case "MOPUB":
                    case "UNITY":

                        break;
                    case "IRON":
                        adViewIron = IronSource.createBanner(activity, ISBannerSize.RECTANGLE);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                                FrameLayout.LayoutParams.WRAP_CONTENT);
                        layAds.addView(adViewIron, 0, layoutParams);
                          com.ironsource.mediationsdk.sdk.BannerListener listenerIron = new com.ironsource.mediationsdk.sdk.BannerListener() {
                            @Override
                            public void onBannerAdLoaded() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdLoaded();
                                }

                            }

                            @Override
                            public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdLoadFailed();
                                }
                                layAds.setVisibility(View.GONE);
                            }

                            @Override
                            public void onBannerAdClicked() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdClicked();
                                }
                            }

                            @Override
                            public void onBannerAdScreenPresented() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdScreenPresented();
                                }
                            }

                            @Override
                            public void onBannerAdScreenDismissed() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdScreenDismissed();
                                }
                            }

                            @Override
                            public void onBannerAdLeftApplication() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdLeftApplication();
                                }
                            }
                        };
                        adViewIron.setBannerListener(listenerIron);
                        IronSource.loadBanner(adViewIron, idBannerBackup);
                        break;
                    case "STARTAPP":
                       startAppMrec = new Mrec(activity, new BannerListener() {
                            @Override
                            public void onReceiveAd(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onReceiveAd();
                                }

                            }

                            @Override
                            public void onFailedToReceiveAd(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onFailedToReceiveAd("");
                                }
                                layAds.setVisibility(View.GONE);
                            }

                            @Override
                            public void onImpression(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onImpression();
                                }
                            }

                            @Override
                            public void onClick(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onClick();
                                }
                            }
                        });
                        RelativeLayout.LayoutParams bannerParameters =
                                new RelativeLayout.LayoutParams(
                                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                                        RelativeLayout.LayoutParams.WRAP_CONTENT);
                        bannerParameters.addRule(RelativeLayout.CENTER_HORIZONTAL);
                        layAds.addView(startAppMrec, bannerParameters);
                        break;
                    case "APPLOVIN-D":
                       
                        break;
                    case "FACEBOOK":
                        adViewFAN = new com.facebook.ads.AdView(activity, idBannerBackup,
                                com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
                        layAds.addView(adViewFAN);
                        com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                            @Override
                            public void onError(Ad ad, AdError adError) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onError();
                                }
                                layAds.setVisibility(View.GONE);

                            }

                            @Override
                            public void onAdLoaded(Ad ad) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onAdLoaded();
                                }

                            }

                            @Override
                            public void onAdClicked(Ad ad) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onAdClicked();
                                }
                            }

                            @Override
                            public void onLoggingImpression(Ad ad) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onLoggingImpression();
                                }
                            }
                        };
                        adViewFAN.loadAd(adViewFAN.buildLoadAdConfig().withAdListener(adListener).build());
                        break;
                    case "ALIEN-V":
                        AlienViewAds.Banner(activity,layAds,idBannerBackup);
                        break;
                    case "ALIEN-M":
                        
                        break;
                    case "ADMOB":
                        AdRequest request = new AdRequest.Builder()
                                .build();
                        adViewAdmob2 = new AdView(activity);
                        adViewAdmob2.setAdUnitId(idBannerBackup);
                        layAds.addView(adViewAdmob2);
                        adViewAdmob2.setAdSize(AdSize.MEDIUM_RECTANGLE);
                        adViewAdmob2.loadAd(request);
                        adViewAdmob2.setAdListener(new AdListener() {
                            @Override
                            public void onAdLoaded() {


                            }

                            @Override
                            public void onAdFailedToLoad(LoadAdError adError) {
                                layAds.setVisibility(View.GONE);
                            }

                            @Override
                            public void onAdOpened() {

                            }

                            @Override
                            public void onAdClicked() {

                            }

                            @Override
                            public void onAdClosed() {

                            }
                        });
                        break;
                }
            }

            @Override
            public void onAdOpened() {
                if (onLoadBannerAdmob!=null){
                    onLoadBannerAdmob.onAdOpened();
                }
            }

            @Override
            public void onAdClicked() {
                if (onLoadBannerAdmob!=null){
                    onLoadBannerAdmob.onAdClosed();
                }
            }

            @Override
            public void onAdClosed() {
                if (onLoadBannerAdmob!=null){
                    onLoadBannerAdmob.onAdClosed();
                }
            }
        });


    }

    public static void MediumBannerGoogleAds(Activity activity, RelativeLayout layAds, String selectAdsBackup, String idBanner, String idBannerBackup) {

        AdManagerAdRequest adRequest =
                new AdManagerAdRequest.Builder()
                        .build();

        bannerGoogleAds = new AdManagerAdView(activity);
        bannerGoogleAds.setAdUnitId(idBanner);
        layAds.addView(bannerGoogleAds);
        bannerGoogleAds.setAdSize(AdSize.MEDIUM_RECTANGLE);
        bannerGoogleAds.loadAd(adRequest);
        bannerGoogleAds.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                if (onLoadBannerGoogle!=null){
                    onLoadBannerGoogle.onAdLoaded();
                }
                switch (selectAdsBackup) {
                    case "APPLOVIN-M":
                          
                        break;
                    case "MOPUB":
                    case "UNITY":

                        break;
                    case "IRON":
                        if (adViewIron != null) {
                            adViewIron.isDestroyed();
                        }
                        break;
                    case "STARTAPP":
                        if (startAppBanner != null) {
                            startAppBanner.hideBanner();
                        }
                        break;
                    case "APPLOVIN-D":
                         
                        break;
                    case "FACEBOOK":
                        if (adViewFAN != null) {
                            adViewFAN.destroy();
                        }
                        break;

                }
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                if (onLoadBannerGoogle!=null){
                    onLoadBannerGoogle.onAdFailedToLoad("");
                }
                switch (selectAdsBackup) {
                    case "APPLOVIN-M":
                           
                        break;
                    case "MOPUB":
                    case "UNITY":

                        break;
                    case "IRON":
                        adViewIron = IronSource.createBanner(activity, ISBannerSize.RECTANGLE);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                                FrameLayout.LayoutParams.WRAP_CONTENT);
                        layAds.addView(adViewIron, 0, layoutParams);
                          com.ironsource.mediationsdk.sdk.BannerListener listenerIron = new com.ironsource.mediationsdk.sdk.BannerListener() {
                            @Override
                            public void onBannerAdLoaded() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdLoaded();
                                }

                            }

                            @Override
                            public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdLoadFailed();
                                }
                                layAds.setVisibility(View.GONE);
                            }

                            @Override
                            public void onBannerAdClicked() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdClicked();
                                }
                            }

                            @Override
                            public void onBannerAdScreenPresented() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdScreenPresented();
                                }
                            }

                            @Override
                            public void onBannerAdScreenDismissed() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdScreenDismissed();
                                }
                            }

                            @Override
                            public void onBannerAdLeftApplication() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdLeftApplication();
                                }
                            }
                        };
                        adViewIron.setBannerListener(listenerIron);
                        IronSource.loadBanner(adViewIron, idBannerBackup);
                        break;
                    case "STARTAPP":
                       startAppMrec = new Mrec(activity, new BannerListener() {
                            @Override
                            public void onReceiveAd(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onReceiveAd();
                                }

                            }

                            @Override
                            public void onFailedToReceiveAd(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onFailedToReceiveAd("");
                                }
                                layAds.setVisibility(View.GONE);
                            }

                            @Override
                            public void onImpression(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onImpression();
                                }
                            }

                            @Override
                            public void onClick(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onClick();
                                }
                            }
                        });
                        RelativeLayout.LayoutParams bannerParameters =
                                new RelativeLayout.LayoutParams(
                                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                                        RelativeLayout.LayoutParams.WRAP_CONTENT);
                        bannerParameters.addRule(RelativeLayout.CENTER_HORIZONTAL);
                        layAds.addView(startAppMrec, bannerParameters);
                        break;
                    case "APPLOVIN-D":

                        break;
                    case "FACEBOOK":
                        adViewFAN = new com.facebook.ads.AdView(activity, idBannerBackup,
                                com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
                        layAds.addView(adViewFAN);
                        com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                            @Override
                            public void onError(Ad ad, AdError adError) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onError();
                                }
                                layAds.setVisibility(View.GONE);

                            }

                            @Override
                            public void onAdLoaded(Ad ad) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onAdLoaded();
                                }

                            }

                            @Override
                            public void onAdClicked(Ad ad) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onAdClicked();
                                }
                            }

                            @Override
                            public void onLoggingImpression(Ad ad) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onLoggingImpression();
                                }
                            }
                        };
                        adViewFAN.loadAd(adViewFAN.buildLoadAdConfig().withAdListener(adListener).build());
                        break;
                    case "ALIEN-V":
                        AlienViewAds.Banner(activity,layAds,idBannerBackup);
                        break;
                    case "ALIEN-M":
                        
                        break;
                }
            }

            @Override
            public void onAdOpened() {
                if (onLoadBannerGoogle!=null){
                    onLoadBannerGoogle.onAdOpened();
                }
            }

            @Override
            public void onAdClicked() {
                if (onLoadBannerGoogle!=null){
                    onLoadBannerGoogle.onAdClicked();
                }
            }

            @Override
            public void onAdClosed() {
                if (onLoadBannerGoogle!=null){
                    onLoadBannerGoogle.onAdClosed();
                }
            }
        });


    }


    public static void MediumBannerFAN(Activity activity, RelativeLayout layAds, String selectAdsBackup, String idBanner, String idBannerBackup) {
        adViewFAN = new com.facebook.ads.AdView(activity, idBanner,
                com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
        layAds.addView(adViewFAN);
        com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                if (onLoadBannerFacebook!=null){
                    onLoadBannerFacebook.onError();
                }
                switch (selectAdsBackup) {
                    case "APPLOVIN-M":
                           
                        break;
                    case "MOPUB":
                    case "UNITY":

                        break;
                    case "IRON":
                        adViewIron = IronSource.createBanner(activity, ISBannerSize.RECTANGLE);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                                FrameLayout.LayoutParams.WRAP_CONTENT);
                        layAds.addView(adViewIron, 0, layoutParams);
                          com.ironsource.mediationsdk.sdk.BannerListener listenerIron = new com.ironsource.mediationsdk.sdk.BannerListener() {
                            @Override
                            public void onBannerAdLoaded() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdLoaded();
                                }

                            }

                            @Override
                            public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdLoadFailed();
                                }
                                layAds.setVisibility(View.GONE);
                            }

                            @Override
                            public void onBannerAdClicked() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdClicked();
                                }
                            }

                            @Override
                            public void onBannerAdScreenPresented() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdScreenPresented();
                                }
                            }

                            @Override
                            public void onBannerAdScreenDismissed() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdScreenDismissed();
                                }
                            }

                            @Override
                            public void onBannerAdLeftApplication() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdLeftApplication();
                                }
                            }
                        };
                        adViewIron.setBannerListener(listenerIron);
                        IronSource.loadBanner(adViewIron, idBannerBackup);
                        break;
                    case "STARTAPP":
                       startAppMrec = new Mrec(activity, new BannerListener() {
                            @Override
                            public void onReceiveAd(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onReceiveAd();
                                }

                            }

                            @Override
                            public void onFailedToReceiveAd(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onFailedToReceiveAd("");
                                }
                                layAds.setVisibility(View.GONE);
                            }

                            @Override
                            public void onImpression(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onImpression();
                                }
                            }

                            @Override
                            public void onClick(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onClick();
                                }
                            }
                        });
                        RelativeLayout.LayoutParams bannerParameters =
                                new RelativeLayout.LayoutParams(
                                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                                        RelativeLayout.LayoutParams.WRAP_CONTENT);
                        bannerParameters.addRule(RelativeLayout.CENTER_HORIZONTAL);
                        layAds.addView(startAppMrec, bannerParameters);
                        break;
                    case "ADMOB":

                        AdRequest request = new AdRequest.Builder()
                                .build();
                        adViewAdmob = new AdView(activity);
                        adViewAdmob.setAdUnitId(idBannerBackup);
                        layAds.addView(adViewAdmob);
                        adViewAdmob.setAdSize(AdSize.MEDIUM_RECTANGLE);
                        adViewAdmob.loadAd(request);
                        adViewAdmob.setAdListener(new AdListener() {
                            @Override
                            public void onAdLoaded() {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdLoaded();
                                }

                            }

                            @Override
                            public void onAdFailedToLoad(LoadAdError adError) {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdFailedToLoad("");
                                }
                                layAds.setVisibility(View.GONE);

                            }

                            @Override
                            public void onAdOpened() {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdOpened();
                                }
                            }

                            @Override
                            public void onAdClicked() {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdClicked();
                                }
                            }

                            @Override
                            public void onAdClosed() {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdClosed();
                                }
                            }
                        });

                        break;
                    case "GOOGLE-ADS":
                        AdManagerAdRequest adRequest =
                                new AdManagerAdRequest.Builder()
                                        .build();

                        bannerGoogleAds = new AdManagerAdView(activity);
                       bannerGoogleAds.setAdUnitId(idBannerBackup);
                        layAds.addView(bannerGoogleAds);
                        bannerGoogleAds.setAdSize(AdSize.MEDIUM_RECTANGLE);
                        bannerGoogleAds.loadAd(adRequest);
                        bannerGoogleAds.setAdListener(new AdListener() {
                            @Override
                            public void onAdLoaded() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdLoaded();
                                }

                            }

                            @Override
                            public void onAdFailedToLoad(LoadAdError adError) {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdFailedToLoad("");
                                }
                                layAds.setVisibility(View.GONE);

                            }

                            @Override
                            public void onAdOpened() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdOpened();
                                }
                            }

                            @Override
                            public void onAdClicked() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdClicked();
                                }
                            }

                            @Override
                            public void onAdClosed() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdClosed();
                                }
                            }
                        });
                        bannerGoogleAds.setAdListener(new AdListener() {
                            @Override
                            public void onAdLoaded() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdLoaded();
                                }

                            }

                            @Override
                            public void onAdFailedToLoad(LoadAdError adError) {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdFailedToLoad("");
                                }
                                layAds.setVisibility(View.GONE);

                            }

                            @Override
                            public void onAdOpened() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdOpened();
                                }
                            }

                            @Override
                            public void onAdClicked() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdClicked();
                                }
                            }

                            @Override
                            public void onAdClosed() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdClosed();
                                }
                            }
                        });
                        break;
                    case "APPLOVIN-D":
                          
                        break;
                    case "ALIEN-V":
                        AlienViewAds.Banner(activity,layAds,idBannerBackup);
                        break;
                    case "ALIEN-M":
                        
                        break;
                }
            }

            @Override
            public void onAdLoaded(Ad ad) {
                if (onLoadBannerFacebook!=null){
                    onLoadBannerFacebook.onAdLoaded();
                }
                switch (selectAdsBackup) {
                    case "APPLOVIN-M":
                          
                        break;
                    case "MOPUB":

                        break;
                    case "IRON":
                        if (adViewIron != null) {
                            adViewIron.isDestroyed();
                        }
                        break;
                    case "STARTAPP":
                        if (startAppBanner != null) {
                            startAppBanner.hideBanner();
                        }
                        break;
                    case "ADMOB":
                        if (adViewAdmob != null) {
                            adViewAdmob.destroy();
                        }
                        break;
                    case "GOOGLE-ADS":
                        if (bannerGoogleAds != null) {
                            bannerGoogleAds.destroy();
                        }
                        break;
                    case "APPLOVIN-D":
                         
                        break;
                    case "UNITY":

                        break;
                }
            }

            @Override
            public void onAdClicked(Ad ad) {
                if (onLoadBannerFacebook!=null){
                    onLoadBannerFacebook.onAdClicked();
                }
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                if (onLoadBannerFacebook!=null){
                    onLoadBannerFacebook.onLoggingImpression();
                }
            }
        };
        adViewFAN.loadAd(adViewFAN.buildLoadAdConfig().withAdListener(adListener).build());

    }

    public static void MediumBannerApplovinDisHPK(Activity activity, RelativeLayout layAds, String selectAdsBackup, String idBanner, String idBannerBackup, String HPK1,
                                                  String HPK2, String HPK3, String HPK4, String HPK5) {

    }

    public static void MediumBannerApplovinDis(Activity activity, RelativeLayout layAds, String selectAdsBackup, String idBanner, String idBannerBackup) {

    }

    public static void MediumBannerApplovinMax(Activity activity, RelativeLayout layAds, String selectAdsBackup, String idBanner, String idBannerBackup) {

    }

    public static void MediumBannerMopub(Activity activity, RelativeLayout layAds, String selectAdsBackup, String idBanner, String idBannerBackup) {


    }

    public static void MediumBannerStartApp(Activity activity, RelativeLayout layAds, String selectAdsBackup, String idBanner, String idBannerBackup) {
        startAppMrec = new Mrec(activity, new BannerListener() {
            @Override
            public void onReceiveAd(View view) {
                if (onLoadBannerStartApp!=null){
                    onLoadBannerStartApp.onReceiveAd();
                }
                switch (selectAdsBackup) {
                    case "APPLOVIN-D":
                         
                        break;
                    case "APPLOVIN-M":
                          
                        break;
                    case "IRON":
                        if (adViewIron != null) {
                            adViewIron.isDestroyed();
                        }
                        break;
                    case "MOPUB":
                    case "UNITY":

                        break;
                    case "ADMOB":
                        if (adViewAdmob != null) {
                            adViewAdmob.destroy();
                        }
                        break;
                    case "GOOGLE-ADS":
                        if (bannerGoogleAds != null) {
                            bannerGoogleAds.destroy();
                        }
                        break;
                    case "FACEBOOK":
                        if (adViewFAN != null) {
                            adViewFAN.destroy();
                        }
                        break;
                }
            }

            @Override
            public void onFailedToReceiveAd(View view) {
                if (onLoadBannerStartApp!=null){
                    onLoadBannerStartApp.onFailedToReceiveAd("");
                }
                switch (selectAdsBackup) {
                    case "APPLOVIN-D":
                          
                        break;
                    case "APPLOVIN-M":
                           
                        break;
                    case "IRON":
                        adViewIron = IronSource.createBanner(activity, ISBannerSize.RECTANGLE);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                                FrameLayout.LayoutParams.WRAP_CONTENT);
                        layAds.addView(adViewIron, 0, layoutParams);
                          com.ironsource.mediationsdk.sdk.BannerListener listenerIron = new com.ironsource.mediationsdk.sdk.BannerListener() {
                            @Override
                            public void onBannerAdLoaded() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdLoaded();
                                }

                            }

                            @Override
                            public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdLoadFailed();
                                }
                                layAds.setVisibility(View.GONE);
                            }

                            @Override
                            public void onBannerAdClicked() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdClicked();
                                }
                            }

                            @Override
                            public void onBannerAdScreenPresented() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdScreenPresented();
                                }
                            }

                            @Override
                            public void onBannerAdScreenDismissed() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdScreenDismissed();
                                }
                            }

                            @Override
                            public void onBannerAdLeftApplication() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdLeftApplication();
                                }
                            }
                        };
                        adViewIron.setBannerListener(listenerIron);
                        IronSource.loadBanner(adViewIron, idBannerBackup);
                        break;
                    case "MOPUB":
                    case "UNITY":

                        break;
                    case "ADMOB":

                        AdRequest request = new AdRequest.Builder()
                                .build();
                        adViewAdmob = new AdView(activity);
                        adViewAdmob.setAdUnitId(idBannerBackup);
                        layAds.addView(adViewAdmob);
                        adViewAdmob.setAdSize(AdSize.MEDIUM_RECTANGLE);
                        adViewAdmob.loadAd(request);
                        adViewAdmob.setAdListener(new AdListener() {
                            @Override
                            public void onAdLoaded() {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdLoaded();
                                }

                            }

                            @Override
                            public void onAdFailedToLoad(LoadAdError adError) {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdFailedToLoad("");
                                }
                                layAds.setVisibility(View.GONE);

                            }

                            @Override
                            public void onAdOpened() {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdOpened();
                                }
                            }

                            @Override
                            public void onAdClicked() {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdClicked();
                                }
                            }

                            @Override
                            public void onAdClosed() {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdClosed();
                                }
                            }
                        });
                        break;
                    case "GOOGLE-ADS":
                        AdManagerAdRequest adRequest =
                                new AdManagerAdRequest.Builder()
                                        .build();

                        bannerGoogleAds = new AdManagerAdView(activity);
                       bannerGoogleAds.setAdUnitId(idBannerBackup);
                        layAds.addView(bannerGoogleAds);
                        bannerGoogleAds.setAdSize(AdSize.MEDIUM_RECTANGLE);
                        bannerGoogleAds.loadAd(adRequest);
                        bannerGoogleAds.setAdListener(new AdListener() {
                            @Override
                            public void onAdLoaded() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdLoaded();
                                }

                            }

                            @Override
                            public void onAdFailedToLoad(LoadAdError adError) {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdFailedToLoad("");
                                }
                                layAds.setVisibility(View.GONE);

                            }

                            @Override
                            public void onAdOpened() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdOpened();
                                }
                            }

                            @Override
                            public void onAdClicked() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdClicked();
                                }
                            }

                            @Override
                            public void onAdClosed() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdClosed();
                                }
                            }
                        });
                        break;
                    case "FACEBOOK":
                        adViewFAN = new com.facebook.ads.AdView(activity, idBannerBackup,
                                com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
                        layAds.addView(adViewFAN);
                        com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                            @Override
                            public void onError(Ad ad, AdError adError) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onError();
                                }
                                layAds.setVisibility(View.GONE);

                            }

                            @Override
                            public void onAdLoaded(Ad ad) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onAdLoaded();
                                }

                            }

                            @Override
                            public void onAdClicked(Ad ad) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onAdClicked();
                                }
                            }

                            @Override
                            public void onLoggingImpression(Ad ad) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onLoggingImpression();
                                }
                            }
                        };
                        adViewFAN.loadAd(adViewFAN.buildLoadAdConfig().withAdListener(adListener).build());
                        break;
                    case "ALIEN-V":
                        AlienViewAds.Banner(activity,layAds,idBannerBackup);
                        break;
                    case "ALIEN-M":

                        break;
                }
            }

            @Override
            public void onImpression(View view) {
                if (onLoadBannerStartApp!=null){
                    onLoadBannerStartApp.onImpression();
                }
            }

            @Override
            public void onClick(View view) {
                if (onLoadBannerStartApp!=null){
                    onLoadBannerStartApp.onClick();
                }
            }
        });
        RelativeLayout.LayoutParams bannerParameters =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        bannerParameters.addRule(RelativeLayout.CENTER_HORIZONTAL);
        layAds.addView(startAppMrec, bannerParameters);
    }

    public static void MediumBannerIron(Activity activity, RelativeLayout layAds, String selectAdsBackup, String idBanner, String idBannerBackup) {
        adViewIron = IronSource.createBanner(activity, ISBannerSize.RECTANGLE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        layAds.addView(adViewIron, 0, layoutParams);
        com.ironsource.mediationsdk.sdk.BannerListener listener = new com.ironsource.mediationsdk.sdk.BannerListener() {
            @Override
            public void onBannerAdLoaded() {
                if (onLoadBannerIronSource!=null){
                    onLoadBannerIronSource.onBannerAdLoaded();
                }
                switch (selectAdsBackup) {
                    case "APPLOVIN-D":
                         
                        break;
                    case "APPLOVIN-M":
                          
                        break;
                    case "STARTAPP":
                        startAppBanner.hideBanner();
                        break;
                    case "MOPUB":
                    case "UNITY":

                        break;
                    case "ADMOB":
                        if (adViewAdmob != null) {
                            adViewAdmob.destroy();
                        }
                        break;
                    case "GOOGLE-ADS":
                        if (bannerGoogleAds != null) {
                            bannerGoogleAds.destroy();
                        }
                        break;
                    case "FACEBOOK":
                        if (adViewFAN != null) {
                            adViewFAN.destroy();
                        }
                        break;
                }
            }

            @Override
            public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
                if (onLoadBannerIronSource!=null){
                    onLoadBannerIronSource.onBannerAdLoadFailed();
                }
                switch (selectAdsBackup) {
                    case "APPLOVIN-D":
                          
                        break;
                    case "APPLOVIN-M":
                           
                        break;
                    case "STARTAPP":
                       startAppMrec = new Mrec(activity, new BannerListener() {
                            @Override
                            public void onReceiveAd(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onReceiveAd();
                                }

                            }

                            @Override
                            public void onFailedToReceiveAd(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onFailedToReceiveAd("");
                                }
                                layAds.setVisibility(View.GONE);
                            }

                            @Override
                            public void onImpression(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onImpression();
                                }
                            }

                            @Override
                            public void onClick(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onClick();
                                }
                            }
                        });
                        RelativeLayout.LayoutParams bannerParameters =
                                new RelativeLayout.LayoutParams(
                                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                                        RelativeLayout.LayoutParams.WRAP_CONTENT);
                        bannerParameters.addRule(RelativeLayout.CENTER_HORIZONTAL);
                        layAds.addView(startAppMrec, bannerParameters);
                        break;
                    case "MOPUB":
                    case "UNITY":

                        break;
                    case "ADMOB":

                        AdRequest request = new AdRequest.Builder()
                                .build();
                        adViewAdmob = new AdView(activity);
                        adViewAdmob.setAdUnitId(idBannerBackup);
                        layAds.addView(adViewAdmob);
                        adViewAdmob.setAdSize(AdSize.MEDIUM_RECTANGLE);
                        adViewAdmob.loadAd(request);
                        adViewAdmob.setAdListener(new AdListener() {
                            @Override
                            public void onAdLoaded() {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdLoaded();
                                }

                            }

                            @Override
                            public void onAdFailedToLoad(LoadAdError adError) {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdFailedToLoad("");
                                }
                                layAds.setVisibility(View.GONE);

                            }

                            @Override
                            public void onAdOpened() {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdOpened();
                                }
                            }

                            @Override
                            public void onAdClicked() {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdClicked();
                                }
                            }

                            @Override
                            public void onAdClosed() {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdClosed();
                                }
                            }
                        });
                        break;
                    case "GOOGLE-ADS":
                        AdManagerAdRequest adRequest =
                                new AdManagerAdRequest.Builder()
                                        .build();

                        bannerGoogleAds = new AdManagerAdView(activity);
                       bannerGoogleAds.setAdUnitId(idBannerBackup);
                        layAds.addView(bannerGoogleAds);
                        bannerGoogleAds.setAdSize(AdSize.MEDIUM_RECTANGLE);
                        bannerGoogleAds.loadAd(adRequest);
                        bannerGoogleAds.setAdListener(new AdListener() {
                            @Override
                            public void onAdLoaded() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdLoaded();
                                }

                            }

                            @Override
                            public void onAdFailedToLoad(LoadAdError adError) {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdFailedToLoad("");
                                }
                                layAds.setVisibility(View.GONE);

                            }

                            @Override
                            public void onAdOpened() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdOpened();
                                }
                            }

                            @Override
                            public void onAdClicked() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdClicked();
                                }
                            }

                            @Override
                            public void onAdClosed() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdClosed();
                                }
                            }
                        });
                        break;
                    case "FACEBOOK":
                        adViewFAN = new com.facebook.ads.AdView(activity, idBannerBackup,
                                com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
                        layAds.addView(adViewFAN);
                        com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                            @Override
                            public void onError(Ad ad, AdError adError) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onError();
                                }
                                layAds.setVisibility(View.GONE);

                            }

                            @Override
                            public void onAdLoaded(Ad ad) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onAdLoaded();
                                }

                            }

                            @Override
                            public void onAdClicked(Ad ad) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onAdClicked();
                                }
                            }

                            @Override
                            public void onLoggingImpression(Ad ad) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onLoggingImpression();
                                }
                            }
                        };
                        adViewFAN.loadAd(adViewFAN.buildLoadAdConfig().withAdListener(adListener).build());
                        break;
                    case "ALIEN-V":
                        AlienViewAds.Banner(activity,layAds,idBannerBackup);
                        break;
                    case "ALIEN-M":
                        
                        break;
                }
            }

            @Override
            public void onBannerAdClicked() {
                if (onLoadBannerIronSource!=null){
                    onLoadBannerIronSource.onBannerAdClicked();
                }
            }

            @Override
            public void onBannerAdScreenPresented() {
                if (onLoadBannerIronSource!=null){
                    onLoadBannerIronSource.onBannerAdScreenPresented();
                }
            }

            @Override
            public void onBannerAdScreenDismissed() {
                if (onLoadBannerIronSource!=null){
                    onLoadBannerIronSource.onBannerAdScreenDismissed();
                }
            }

            @Override
            public void onBannerAdLeftApplication() {
                if (onLoadBannerIronSource!=null){
                    onLoadBannerIronSource.onBannerAdLeftApplication();
                }
            }
        };
        adViewIron.setBannerListener(listener);
        IronSource.loadBanner(adViewIron, idBanner);
    }

    public static void MediumBannerUnity(Activity activity, RelativeLayout layAds, String selectAdsBackup, String idBanner, String idBannerBackup) {

    }

    public static void MediumBannerAlienMediation(Activity activity, RelativeLayout layAds, String selectAdsBackup, String idBanner, String idBannerBackup) {

        AlienMediationAds.onLoadBannerMediation = new OnLoadBannerMediation() {
            @Override
            public void onBannerAdLoaded() {
                switch (selectAdsBackup) {
                    case "APPLOVIN-D":
                         
                        break;
                    case "APPLOVIN-M":
                          
                        break;
                    case "STARTAPP":
                        startAppBanner.hideBanner();
                        break;
                    case "MOPUB":
                    case "UNITY":

                        break;
                    case "ADMOB":
                        if (adViewAdmob != null) {
                            adViewAdmob.destroy();
                        }
                        break;
                    case "GOOGLE-ADS":
                        if (bannerGoogleAds != null) {
                            bannerGoogleAds.destroy();
                        }
                        break;
                    case "FACEBOOK":
                        if (adViewFAN != null) {
                            adViewFAN.destroy();
                        }
                        break;
                    case "IRON":
                        if (adViewIron != null) {
                            adViewIron.isDestroyed();
                        }
                        break;
                }
            }

            @Override
            public void onBannerAdClicked() {

            }

            @Override
            public void onBannerAdFailedToLoad(String error) {
                switch (selectAdsBackup) {
                    case "APPLOVIN-D":
                          
                        break;
                    case "APPLOVIN-M":
                           
                        break;
                    case "STARTAPP":
                       startAppMrec = new Mrec(activity, new BannerListener() {
                            @Override
                            public void onReceiveAd(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onReceiveAd();
                                }

                            }

                            @Override
                            public void onFailedToReceiveAd(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onFailedToReceiveAd("");
                                }
                                layAds.setVisibility(View.GONE);
                            }

                            @Override
                            public void onImpression(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onImpression();
                                }
                            }

                            @Override
                            public void onClick(View view) {
                                if (onLoadBannerStartApp!=null){
                                    onLoadBannerStartApp.onClick();
                                }
                            }
                        });
                        RelativeLayout.LayoutParams bannerParameters =
                                new RelativeLayout.LayoutParams(
                                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                                        RelativeLayout.LayoutParams.WRAP_CONTENT);
                        bannerParameters.addRule(RelativeLayout.CENTER_HORIZONTAL);
                        layAds.addView(startAppMrec, bannerParameters);
                        break;
                    case "MOPUB":
                    case "UNITY":

                        break;
                    case "ADMOB":

                        AdRequest request = new AdRequest.Builder()
                                .build();
                        adViewAdmob = new AdView(activity);
                        adViewAdmob.setAdUnitId(idBannerBackup);
                        layAds.addView(adViewAdmob);
                        adViewAdmob.setAdSize(AdSize.MEDIUM_RECTANGLE);
                        adViewAdmob.loadAd(request);
                        adViewAdmob.setAdListener(new AdListener() {
                            @Override
                            public void onAdLoaded() {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdLoaded();
                                }

                            }

                            @Override
                            public void onAdFailedToLoad(LoadAdError adError) {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdFailedToLoad("");
                                }
                                layAds.setVisibility(View.GONE);

                            }

                            @Override
                            public void onAdOpened() {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdOpened();
                                }
                            }

                            @Override
                            public void onAdClicked() {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdClicked();
                                }
                            }

                            @Override
                            public void onAdClosed() {
                                if (onLoadBannerAdmob!=null){
                                    onLoadBannerAdmob.onAdClosed();
                                }
                            }
                        });
                        break;
                    case "GOOGLE-ADS":
                        AdManagerAdRequest adRequest =
                                new AdManagerAdRequest.Builder()
                                        .build();

                        bannerGoogleAds = new AdManagerAdView(activity);
                       bannerGoogleAds.setAdUnitId(idBannerBackup);
                        layAds.addView(bannerGoogleAds);
                        bannerGoogleAds.setAdSize(AdSize.MEDIUM_RECTANGLE);
                        bannerGoogleAds.loadAd(adRequest);
                        bannerGoogleAds.setAdListener(new AdListener() {
                            @Override
                            public void onAdLoaded() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdLoaded();
                                }

                            }

                            @Override
                            public void onAdFailedToLoad(LoadAdError adError) {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdFailedToLoad("");
                                }
                                layAds.setVisibility(View.GONE);

                            }

                            @Override
                            public void onAdOpened() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdOpened();
                                }
                            }

                            @Override
                            public void onAdClicked() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdClicked();
                                }
                            }

                            @Override
                            public void onAdClosed() {
                                if (onLoadBannerGoogle!=null){
                                    onLoadBannerGoogle.onAdClosed();
                                }
                            }
                        });
                        break;
                    case "FACEBOOK":
                        adViewFAN = new com.facebook.ads.AdView(activity, idBannerBackup,
                                com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
                        layAds.addView(adViewFAN);
                        com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                            @Override
                            public void onError(Ad ad, AdError adError) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onError();
                                }
                                layAds.setVisibility(View.GONE);

                            }

                            @Override
                            public void onAdLoaded(Ad ad) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onAdLoaded();
                                }

                            }

                            @Override
                            public void onAdClicked(Ad ad) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onAdClicked();
                                }
                            }

                            @Override
                            public void onLoggingImpression(Ad ad) {
                                if (onLoadBannerFacebook!=null){
                                    onLoadBannerFacebook.onLoggingImpression();
                                }
                            }
                        };
                        adViewFAN.loadAd(adViewFAN.buildLoadAdConfig().withAdListener(adListener).build());
                        break;
                    case "ALIEN-V":
                        AlienViewAds.Banner(activity,layAds,idBannerBackup);
                        break;
                    case "IRON":
                        adViewIron = IronSource.createBanner(activity, ISBannerSize.RECTANGLE);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                                FrameLayout.LayoutParams.WRAP_CONTENT);
                        layAds.addView(adViewIron, 0, layoutParams);
                          com.ironsource.mediationsdk.sdk.BannerListener listenerIron = new com.ironsource.mediationsdk.sdk.BannerListener() {
                            @Override
                            public void onBannerAdLoaded() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdLoaded();
                                }

                            }

                            @Override
                            public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdLoadFailed();
                                }
                                layAds.setVisibility(View.GONE);
                            }

                            @Override
                            public void onBannerAdClicked() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdClicked();
                                }
                            }

                            @Override
                            public void onBannerAdScreenPresented() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdScreenPresented();
                                }
                            }

                            @Override
                            public void onBannerAdScreenDismissed() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdScreenDismissed();
                                }
                            }

                            @Override
                            public void onBannerAdLeftApplication() {
                                if (onLoadBannerIronSource!=null){
                                    onLoadBannerIronSource.onBannerAdLeftApplication();
                                }
                            }
                        };
                        adViewIron.setBannerListener(listenerIron);
                        IronSource.loadBanner(adViewIron, idBannerBackup);
                        break;
                }
            }
        };

    }

}
