package com.ark.pocket.read.model;

import com.ark.pocket.read.entity.user.User;
import com.ark.pocket.read.utils.QuWenCallBack;

public interface IUserModel {
	
	public void register(User user, String code, QuWenCallBack callBack);
	public void imagecode(QuWenCallBack callBack);
	public void login(String loginemail,String password,QuWenCallBack callBack);
}
