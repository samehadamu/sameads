package com.aliendroid.alienads;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.aliendroid.alienads.interfaces.rewards.load.OnLoadRewardsAdmob;
import com.aliendroid.alienads.interfaces.rewards.load.OnLoadRewardsAlienView;
import com.aliendroid.alienads.interfaces.rewards.load.OnLoadRewardsApplovinDiscovery;
import com.aliendroid.alienads.interfaces.rewards.load.OnLoadRewardsApplovinMax;
import com.aliendroid.alienads.interfaces.rewards.load.OnLoadRewardsGoogle;
import com.aliendroid.alienads.interfaces.rewards.load.OnLoadRewardsIronSource;
import com.aliendroid.alienads.interfaces.rewards.load.OnLoadRewardsStartApp;
import com.aliendroid.alienads.interfaces.rewards.show.OnShowRewardsAdmob;
import com.aliendroid.alienads.interfaces.rewards.show.OnShowRewardsAlienMedition;
import com.aliendroid.alienads.interfaces.rewards.show.OnShowRewardsAlienView;
import com.aliendroid.alienads.interfaces.rewards.show.OnShowRewardsApplovinDiscovery;
import com.aliendroid.alienads.interfaces.rewards.show.OnShowRewardsGoogle;
import com.aliendroid.sdkads.interfaces.OnLoadRewardsMediation;
import com.aliendroid.sdkads.interfaces.OnLoadRewardsView;
import com.aliendroid.sdkads.interfaces.OnShowInterstitialView;
import com.aliendroid.sdkads.interfaces.OnShowRewards;
import com.aliendroid.sdkads.interfaces.OnShowRewardsView;
import com.aliendroid.sdkads.type.mediation.AlienMediationAds;
import com.aliendroid.sdkads.type.view.AlienViewAds;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adlisteners.VideoListener;

import java.util.Map;

public class AliendroidReward {
      
    public static boolean unlockreward = false;
     
    public static StartAppAd rewardedVideo;
    private static RewardedAd mRewardedAd;
    private static RewardedAd mRewardedAd2;
    public static OnLoadRewardsAdmob onLoadRewardsAdmob;
    public static OnLoadRewardsStartApp onLoadRewardsStartApp;
    public static OnLoadRewardsGoogle onLoadRewardsGoogle;
    public static OnLoadRewardsApplovinDiscovery onLoadRewardsApplovinDiscovery;
    public static OnLoadRewardsApplovinMax onLoadRewardsApplovinMax;
    public static OnLoadRewardsIronSource onLoadRewardsIronSource;
    public static OnLoadRewardsMediation onLoadRewardsMediation;
    public static OnLoadRewardsAlienView onLoadRewardsAlienView;

    public static OnShowRewardsAdmob onShowRewardsAdmob;
    public static OnShowRewardsGoogle onShowRewardsGoogle;
    public static OnShowRewardsApplovinDiscovery onShowRewardsApplovinDiscovery;
    public static OnShowRewardsAlienMedition onShowRewardsAlienMedition;
    public static OnShowRewardsAlienView onShowRewardsAlienView;

