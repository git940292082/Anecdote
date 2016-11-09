package com.ark.pocket.read.activity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.ark.pocket.read.R;
import com.ark.pocket.read.entity.ggs.GGSContentRoot;
import com.ark.pocket.read.entity.ggs.GuiGuShiList;
import com.ark.pocket.read.model.IGuiGuShiModel;
import com.ark.pocket.read.model.imp.GuiGuShiModel;
import com.ark.pocket.read.utils.BookPageFactory;
import com.ark.pocket.read.utils.QuWenCallBack;
import com.ark.pocket.read.view.PageWidget;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.Toast;

public class GuiGuShiWebActivity extends Activity {
	@ViewInject(R.id.tv_guigushi_web_title)
	TextView tvTitle;
	@ViewInject(R.id.tv_guigushi_web_content)
	TextView tvContent;

	IGuiGuShiModel guiGuShiModel;
	GuiGuShiList ggsList;
	GGSContentRoot ggsContentRoot;
	private int page = 1;
	private PageWidget mPageWidget;
	Bitmap mCurPageBitmap, mNextPageBitmap;
	Canvas mCurPageCanvas, mNextPageCanvas;
	BookPageFactory pagefactory;

	static String name;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		x.view().inject(this);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		guiGuShiModel = new GuiGuShiModel();
		loadGGS();
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int w = dm.widthPixels;
		int h = dm.heightPixels;
		mPageWidget = new PageWidget(this, w, h);
		setContentView(mPageWidget);

		mCurPageBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
		mNextPageBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);

		mCurPageCanvas = new Canvas(mCurPageBitmap);
		mNextPageCanvas = new Canvas(mNextPageBitmap);
		pagefactory = new BookPageFactory(w, h);
		pagefactory.setBgBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_bg1));
		try {
			name = ggsList.getTitle();
			pagefactory.openbook(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Quwen/" + name
					+ ".txt");
			pagefactory.onDraw(mCurPageCanvas);
		} catch (Exception e1) {
			e1.printStackTrace();
			Toast.makeText(this, "�ף���һ�μ���ͼ�飬��Ҫ�������½���Ŷ...", Toast.LENGTH_SHORT).show();
		}

		setLiteners();
	}

	// ��ҳ
	private void setLiteners() {
		mPageWidget.setBitmaps(mCurPageBitmap, mCurPageBitmap);
		mPageWidget.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent e) {

				boolean ret = false;
				if (v == mPageWidget) {
					if (e.getAction() == MotionEvent.ACTION_DOWN) {
						mPageWidget.abortAnimation();
						mPageWidget.calcCornerXY(e.getX(), e.getY());

						pagefactory.onDraw(mCurPageCanvas);
						if (mPageWidget.DragToRight()) {
							try {
								pagefactory.prePage();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							if (pagefactory.isfirstPage())
								return false;
							pagefactory.onDraw(mNextPageCanvas);
						} else {
							try {
								pagefactory.nextPage();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							if (pagefactory.islastPage())
								return false;
							pagefactory.onDraw(mNextPageCanvas);
						}
						mPageWidget.setBitmaps(mNextPageBitmap, mNextPageBitmap);
					}

					ret = mPageWidget.doTouchEvent(e);
					return ret;
				}
				return false;
			}

		});
	}

	// ���ع��������
	private void loadGGS() {
		Intent intent = getIntent();
		ggsList = (GuiGuShiList) intent.getSerializableExtra("ggs");
		xiaoyuan();

	}

	// ʹ�õݹ��ȡ����ҳ������
	StringBuffer buffer = new StringBuffer();

	public void xiaoyuan() {

		guiGuShiModel.getGuiGuShiXiaoYuan(page, ggsList.getId(), new QuWenCallBack() {
			@Override
			public void loaderQuWen(Object object) {
				ggsContentRoot = (GGSContentRoot) object;

				if (ggsContentRoot.getShowapi_res_body() != null) {
					String ggsContent = ggsContentRoot.getShowapi_res_body().getText();
					if (ggsContent != null) {
						String ggs = ggsContent.replace("&nbsp;", "  ").replace("shoye_336();\r\n", "     ")
								.replace("   var cpro_id = \"u535693\";", "---------------���ʼ���---------------")
								.replace("   var cpro_id = \"u138765\";", "---------------���ʼ���---------------");
						buffer.append(ggs);
						page++;
						xiaoyuan();
					} else {
						Toast.makeText(getApplicationContext(), "���ݻ�ȡʧ�ܣ���������", Toast.LENGTH_LONG).show();
					}

				} else {
					buffer.append("\n-------------------------------------------\n<(��3��)>ľ�п������������...");
					try {
						saveFile(buffer.substring(0));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}

			@Override
			public void onError(Object error) {
				// TODO Auto-generated method stub
				
			}
		});

	}

	// ���ַ������뱾��TXT�ı�
	public static void saveFile(String str) throws Exception {
		String filePath = null;
		boolean hasSDCard = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
		if (hasSDCard) {
			filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Quwen/" + name + ".txt";
		} else
			filePath = Environment.getDownloadCacheDirectory().getAbsolutePath() + "/Quwen/" + name + ".txt";

		try {
			File file = new File(filePath);
			if (!file.exists()) {
				File dir = new File(file.getParent());
				dir.mkdirs();
				file.createNewFile();
			}
			FileOutputStream outStream = new FileOutputStream(file);
			outStream.write(str.getBytes("GBK"));
			outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
