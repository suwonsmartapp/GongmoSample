package com.example.gongmosample.managers;

import android.support.v4.app.Fragment;

import com.example.gongmosample.fragments.ItemFragment;
import com.example.gongmosample.fragments.LoadPictureFragment;
import com.example.gongmosample.fragments.WeatherFragment;

/**
 * Created by junsuk on 2015. 10. 15..
 *
 * Fragment 관리 클래스
 */
public class Manager {

    // TODO: 메뉴 순서대로 Fragment 를 배열로 지정
    public static Class FRAGMENTS[] = {
            ItemFragment.class,
            WeatherFragment.class,
            LoadPictureFragment.class
    };

    private Manager() {
    }

    public static Fragment getInstance(int position) {
        try {
            return (Fragment) FRAGMENTS[position].newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}
