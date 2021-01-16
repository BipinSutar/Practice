package com.bipin.practice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Meta Annotations
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
	String os() default "MAC";
	int version() default 1;

}
@SmartPhone(os = "Android", version = 2)
class MotorollaMusicSeries {
	private String modelName;
	private int screenSize;
	public String getModelName() {
		return modelName;
	}
	public int getScreenSize() {
		return screenSize;
	}
	public MotorollaMusicSeries(String modelName, int screenSize) {
		super();
		this.modelName = modelName;
		this.screenSize = screenSize;
	}
	@Override
	public String toString() {
		return "MotorollaMusicSeries [modelName=" + modelName + ", screenSize="
				+ screenSize + "]";
	}

}

public class CustomAnnotationDemo {
	public static void main(String[] args) {
		MotorollaMusicSeries motoe3 = new MotorollaMusicSeries("MOTOE3", 4);
		SmartPhone an = motoe3.getClass().getAnnotation(SmartPhone.class);
		System.out.println(an.os() + " " + an.version() + " " + an.toString());
	}
}
