package com.example.oa.identity.dto;

import com.example.oa.identity.domain.Module;

import java.util.ArrayList;
import java.util.List;


public class UserModule {
	/** 一级模块 */
	private Module firstModule;
	/** 二级模块 */
	private List<Module> secondModules = new ArrayList<>();
	
	public Module getFirstModule() {
		return firstModule;
	}
	public void setFirstModule(Module firstModule) {
		this.firstModule = firstModule;
	}
	public List<Module> getSecondModules() {
		return secondModules;
	}
	public void setSecondModules(List<Module> secondModules) {
		this.secondModules = secondModules;
	}
	
	
	
}
