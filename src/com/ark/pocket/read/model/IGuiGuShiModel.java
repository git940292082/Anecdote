package com.ark.pocket.read.model;

import com.ark.pocket.read.utils.QuWenCallBack;

public interface IGuiGuShiModel {
	void getGuiGuShiXiaoYuan(String name,int page, QuWenCallBack qwCallBack);
	void getGuiGuShiXiaoYuan(int page,String id, QuWenCallBack qwCallBack);
	
}
