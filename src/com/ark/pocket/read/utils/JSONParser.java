package com.ark.pocket.read.utils;

import org.json.JSONException;
import org.json.JSONObject;

import com.ark.pocket.read.entity.user.User;



/**
 * Created by hanamingming on 16/2/23.
 */
public class JSONParser {

	public static User parseUser(JSONObject obj) throws JSONException {
		User user = new User();
		user.setEmail(obj.getString("email"));
		user.setEmailVerify(obj.getBoolean("emailVerify"));
		user.setEmailVerifyCode(obj.getString("emailVerifyCode"));
		user.setId(obj.getInt("id"));
		user.setLastLoginIp(obj.getString("lastLoginIp"));
		user.setLastLoginTime(obj.getLong("lastLoginTime"));
		user.setNickname(obj.getString("nickname"));
		user.setPassword(obj.getString("password"));
		return user;
	}

}
