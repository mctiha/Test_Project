package com.test.project.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.common.R;
import com.italker.common.model.Author;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * 圆形头像控件
 */

public class PortraitView extends CircleImageView {

    public PortraitView(Context context) {
        super(context);
    }

    public PortraitView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PortraitView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setup(RequestManager manager, Author author) {
        if (author == null) {
            return;
        }
        // 进行显示
        setup(manager, author.getPortrait());
    }



    public void setup(RequestManager manager, String url) {
        setup(manager, R.drawable.default_portrait, url);
    }


    public void setup(RequestManager manager, int resourceId, String url) {
        if (url == null) {
            url = "";
        }

        if (!url.startsWith("http") && !url.endsWith("?x-oss-process=style/200")) {
            url = url + "?x-oss-process=style/200";
        }

        manager.load(url)
                .apply(new RequestOptions().centerCrop()
                        .dontAnimate() // CircleImageView 控件中不能使用渐变动画，会导致显示延迟
                        .placeholder(resourceId))
                .into(this);

    }
}
