package jiyun.com.example.lenovo.android_svndemo_8_10;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class StartActivity extends AppCompatActivity {

    private ImageView iv_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initView();
    }

    private void initView() {
        iv_start = (ImageView) findViewById(R.id.iv_start);

        ObjectAnimator animator = ObjectAnimator.ofFloat(iv_start,"rotation",0f,-360f);
        animator.setDuration(2000);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(iv_start,"alpha",1.0f,0.0f);
        animator1.setDuration(2000);
        AnimatorSet set = new AnimatorSet();
        set.play(animator).before(animator1);
        set.setDuration(4000);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Intent intent = new Intent(StartActivity.this,MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

    }
}
