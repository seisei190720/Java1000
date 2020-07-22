package jp.co.worksap.ate.bootcamp.java1000.enums;

import java.util.Locale;


public enum AnimalEnum {
	ELEPHANT,
	LION,
	GIRAFFE;
	static AnimalEnum getValue(String name){
		return valueOf(name.toUpperCase(Locale.getDefault()));
	}

}
