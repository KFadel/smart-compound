package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import ch.qos.logback.classic.Logger;

import com.ntgclarity.smartcompound.common.constatnt.MessagesKeys;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.exception.SmartCompoundException;
import com.ntgclarity.smartcompound.portal.base.BaseBean;
import com.ntgclarity.smartcompound.portal.exceptionhandling.CustomExceptionHandler;
import com.ntgclarity.smartcompound.portal.utils.WebUtils;

@ManagedBean
@ViewScoped
public class LoginBean extends BaseBean implements Serializable {

	@ManagedProperty(value = "#{customAuthenticationProvider}")
	private AuthenticationProvider authenticationProvider;

	private String userName;
	private String password;
	private String rememberMe;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}


	private static final long serialVersionUID = 1L;

	public void login() throws SmartCompoundException {

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userName, password);

		Authentication authentcation = authenticationProvider
				.authenticate(usernamePasswordAuthenticationToken);

		SecurityContextHolder.getContext().setAuthentication(authentcation);
		WebUtils.injectIntoSession("SPRING_SECURITY_CONTEXT",
				SecurityContextHolder.getContext());

		 addInfoMessage("You have been successfully authenticated");
		System.out.println();
		throw new SmartCompoundException(
				MessagesKeys.SMART_COMPOUND_LOGIN_INFO_MSG);

	}

	public AuthenticationProvider getAuthenticationProvider() {
		return authenticationProvider;
	}

	public void setAuthenticationProvider(
			AuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}
}