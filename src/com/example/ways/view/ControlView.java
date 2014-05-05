package com.example.ways.view;

import java.lang.reflect.TypeVariable;

import com.example.ways.R;
import com.example.ways.debug.LogApi;
import com.example.ways.utils.ConfigUtil;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.TranslateAnimation;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 负责界面转换的视图
 * @author 胡硕
 * time 20140428 0:38
 */
public class ControlView extends LinearLayout implements OnTouchListener{
	private AbsoluteLayout ll_switch;
	private LinearLayout ll_content;
	private Context mContext;
	private TextView tv_home;
	private TextView tv_friend;
	private TextView tv_framily;
	private TextView tv_love;
	private TextView tv_more;
	
	private ImageView im_switch;
	private int history_id = 1;
	private final String TAG = "ControlView";
	public ControlView(Context context) {
		super(context);
		this.mContext = context;
		InitView();
	}
	/**********************
	 * 函数：初始化界面
	 *********************/
	private void InitView(){
		this.setOrientation(LinearLayout.VERTICAL);
		ll_switch = new AbsoluteLayout(mContext);
		ll_switch.setBackgroundResource(R.drawable.control_bottom_bg);
		ll_content = new LinearLayout(mContext);
		im_switch = new ImageView(mContext);
		
		setContetView(1);
		setControlView();

	}
	/*********************************
	 * 函数：设置内容界面布局
	 * @param id -- 显示布局的id
	 ********************************/
	private void setContetView(int id){
		AbsoluteLayout.LayoutParams llp_control_view_bottom = new AbsoluteLayout.LayoutParams(
				ConfigUtil.getInstance().getScreen_width() / 5,
				ConfigUtil.getInstance().getScreen_width() * 15 / 720, 
				ConfigUtil.getInstance().getScreen_width() / 5 * (id - 1), 
				ConfigUtil.getInstance().getScreen_width() * 80 / 720);
		TranslateAnimation mAnimation = new TranslateAnimation(0,(id-history_id)*ConfigUtil.getInstance().getScreen_width() / 5, 0, 0);
		mAnimation.setDuration(500);
		mAnimation.setFillAfter(true);
		im_switch.setBackgroundResource(R.drawable.control_which_3);
//		history_id = id;
		im_switch.setId(id);
		history_id = id;
		im_switch.startAnimation(mAnimation);
//		im_switch.setLayoutParams(llp_control_view_bottom);
		if(id == 1){
			HomeView home = new HomeView(mContext);
			ll_content.addView(home);
		}
	}
	
