package com.snow.x5web;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 左title
 */
public class LeftTitleLayout extends FrameLayout {

    @BindView(R.id.left_back)
    ImageView leftBack;
    @BindView(R.id.left_title_tv)
    TextView leftTitleTv;
    @BindView(R.id.left_ll)
    LinearLayout leftLl;
    @BindView(R.id.middle_title_tv)
    TextView middleTitleTv;
    @BindView(R.id.right_title_tv)
    TextView rightTitleTv;
    @BindView(R.id.right_title_iv)
    ImageView rightTitleIv;
    @BindView(R.id.right_ll)
    RelativeLayout rightLl;
    private Context mContext;
    private boolean leftFinish = true;


    public LeftTitleLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView();
    }


    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        LayoutInflater.from(mContext).inflate(R.layout.left_title_layout, this);
////        setContentView(getRoot());
        View view = inflater.inflate(R.layout.left_title_layout, null, false);
        ButterKnife.bind(this, view);
        addView(view);
        leftLl.setOnClickListener(v -> {
            if (leftFinish) {
                ((Activity) mContext).finish();
            } else {
                if (specialLeftFinish != null) {
                    specialLeftFinish.specialLeftOption();
                }
            }
        });
    }

    private SpecialLeftOptionListener specialLeftFinish;

    public void setSpecialLeftFinish(SpecialLeftOptionListener specialLeftFinish) {
        this.leftFinish = false;
        this.specialLeftFinish = specialLeftFinish;
    }

    public interface SpecialLeftOptionListener {
        void specialLeftOption();
    }

    /**
     * 获取左边返回控件
     *
     * @return
     */
    public LinearLayout getLeftLlLayout() {
        return leftLl;
    }


    /**
     * 获取有右边textView
     *
     * @return
     */
    public TextView getRightTextView() {
        return rightTitleTv;
    }

    /**
     * 获取右边总布局，设置点击事件
     *
     * @return
     */
    public RelativeLayout getRightRl() {
        return rightLl;
    }

    /**
     * 获取中间textView
     *
     * @return
     */
    public TextView getTitleTextView() {
        return middleTitleTv;
    }


    public LeftTitleLayout setTitleTextColor(int color) {
        middleTitleTv.setTextColor(color);
        return this;
    }

    public LeftTitleLayout setRightTextColor(int color) {
        rightTitleTv.setTextColor(color);
        return this;
    }

    public LeftTitleLayout setRightText(String text) {
        rightTitleTv.setVisibility(VISIBLE);
        rightTitleTv.setText(text);
        return this;
    }

    public LeftTitleLayout setRightImage(int rightImg) {
        rightTitleIv.setVisibility(VISIBLE);
        rightTitleIv.setImageResource(rightImg);
        return this;
    }

    /**
     * 设置数据
     *
     * @param res   R.mipmap.xxx   R.drawable.xxxx
     * @param title
     * @return
     */
    public LeftTitleLayout item(int res, String title) {
        leftBack.setBackgroundResource(res);
        leftTitleTv.setText(title);
        return this;
    }

    /**
     * 设置是否按返回键关闭页面
     *
     * @param isFinish
     * @return
     */
    public LeftTitleLayout leftFinish(boolean isFinish) {
        this.leftFinish = isFinish;
        return this;
    }

    /**
     * 设置中间标题
     *
     * @param title
     * @return
     */
    public LeftTitleLayout setTitle(String title) {
        middleTitleTv.setText(title);
        return this;
    }

    /**
     * 改变返回按钮的颜色
     *
     * @param color R.color.xxxx
     * @return
     */
    public LeftTitleLayout setLeftColorFilter(int color) {
        leftBack.setColorFilter(getResources().getColor(color));
        return this;
    }

}
