package com.ark.pocket.read.model;

import com.ark.pocket.read.utils.QuWenCallBack;

public interface IXiaoHuaModel {
	void getXiaoHuaWenBen(int page, QuWenCallBack xhCallBack);
	void getXiaoHuaTuPian(int page, QuWenCallBack xhCallBack);
	void getXiaoHuaDongTu(int page, QuWenCallBack xhCallBack);
	
}