	/****************************
	 * 函数：设置底部导航栏
	 */
	private void setControlView(){
		tv_home = new TextView(mContext);
		tv_home.setText(R.string.home);
		tv_home.setTextSize(TypedValue.COMPLEX_UNIT_PX, ConfigUtil.getInstance().getScreen_width() / 25);
		tv_home.setGravity(Gravity.CENTER);
		
		tv_friend = new TextView(mContext);
		tv_friend.setText(R.string.friend);
		tv_friend.setTextSize(TypedValue.COMPLEX_UNIT_PX, ConfigUtil.getInstance().getScreen_width() / 25);
		tv_friend.setGravity(Gravity.CENTER);
		
		tv_framily = new TextView(mContext);
		tv_framily.setText(R.string.framily);
		tv_framily.setTextSize(TypedValue.COMPLEX_UNIT_PX, ConfigUtil.getInstance().getScreen_width() / 25);
		tv_framily.setGravity(Gravity.CENTER);
		
		tv_love = new TextView(mContext);
		tv_love.setText(R.string.love);
		tv_love.setTextSize(TypedValue.COMPLEX_UNIT_PX, ConfigUtil.getInstance().getScreen_width() / 25);
		tv_love.setGravity(Gravity.CENTER);
		
		tv_more = new TextView(mContext);
		tv_more.setText(R.string.more);
		tv_more.setTextSize(TypedValue.COMPLEX_UNIT_PX, ConfigUtil.getInstance().getScreen_width() / 25);
		tv_more.setGravity(Gravity.CENTER);
		
		AbsoluteLayout.LayoutParams llp_control_home = new AbsoluteLayout.LayoutParams(

				ConfigUtil.getInstance().getScreen_width() / 5,ConfigUtil.getInstance().getScreen_width() * 90 / 720,
				0, 0);
		AbsoluteLayout.LayoutParams llp_control_friend = new AbsoluteLayout.LayoutParams(
				ConfigUtil.getInstance().getScreen_width() / 5, ConfigUtil.getInstance().getScreen_width() * 90 / 720,
				ConfigUtil.getInstance().getScreen_width() / 5, 0);
		AbsoluteLayout.LayoutParams llp_control_framily = new AbsoluteLayout.LayoutParams(
				ConfigUtil.getInstance().getScreen_width() / 5, ConfigUtil.getInstance().getScreen_width() * 90 / 720,
				ConfigUtil.getInstance().getScreen_width() / 5 * 2, 0);
		AbsoluteLayout.LayoutParams llp_control_love = new AbsoluteLayout.LayoutParams(
				ConfigUtil.getInstance().getScreen_width() / 5,ConfigUtil.getInstance().getScreen_width() * 90 / 720,
				ConfigUtil.getInstance().getScreen_width() / 5 * 3, 0);
		AbsoluteLayout.LayoutParams llp_control_more = new AbsoluteLayout.LayoutParams(
				ConfigUtil.getInstance().getScreen_width() / 5, ConfigUtil.getInstance().getScreen_width() * 90 / 720,
				ConfigUtil.getInstance().getScreen_width() / 5 * 4, 0);
		
		AbsoluteLayout.LayoutParams llp_control_view_bottom = new AbsoluteLayout.LayoutParams(
				ConfigUtil.getInstance().getScreen_width() / 5, ConfigUtil.getInstance().getScreen_width() * 10 / 720,
				0, ConfigUtil.getInstance().getScreen_width() * 80 / 720);
		
		LinearLayout.LayoutParams llp_control = new LinearLayout.LayoutParams(
				ConfigUtil.getInstance().getScreen_width(), ConfigUtil.getInstance().getScreen_width() * 90 / 720);
		LinearLayout.LayoutParams llp_content = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT,1);
		
		ll_switch.addView(tv_home, llp_control_home);
		ll_switch.addView(tv_friend, llp_control_friend);
		ll_switch.addView(tv_framily, llp_control_framily);
		ll_switch.addView(tv_love, llp_control_love);
		ll_switch.addView(tv_more, llp_control_more);
		
		this.addView(ll_content, llp_content);
		this.addView(ll_switch, llp_control);
		
		
		im_switch.setBackgroundResource(R.drawable.control_which_3);
		im_switch.setLayoutParams(llp_control_view_bottom);
		ll_switch.addView(im_switch);
		LogApi.Msg(TAG, "==========="+ConfigUtil.getInstance().getScreen_width());
		
		tv_home.setId(1);
		tv_friend.setId(2);
		tv_framily.setId(3);
		tv_love.setId(4);
		tv_more.setId(5);
		
		tv_home.setOnTouchListener(this);
		tv_friend.setOnTouchListener(this);
		tv_framily.setOnTouchListener(this);
		tv_love.setOnTouchListener(this);
		tv_more.setOnTouchListener(this);
	}
	@Override
	public boolean onTouch(View view, MotionEvent event) {
		if(event.getX()>0&&event.getY()>0&&event.getX()<view.getWidth()&&event.getY()<view.getHeight()){
			int id = view.getId();
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				LogApi.Msg(TAG, "++++++++++++++"+id);
				break;
			case MotionEvent.ACTION_UP:
				LogApi.Msg(TAG, "++++++++++++++"+id);
				if(id != 0){
					setContetView(id);
				}
				break;
			default:
				break;
			}
		}
			return true;
		}
}