    public static boolean SHOW_ALIEN_VIEW=false;
    public static void LoadRewardAdmob(Activity activity, String selectBackupAds, String idReward, String idBackupReward) {
        try {

            AdRequest adRequest = new AdRequest.Builder()
                    .build();
            RewardedAd.load(activity, idReward,
                    adRequest, new RewardedAdLoadCallback() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            if (onLoadRewardsAdmob!=null){
                                onLoadRewardsAdmob.onAdFailedToLoad();
                            }
                            mRewardedAd = null;
                        }

                        @Override
                        public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                            if (onLoadRewardsAdmob!=null){
                                onLoadRewardsAdmob.onAdLoaded("");
                            }
                            mRewardedAd = rewardedAd;

                        }
                    });
            switch (selectBackupAds) {
                case "APPLOVIN-M":
                      
                    break;
                case "MOPUB":
                case "UNITY":
                    break;
                case "APPLOVIN-D":
                      
                    break;
                case "IRON":
                    IronSource.setRewardedVideoListener(new RewardedVideoListener() {
                        @Override
                        public void onRewardedVideoAdOpened() {
                        }

                        @Override
                        public void onRewardedVideoAdClosed() {
                        }

                        @Override
                        public void onRewardedVideoAvailabilityChanged(boolean available) {
                        }

                        @Override
                        public void onRewardedVideoAdRewarded(Placement placement) {
                            unlockreward = true;
                        }

                        @Override
                        public void onRewardedVideoAdShowFailed(IronSourceError error) {
                        }

                        @Override
                        public void onRewardedVideoAdClicked(Placement placement) {
                        }

                        @Override
                        public void onRewardedVideoAdStarted() {
                        }

                        @Override
                        public void onRewardedVideoAdEnded() {
                        }
                    });
                    break;
                case "STARTAPP":
                    rewardedVideo = new StartAppAd(activity);
                    rewardedVideo.setVideoListener(new VideoListener() {
                        @Override
                        public void onVideoCompleted() {
                            unlockreward = true;
                        }
                    });

                    rewardedVideo.loadAd(StartAppAd.AdMode.REWARDED_VIDEO, new AdEventListener() {
                        @Override
                        public void onReceiveAd(com.startapp.sdk.adsbase.Ad ad) {

                        }
                        @Override
                        public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {

                        }
                    });
                    break;

                case "ALIEN-M" :
                    
                    AlienMediationAds.onLoadRewardsMediation = new OnLoadRewardsMediation() {
                        @Override
                        public void onRewardsAdLoaded() {

                        }

                        @Override
                        public void onRewardsAdClosed() {

                        }

                        @Override
                        public void onRewardsAdReward() {
                            unlockreward = true;
                        }

                        @Override
                        public void onRewardsAdClicked() {

                        }

                        @Override
                        public void onRewardsAdFailedToLoad(String error) {

                        }
                    };
                    break;
                case "ALIEN-V":
                    AlienViewAds.RewardsAds(activity,idBackupReward);
                    AlienViewAds.onLoadRewardsView = new OnLoadRewardsView() {
                        @Override
                        public void onRewardsAdLoaded() {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdLoaded();
                            }
                        }

                        @Override
                        public void onRewardsAdClosed() {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdClosed();
                            }
                        }

                        @Override
                        public void onRewardsAdClicked() {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdClicked();
                            }
                        }

                        @Override
                        public void onRewardsAdFailedToLoad(String error) {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdFailedToLoad("");
                            }
                        }
                    };
                    break;

                case "ADMOB":
                    AdRequest adRequest2 = new AdRequest.Builder()
                            .build();
                    RewardedAd.load(activity, idBackupReward,
                            adRequest2, new RewardedAdLoadCallback() {
                                @Override
                                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                    mRewardedAd2 = null;
                                }

                                @Override
                                public void onAdLoaded(@NonNull RewardedAd rewardedAd) {

                                    mRewardedAd2 = rewardedAd;

                                }
                            });
                    break;


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void LoadRewardAlienMediation(Activity activity, String selectBackupAds, String idReward, String idBackupReward) {
        try {
            
            AlienMediationAds.onLoadRewardsMediation = new OnLoadRewardsMediation() {
                @Override
                public void onRewardsAdLoaded() {
                if (onLoadRewardsMediation!=null){
                    onLoadRewardsMediation.onRewardsAdLoaded();
                }
                }

                @Override
                public void onRewardsAdClosed() {
                    if (onLoadRewardsMediation!=null){
                        onLoadRewardsMediation.onRewardsAdClosed();
                    }
                }

                @Override
                public void onRewardsAdReward() {
                    if (onLoadRewardsMediation!=null){
                        onLoadRewardsMediation.onRewardsAdReward();
                    }
                    unlockreward= true;
                }

                @Override
                public void onRewardsAdClicked() {
                    if (onLoadRewardsMediation!=null){
                        onLoadRewardsMediation.onRewardsAdClicked();
                    }
                }

                @Override
                public void onRewardsAdFailedToLoad(String error) {
                    if (onLoadRewardsMediation!=null){
                        onLoadRewardsMediation.onRewardsAdFailedToLoad("");
                    }
                }
            };
            switch (selectBackupAds) {
                case "APPLOVIN-M":
                      
                    break;
                case "MOPUB":
                case "UNITY":
                    break;
                case "APPLOVIN-D":
                      
                    break;
                case "IRON":
                    IronSource.setRewardedVideoListener(new RewardedVideoListener() {
                        @Override
                        public void onRewardedVideoAdOpened() {
                        }

                        @Override
                        public void onRewardedVideoAdClosed() {
                        }

                        @Override
                        public void onRewardedVideoAvailabilityChanged(boolean available) {
                        }

                        @Override
                        public void onRewardedVideoAdRewarded(Placement placement) {
                            unlockreward = true;
                        }

                        @Override
                        public void onRewardedVideoAdShowFailed(IronSourceError error) {
                        }

                        @Override
                        public void onRewardedVideoAdClicked(Placement placement) {
                        }

                        @Override
                        public void onRewardedVideoAdStarted() {
                        }

                        @Override
                        public void onRewardedVideoAdEnded() {
                        }
                    });
                    break;
                case "STARTAPP":
                    rewardedVideo = new StartAppAd(activity);
                    rewardedVideo.setVideoListener(new VideoListener() {
                        @Override
                        public void onVideoCompleted() {
                            unlockreward = true;
                        }
                    });

                    rewardedVideo.loadAd(StartAppAd.AdMode.REWARDED_VIDEO, new AdEventListener() {
                        @Override
                        public void onReceiveAd(com.startapp.sdk.adsbase.Ad ad) {

                        }
                        @Override
                        public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {

                        }
                    });
                    break;

                case "ADMOB" :
                    AdRequest adRequest = new AdRequest.Builder()
                            .build();
                    RewardedAd.load(activity, idBackupReward,
                            adRequest, new RewardedAdLoadCallback() {
                                @Override
                                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                    if (onLoadRewardsAdmob!=null){
                                        onLoadRewardsAdmob.onAdFailedToLoad();
                                    }
                                    mRewardedAd = null;
                                }

                                @Override
                                public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                                    if (onLoadRewardsAdmob!=null){
                                        onLoadRewardsAdmob.onAdLoaded("");
                                    }
                                    mRewardedAd = rewardedAd;

                                }
                            });
                    break;
                case "ALIEN-V":
                    AlienViewAds.RewardsAds(activity,idBackupReward);
                    AlienViewAds.onLoadRewardsView = new OnLoadRewardsView() {
                        @Override
                        public void onRewardsAdLoaded() {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdLoaded();
                            }
                        }

                        @Override
                        public void onRewardsAdClosed() {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdClosed();
                            }
                        }

                        @Override
                        public void onRewardsAdClicked() {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdClicked();
                            }
                        }

                        @Override
                        public void onRewardsAdFailedToLoad(String error) {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdFailedToLoad("");
                            }
                        }
                    };
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void LoadRewardAlienView(Activity activity, String selectBackupAds, String idReward, String idBackupReward) {
        try {
            AlienViewAds.RewardsAds(activity,idReward);
            AlienViewAds.onLoadRewardsView = new OnLoadRewardsView() {
                @Override
                public void onRewardsAdLoaded() {
               if (onLoadRewardsAlienView!=null){
                   onLoadRewardsAlienView.onRewardsAdLoaded();
               }
                }

                @Override
                public void onRewardsAdClosed() {
                    if (onLoadRewardsAlienView!=null){
                        onLoadRewardsAlienView.onRewardsAdClosed();
                    }
                }

                @Override
                public void onRewardsAdClicked() {
                    if (onLoadRewardsAlienView!=null){
                        onLoadRewardsAlienView.onRewardsAdClicked();
                    }
                }

                @Override
                public void onRewardsAdFailedToLoad(String error) {
                    if (onLoadRewardsAlienView!=null){
                        onLoadRewardsAlienView.onRewardsAdFailedToLoad("");
                    }
                }
            };
            switch (selectBackupAds) {
                case "APPLOVIN-M":
                      
                    break;
                case "MOPUB":
                case "UNITY":
                    break;
                case "APPLOVIN-D":
                      
                    break;
                case "IRON":
                    IronSource.setRewardedVideoListener(new RewardedVideoListener() {
                        @Override
                        public void onRewardedVideoAdOpened() {
                        }

                        @Override
                        public void onRewardedVideoAdClosed() {
                        }

                        @Override
                        public void onRewardedVideoAvailabilityChanged(boolean available) {
                        }

                        @Override
                        public void onRewardedVideoAdRewarded(Placement placement) {
                            unlockreward = true;
                        }

                        @Override
                        public void onRewardedVideoAdShowFailed(IronSourceError error) {
                        }

                        @Override
                        public void onRewardedVideoAdClicked(Placement placement) {
                        }

                        @Override
                        public void onRewardedVideoAdStarted() {
                        }

                        @Override
                        public void onRewardedVideoAdEnded() {
                        }
                    });
                    break;
                case "STARTAPP":
                    rewardedVideo = new StartAppAd(activity);
                    rewardedVideo.setVideoListener(new VideoListener() {
                        @Override
                        public void onVideoCompleted() {
                            unlockreward = true;
                        }
                    });

                    rewardedVideo.loadAd(StartAppAd.AdMode.REWARDED_VIDEO, new AdEventListener() {
                        @Override
                        public void onReceiveAd(com.startapp.sdk.adsbase.Ad ad) {

                        }
                        @Override
                        public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {

                        }
                    });
                    break;

                case "ADMOB" :
                    AdRequest adRequest = new AdRequest.Builder()
                            .build();
                    RewardedAd.load(activity, idBackupReward,
                            adRequest, new RewardedAdLoadCallback() {
                                @Override
                                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                    if (onLoadRewardsAdmob!=null){
                                        onLoadRewardsAdmob.onAdFailedToLoad();
                                    }
                                    mRewardedAd = null;
                                }

                                @Override
                                public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                                    if (onLoadRewardsAdmob!=null){
                                        onLoadRewardsAdmob.onAdLoaded("");
                                    }
                                    mRewardedAd = rewardedAd;

                                }
                            });
                    break;
                case "ALIEN-M" :
                    
                    AlienMediationAds.onLoadRewardsMediation = new OnLoadRewardsMediation() {
                        @Override
                        public void onRewardsAdLoaded() {

                        }

                        @Override
                        public void onRewardsAdClosed() {

                        }

                        @Override
                        public void onRewardsAdReward() {
                            unlockreward = true;
                        }

                        @Override
                        public void onRewardsAdClicked() {

                        }

                        @Override
                        public void onRewardsAdFailedToLoad(String error) {

                        }
                    };
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void LoadRewardUnity(Activity activity, String selectBackupAds, String idReward, String idBackupReward) {

    }

    public static void LoadRewardGoogleAds(Activity activity, String selectBackupAds, String idReward, String idBackupReward) {
        try {
            AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
            RewardedAd.load(activity, idReward,
                    adRequest, new RewardedAdLoadCallback() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            if (onLoadRewardsGoogle!=null){
                                onLoadRewardsGoogle.onAdFailedToLoad();
                            }
                            mRewardedAd = null;
                        }

                        @Override
                        public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                            if (onLoadRewardsGoogle!=null){
                                onLoadRewardsGoogle.onAdFailedToLoad();
                            }
                            mRewardedAd = rewardedAd;

                        }
                    });
            switch (selectBackupAds) {
                case "APPLOVIN-M":
                      
                    break;
                case "MOPUB":
                case "UNITY":

                    break;
                case "APPLOVIN-D":
                      
                    break;
                case "IRON":
                    IronSource.setRewardedVideoListener(new RewardedVideoListener() {
                        @Override
                        public void onRewardedVideoAdOpened() {
                        }

                        @Override
                        public void onRewardedVideoAdClosed() {
                        }

                        @Override
                        public void onRewardedVideoAvailabilityChanged(boolean available) {
                        }

                        @Override
                        public void onRewardedVideoAdRewarded(Placement placement) {
                            unlockreward = true;
                        }

                        @Override
                        public void onRewardedVideoAdShowFailed(IronSourceError error) {
                        }

                        @Override
                        public void onRewardedVideoAdClicked(Placement placement) {
                        }

                        @Override
                        public void onRewardedVideoAdStarted() {
                        }

                        @Override
                        public void onRewardedVideoAdEnded() {
                        }
                    });
                    break;
                case "STARTAPP":
                    rewardedVideo = new StartAppAd(activity);
                    rewardedVideo.setVideoListener(new VideoListener() {
                        @Override
                        public void onVideoCompleted() {
                            unlockreward = true;
                        }
                    });

                    rewardedVideo.loadAd(StartAppAd.AdMode.REWARDED_VIDEO, new AdEventListener() {
                        @Override
                        public void onReceiveAd(com.startapp.sdk.adsbase.Ad ad) {

                        }

                        @Override
                        public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {

                        }
                    });
                    break;
                case "ALIEN-M" :
                    
                    AlienMediationAds.onLoadRewardsMediation = new OnLoadRewardsMediation() {
                        @Override
                        public void onRewardsAdLoaded() {

                        }

                        @Override
                        public void onRewardsAdClosed() {

                        }

                        @Override
                        public void onRewardsAdReward() {
                            unlockreward = true;
                        }

                        @Override
                        public void onRewardsAdClicked() {

                        }

                        @Override
                        public void onRewardsAdFailedToLoad(String error) {

                        }
                    };
                    break;
                case "ALIEN-V":
                    AlienViewAds.RewardsAds(activity,idBackupReward);
                    AlienViewAds.onLoadRewardsView = new OnLoadRewardsView() {
                        @Override
                        public void onRewardsAdLoaded() {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdLoaded();
                            }
                        }

                        @Override
                        public void onRewardsAdClosed() {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdClosed();
                            }
                        }

                        @Override
                        public void onRewardsAdClicked() {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdClicked();
                            }
                        }

                        @Override
                        public void onRewardsAdFailedToLoad(String error) {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdFailedToLoad("");
                            }
                        }
                    };
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void LoadRewardApplovinMax(Activity activity, String selectBackupAds, String idReward, String idBackupReward) {
        

    }

    public static void LoadRewardApplovinDis(Activity activity, String selectBackupAds, String idReward, String idBackupReward) {
       
    }

    public static void LoadRewardMopub(Activity activity, String selectBackupAds, String idReward, String idBackupReward) {

    }

    public static void LoadRewardIron(Activity activity, String selecBackuptAds, String idReward, String idBackupReward) {
        try {
            IronSource.setRewardedVideoListener(new RewardedVideoListener() {
                @Override
                public void onRewardedVideoAdOpened() {
                    if (onLoadRewardsIronSource!=null){
                        onLoadRewardsIronSource.onRewardedVideoAdOpened();
                    }
                }

                @Override
                public void onRewardedVideoAdClosed() {
                    if (onLoadRewardsIronSource!=null){
                        onLoadRewardsIronSource.onRewardedVideoAdClosed();
                    }
                }

                @Override
                public void onRewardedVideoAvailabilityChanged(boolean available) {
                    if (onLoadRewardsIronSource!=null){
                        onLoadRewardsIronSource.onRewardedVideoAvailabilityChanged();
                    }
                }

                @Override
                public void onRewardedVideoAdRewarded(Placement placement) {
                    if (onLoadRewardsIronSource!=null){
                        onLoadRewardsIronSource.onRewardedVideoAdRewarded();
                    }
                    unlockreward = true;
                }

                @Override
                public void onRewardedVideoAdShowFailed(IronSourceError error) {
                    if (onLoadRewardsIronSource!=null){
                        onLoadRewardsIronSource.onRewardedVideoAdShowFailed();
                    }
                    switch (selecBackuptAds) {
                        case "GOOGLE-ADS":
                        case "ADMOB":
                            if (mRewardedAd != null) {
                                Activity activityContext = activity;
                                mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                                    @Override
                                    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                        unlockreward = true;
                                    }
                                });
                            }
                            break;
                        case "MOPUB":
                        case "UNITY":

                            break;
                        case "APPLOVIN-M":
                              
                            break;
                        case "APPLOVIN-D":
                             
                            break;
                        case "STARTAPP":
                            rewardedVideo.showAd();
                            break;
                        case "ALIEN-V":
                            AlienViewAds.ShowRewards();
                            unlockreward = true;
                            break;
                        case "ALIEN-M":
                            break;

                    }
                }

                @Override
                public void onRewardedVideoAdClicked(Placement placement) {
                    if (onLoadRewardsIronSource!=null){
                        onLoadRewardsIronSource.onRewardedVideoAdClicked();
                    }
                }

                @Override
                public void onRewardedVideoAdStarted() {
                    if (onLoadRewardsIronSource!=null){
                        onLoadRewardsIronSource.onRewardedVideoAdStarted();
                    }
                }

                @Override
                public void onRewardedVideoAdEnded() {
                    if (onLoadRewardsIronSource!=null){
                        onLoadRewardsIronSource.onRewardedVideoAdEnded();
                    }
                }
            });
            switch (selecBackuptAds) {
                case "ADMOB":
                case "GOOGLE-ADS":
                    AdRequest adRequest = new AdRequest.Builder()

                            .build();
                    RewardedAd.load(activity, idBackupReward,
                            adRequest, new RewardedAdLoadCallback() {
                                @Override
                                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                    mRewardedAd = null;
                                }

                                @Override
                                public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                                    mRewardedAd = rewardedAd;

                                }
                            });
                    break;
                case "APPLOVIN-D":
                      
                    break;
                case "APPLOVIN-M":
                      

                    break;
                case "MOPUB":
                case "UNITY":

                    break;
                case "STARTAPP":
                    rewardedVideo = new StartAppAd(activity);
                    rewardedVideo.setVideoListener(new VideoListener() {
                        @Override
                        public void onVideoCompleted() {
                            unlockreward = true;
                        }
                    });

                    rewardedVideo.loadAd(StartAppAd.AdMode.REWARDED_VIDEO, new AdEventListener() {
                        @Override
                        public void onReceiveAd(com.startapp.sdk.adsbase.Ad ad) {

                        }

                        @Override
                        public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {

                        }
                    });
                    break;
                case "ALIEN-M" :
                    
                    AlienMediationAds.onLoadRewardsMediation = new OnLoadRewardsMediation() {
                        @Override
                        public void onRewardsAdLoaded() {

                        }

                        @Override
                        public void onRewardsAdClosed() {

                        }

                        @Override
                        public void onRewardsAdReward() {
                            unlockreward = true;
                        }

                        @Override
                        public void onRewardsAdClicked() {

                        }

                        @Override
                        public void onRewardsAdFailedToLoad(String error) {

                        }
                    };
                    break;
                case "ALIEN-V":
                    AlienViewAds.RewardsAds(activity,idBackupReward);
                    AlienViewAds.onLoadRewardsView = new OnLoadRewardsView() {
                        @Override
                        public void onRewardsAdLoaded() {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdLoaded();
                            }
                        }

                        @Override
                        public void onRewardsAdClosed() {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdClosed();
                            }
                        }

                        @Override
                        public void onRewardsAdClicked() {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdClicked();
                            }
                        }

                        @Override
                        public void onRewardsAdFailedToLoad(String error) {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdFailedToLoad("");
                            }
                        }
                    };
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void LoadRewardStartApp(Activity activity, String selectBackupAds, String idReward, String idBackupReward) {
        try {
            rewardedVideo = new StartAppAd(activity);
            rewardedVideo.setVideoListener(new VideoListener() {
                @Override
                public void onVideoCompleted() {
                    if (onLoadRewardsStartApp!=null){
                        onLoadRewardsStartApp.onVideoCompleted();
                    }
                    unlockreward = true;
                }
            });

            rewardedVideo.loadAd(StartAppAd.AdMode.REWARDED_VIDEO, new AdEventListener() {
                @Override
                public void onReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
                    if (onLoadRewardsStartApp!=null){
                        onLoadRewardsStartApp.onReceiveAd();
                    }

                }

                @Override
                public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
                    if (onLoadRewardsStartApp!=null){
                        onLoadRewardsStartApp.onFailedToReceiveAd();
                    }
                }
            });
            switch (selectBackupAds) {
                case "ADMOB":
                case "GOOGLE-ADS":
                    AdRequest adRequest = new AdRequest.Builder()

                            .build();
                    RewardedAd.load(activity, idBackupReward,
                            adRequest, new RewardedAdLoadCallback() {
                                @Override
                                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                    mRewardedAd = null;
                                }

                                @Override
                                public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                                    mRewardedAd = rewardedAd;

                                }
                            });
                    break;
                case "APPLOVIN-D":
                      
                    break;
                case "APPLOVIN-M":
                      

                    break;
                case "MOPUB":

                case "UNITY":

                    break;
                case "IRON":
                    IronSource.setRewardedVideoListener(new RewardedVideoListener() {
                        @Override
                        public void onRewardedVideoAdOpened() {
                        }

                        @Override
                        public void onRewardedVideoAdClosed() {
                        }

                        @Override
                        public void onRewardedVideoAvailabilityChanged(boolean available) {
                        }

                        @Override
                        public void onRewardedVideoAdRewarded(Placement placement) {
                            unlockreward = true;
                        }

                        @Override
                        public void onRewardedVideoAdShowFailed(IronSourceError error) {
                        }

                        @Override
                        public void onRewardedVideoAdClicked(Placement placement) {
                        }

                        @Override
                        public void onRewardedVideoAdStarted() {
                        }

                        @Override
                        public void onRewardedVideoAdEnded() {
                        }
                    });
                    break;
                case "ALIEN-M" :
                    
                    AlienMediationAds.onLoadRewardsMediation = new OnLoadRewardsMediation() {
                        @Override
                        public void onRewardsAdLoaded() {

                        }

                        @Override
                        public void onRewardsAdClosed() {

                        }

                        @Override
                        public void onRewardsAdReward() {
                            unlockreward = true;
                        }

                        @Override
                        public void onRewardsAdClicked() {

                        }

                        @Override
                        public void onRewardsAdFailedToLoad(String error) {

                        }
                    };
                    break;
                case "ALIEN-V":
                    AlienViewAds.RewardsAds(activity,idBackupReward);
                    AlienViewAds.onLoadRewardsView = new OnLoadRewardsView() {
                        @Override
                        public void onRewardsAdLoaded() {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdLoaded();
                            }
                        }

                        @Override
                        public void onRewardsAdClosed() {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdClosed();
                            }
                        }

                        @Override
                        public void onRewardsAdClicked() {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdClicked();
                            }
                        }

                        @Override
                        public void onRewardsAdFailedToLoad(String error) {
                            if (onLoadRewardsAlienView!=null){
                                onLoadRewardsAlienView.onRewardsAdFailedToLoad("");
                            }
                        }
                    };
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void ShowRewardAdmob(Activity activity, String selecBackuptAds, String idReward, String idBackupReward) {
        try {
            if (mRewardedAd != null) {
                Activity activityContext = activity;
                mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                    @Override
                    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                        if (onShowRewardsAdmob!=null){
                            onShowRewardsAdmob.onUserEarnedReward();
                        }
                        unlockreward = true;
                        LoadRewardAdmob(activity, selecBackuptAds, idReward, idBackupReward);
                    }
                });
            } else {
                switch (selecBackuptAds) {
                    case "APPLOVIN-M":
                          
                        break;
                    case "MOPUB":
                    case "UNITY":

                        break;
                    case "APPLOVIN-D":
                          
                        break;
                    case "IRON":
                        IronSource.showRewardedVideo(idBackupReward);
                        break;
                    case "STARTAPP":
                        if (rewardedVideo.isReady()) {
                            rewardedVideo.showAd();
                        }
                        break;
                    case "ALIEN-V":
                        AlienViewAds.ShowRewards();
                        AlienViewAds.onShowRewardsView = new OnShowRewardsView() {
                            @Override
                            public void onAdSuccess() {
                                if (onShowRewardsAlienView != null) {
                                    onShowRewardsAlienView.onAdSuccess();
                                }
                                unlockreward = true;
                            }

                            @Override
                            public void onAdFailedShow() {
                                if (onShowRewardsAlienView != null) {
                                    onShowRewardsAlienView.onAdSuccess();
                                }
                            }
                        };
                        break;
                    case "ALIEN-M":
                        
                        break;

                    case "ADMOB":
                        if (mRewardedAd2 != null) {
                            Activity activityContext = activity;
                            mRewardedAd2.show(activityContext, new OnUserEarnedRewardListener() {
                                @Override
                                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                    unlockreward = true;
                                }
                            });
                        }
                        break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoadRewardAdmob(activity, selecBackuptAds, idReward, idBackupReward);
    }

    public static void ShowRewardGoogleAds(Activity activity, String selecBackuptAds, String idReward, String idBackupReward) {
        try {
            if (mRewardedAd != null) {
                Activity activityContext = activity;
                mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                    @Override
                    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                        if (onShowRewardsGoogle!=null){
                            onShowRewardsGoogle.onUserEarnedReward();
                        }
                        unlockreward = true;
                        LoadRewardGoogleAds(activity, selecBackuptAds, idReward, idBackupReward);
                    }
                });
            } else {
                switch (selecBackuptAds) {
                    case "APPLOVIN-M":
                          
                        break;
                    case "MOPUB":
                    case "UNITY":

                        break;
                    case "APPLOVIN-D":
                          
                        break;
                    case "IRON":
                        IronSource.showRewardedVideo(idBackupReward);
                        break;
                    case "STARTAPP":
                        if (rewardedVideo.isReady()) {
                            rewardedVideo.showAd();
                        }
                        break;
                    case "ALIEN-V":
                        AlienViewAds.ShowRewards();
                        AlienViewAds.onShowRewardsView = new OnShowRewardsView() {
                            @Override
                            public void onAdSuccess() {
                                if (onShowRewardsAlienView != null) {
                                    onShowRewardsAlienView.onAdSuccess();
                                }
                                unlockreward = true;
                            }

                            @Override
                            public void onAdFailedShow() {
                                if (onShowRewardsAlienView != null) {
                                    onShowRewardsAlienView.onAdSuccess();
                                }
                            }
                        };
                        break;
                    case "ALIEN-M":
                        
                        break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoadRewardGoogleAds(activity, selecBackuptAds, idReward, idBackupReward);
    }

    public static void ShowRewardApplovinMax(Activity activity, String selecBackuptAds, String idReward, String idBackupReward) {
       
    }

    public static void ShowRewardApplovinDis(Activity activity, String selecBackuptAds, String idReward, String idBackupReward) {
      
    }

    public static void ShowRewardMopub(Activity activity, String selecBackuptAds, String idReward, String idBackupReward) {

    }

    public static void ShowRewardIron(Activity activity, String selecBackuptAds, String idReward, String idBackupReward) {
        try {
            IronSource.showRewardedVideo(idBackupReward);
            LoadRewardIron(activity, selecBackuptAds, idReward, idBackupReward);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void ShowRewardUnity(Activity activity, String selecBackuptAds, String idReward, String idBackupReward) {
    }

    public static void ShowRewardStartApp(Activity activity, String selecBackuptAds, String idReward, String idBackupReward) {
        try {
            if (rewardedVideo.isReady()) {
                rewardedVideo.showAd();
                LoadRewardStartApp(activity, selecBackuptAds, idReward, idBackupReward);
            } else {
                switch (selecBackuptAds) {
                    case "APPLOVIN-M":
                          
                        break;
                    case "MOPUB":
                    case "UNITY":

                        break;
                    case "APPLOVIN-D":
                          
                        break;
                    case "IRON":
                        IronSource.showRewardedVideo(idBackupReward);
                        break;
                    case "GOOGLE-ADS":
                    case "ADMOB":
                        if (mRewardedAd != null) {
                            Activity activityContext = activity;
                            mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                                @Override
                                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                    unlockreward = true;
                                }
                            });
                        }
                        break;
                    case "ALIEN-V":
                        AlienViewAds.ShowRewards();
                        AlienViewAds.onShowRewardsView = new OnShowRewardsView() {
                            @Override
                            public void onAdSuccess() {
                                if (onShowRewardsAlienView != null) {
                                    onShowRewardsAlienView.onAdSuccess();
                                }
                                unlockreward = true;
                            }

                            @Override
                            public void onAdFailedShow() {
                                if (onShowRewardsAlienView != null) {
                                    onShowRewardsAlienView.onAdSuccess();
                                }
                            }
                        };
                        break;
                    case "ALIEN-M":
                        
                        break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoadRewardStartApp(activity, selecBackuptAds, idReward, idBackupReward);
    }

    public static void ShowRewardAlienView(Activity activity, String selecBackuptAds, String idReward, String idBackupReward) {
        try {
            AlienViewAds.ShowRewards();
            AlienViewAds.onShowRewardsView = new OnShowRewardsView() {
                @Override
                public void onAdSuccess() {
                    if (onShowRewardsAlienView!=null){
                        onShowRewardsAlienView.onAdSuccess();
                    }
                    unlockreward = true;
                }

                @Override
                public void onAdFailedShow() {
                    if (onShowRewardsAlienView!=null){
                        onShowRewardsAlienView.onAdSuccess();
                    }
                    switch (selecBackuptAds) {
                        case "APPLOVIN-M":
                              
                            break;
                        case "MOPUB":
                        case "UNITY":

                            break;
                        case "APPLOVIN-D":
                             
                            break;
                        case "IRON":
                            IronSource.showRewardedVideo(idBackupReward);
                            break;
                        case "GOOGLE-ADS":
                        case "ADMOB":
                            if (mRewardedAd != null) {
                                Activity activityContext = activity;
                                mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                                    @Override
                                    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                        unlockreward = true;
                                    }
                                });
                            }
                            break;
                        case "ALIEN-M":
                            
                            break;
                        case "STARTAPP":
                            if (rewardedVideo.isReady()) {
                                rewardedVideo.showAd();
                            }
                            break;
                    }
                }
            };

        } catch (Exception e) {
            e.printStackTrace();
        }
        LoadRewardAlienView(activity, selecBackuptAds, idReward, idBackupReward);
    }

    public static void ShowRewardAlienMediation(Activity activity, String selecBackuptAds, String idReward, String idBackupReward) {
        try {
            
            AlienMediationAds.onShowRewards = new OnShowRewards() {
                @Override
                public void onAdSuccess() {
                    if (onShowRewardsAlienMedition!=null){
                        onShowRewardsAlienMedition.onAdSuccess();
                    }
                    unlockreward = true;
                }

                @Override
                public void onAdFailedShow() {
                    if (onShowRewardsAlienMedition!=null){
                        onShowRewardsAlienMedition.onAdFailedShow();
                    }
                    switch (selecBackuptAds) {
                        case "APPLOVIN-M":
                              
                            break;
                        case "MOPUB":
                        case "UNITY":

                            break;
                        case "APPLOVIN-D":
                             
                            break;
                        case "IRON":
                            IronSource.showRewardedVideo(idBackupReward);
                            break;
                        case "GOOGLE-ADS":
                        case "ADMOB":
                            if (mRewardedAd != null) {
                                Activity activityContext = activity;
                                mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                                    @Override
                                    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                        unlockreward = true;
                                    }
                                });
                            }
                            break;
                        case "ALIEN-V":
                            AlienViewAds.ShowRewards();
                            AlienViewAds.onShowRewardsView = new OnShowRewardsView() {
                                @Override
                                public void onAdSuccess() {
                                    if (onShowRewardsAlienView != null) {
                                        onShowRewardsAlienView.onAdSuccess();
                                    }
                                    unlockreward = true;
                                }

                                @Override
                                public void onAdFailedShow() {
                                    if (onShowRewardsAlienView != null) {
                                        onShowRewardsAlienView.onAdSuccess();
                                    }
                                }
                            };
                            break;
                        case "STARTAPP":
                            if (rewardedVideo.isReady()) {
                                rewardedVideo.showAd();
                            }
                            break;
                    }
                }
            };

        } catch (Exception e) {
            e.printStackTrace();
        }
        LoadRewardAlienMediation(activity, selecBackuptAds, idReward, idBackupReward);
    }
}