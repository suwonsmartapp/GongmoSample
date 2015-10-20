package com.example.gongmosample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.example.gongmosample.R;
import com.example.gongmosample.utils.volley.ImageLoaderPlus;
import com.example.gongmosample.utils.volley.LruBitmapCache;

/**
 * Created by junsuk on 2015. 10. 20..
 *
 * 네트워크에서 이미지를 동적으로 받아오는 Volley 예제
 */
public class VolleyFragment extends Fragment {

    private String url = "https://lh3.googleusercontent.com/kOv6jQP5i9XaRMcanCXm62-jclJNMUSlrJMFVPK3XizdXheLRZnrqLjQiymrS-Ia5bcctcm6-vtAQ7OCQrefIUWQ97A11VL0SaSwzAIhYVB4hgoDGDK49irRr-qnOnBdhQzabXCHNMoeBRXJyijW7W5sGgJvvjOcWS8nUz5xVJRe9hdq8jbPV6ET0Kf34PtU5Ep-sL0Jaiv23IdmhVA0TvQqGYtPkzycBfjFAPOQPBOsyzRRXPvHx7EZGdphWNkfBDumxH3-gnGD9osEkEAO2DDJOfRciRagwjJHSwSwFP5xfvXcNemuqy1Wvt7VDbVhw9oLocyoc67AjcKpKCQVCCIAUoJve4o3Vd44HscSxXH3oONXOxWdbFV3_ZX5rznooZL5atqTOHEURYFEmL9RO4brP7RmhsxVWEe4yvor5dPS4lLpacmNgiGehfPjyqHpmCjfL3f-kbSctcDtrApQ0sAGMleSUKRZ7is5mznzKF-ouTu4H3nKHp-trsHckjg-Z3-nCsRgInp76PU849BVaXcPj5C-XmyoQl2yOi0FkG0K=w1808-h1356-no";

    private NetworkImageView mNetworkImageView;
    private RequestQueue mQueue;
    private ImageLoaderPlus mImageLoader;

    private ProgressBar mProgressBar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_volley, container, false);
        mNetworkImageView = (NetworkImageView) view.findViewById(R.id.network_image_view);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressbar);

        mQueue = Volley.newRequestQueue(getActivity());
        mImageLoader = new ImageLoaderPlus(mQueue, new LruBitmapCache());

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageLoader.ImageListener listener = ImageLoaderPlus.getImageListener(mNetworkImageView, mProgressBar, 0);
        mImageLoader.get(url, listener);

        mNetworkImageView.setImageUrl(url, mImageLoader);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mQueue != null) {
            mQueue.stop();
        }

    }

    @Override
    public void onResume() {
        super.onResume();

        if (mQueue != null) {
            mQueue.start();
        }
    }
}
