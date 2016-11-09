package com.ark.pocket.read.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.ark.pocket.read.R;
import com.ark.pocket.read.adapter.CaiMiFenLeiAdapter;
import com.ark.pocket.read.entity.cm.CMContentlist;
import com.ark.pocket.read.entity.cm.CMRoot;
import com.ark.pocket.read.entity.cm.MiYuLeiXing;
import com.ark.pocket.read.model.ICaiMiModel;
import com.ark.pocket.read.model.imp.CaiMiModel;
import com.ark.pocket.read.utils.QuWenCallBack;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class CaiMiActivity extends Activity implements OnClickListener {
	@ViewInject(R.id.tv_riddle_name)
	TextView tvName;
	@ViewInject(R.id.tv_riddle_random_content)
	TextView tvContent;
	@ViewInject(R.id.tv_riddle_answer)
	TextView tvAnswer;
	@ViewInject(R.id.bt_riddle_answer)
	Button btAnswer;
	@ViewInject(R.id.bt_riddle_next)
	Button btNext;
	@ViewInject(R.id.gv_riddle)
	GridView gvRiddle;

	ICaiMiModel cmModel;
	Random random;

	// 当前随机谜语
	CMContentlist randomCurrent;

	List<CMContentlist> randomLists;

	//
	CaiMiFenLeiAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cai_mi);
		x.view().inject(this);
		cmModel = new CaiMiModel();
		random = new Random();
		randomLists = new ArrayList<CMContentlist>();
		// 加载随机谜语
		LoadCM();

		setListeners();
		setAdapter();

	}

	private void setAdapter() {
		cmModel.getMiYuLeiXing(new QuWenCallBack() {

			@Override
			public void onError(Object error) {

			}

			@Override
			public void loaderQuWen(Object object) {
				if (object != null) {
					CMRoot cmRoot = (CMRoot) object;
					adapter = new CaiMiFenLeiAdapter(getApplicationContext(),
							cmRoot.getShowapi_res_body().getTypeList());
					gvRiddle.setAdapter(adapter);
				}
			}
		});
	}

	private void setListeners() {
		btAnswer.setOnClickListener(this);
		btNext.setOnClickListener(this);

	}

	private void LoadCM() {
		cmModel.getRandomCaiMiXiaoYuan(new QuWenCallBack() {

			@Override
			public void loaderQuWen(Object object) {
				if (object != null) {
					CMRoot cmRoot = (CMRoot) object;
					randomLists = cmRoot.getShowapi_res_body().getPagebean().getContentlist();
					randomCurrent = randomLists.get(random.nextInt(randomLists.size()));
					tvName.setText(randomCurrent.getTypeName());
					tvContent.setText(randomCurrent.getTitle());
					tvAnswer.setText(randomCurrent.getAnswer());

				}
			}

			@Override
			public void onError(Object error) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_riddle_answer:
			tvAnswer.setVisibility(View.VISIBLE);
			break;

		case R.id.bt_riddle_next:
			LoadCM();
			tvAnswer.setVisibility(View.INVISIBLE);
			break;

		}
	}

}
