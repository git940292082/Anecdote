package com.ark.pocket.read.entity.user;

import android.graphics.Bitmap;

public class User {

	private String email;
	private String emailVerifyCode;
	private String lastLoginIp;
	private String nickname;
	private String password;
	private Bitmap icon;

	private int id;
	private int userIntegral;
	private boolean emailVerify;
	private long lastLoginTime;

	public User() {
		super();
	}

	public Bitmap getIcon() {
		return icon;
	}

	public void setIcon(Bitmap icon) {
		this.icon = icon;
	}

	public User(String email, String emailVerifyCode, String lastLoginIp, String nickname, String password, int id,
			int userIntegral, boolean emailVerify, long lastLoginTime) {
		super();
		this.email = email;
		this.emailVerifyCode = emailVerifyCode;
		this.lastLoginIp = lastLoginIp;
		this.nickname = nickname;
		this.password = password;
		this.id = id;
		this.userIntegral = userIntegral;
		this.emailVerify = emailVerify;
		this.lastLoginTime = lastLoginTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}

	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserIntegral() {
		return userIntegral;
	}

	public void setUserIntegral(int userIntegral) {
		this.userIntegral = userIntegral;
	}

	public boolean isEmailVerify() {
		return emailVerify;
	}

	public void setEmailVerify(boolean emailVerify) {
		this.emailVerify = emailVerify;
	}

	public long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

}
