package jp.co.worksap.ate.bootcamp.java1000.codestyle;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ForLoop {

	/**
	 * 次のプログラムを拡張for文を使ったものに書き換えなさい。
	 * @param list
	 */
	public static void writeResult(List<String> list){
		for (int i = 0; i < list.size(); i++) {
			String string = list.get(i);
			System.out.println(string);
		}
	}

	/**
	 * 次のプログラムを拡張for文を使ったものに書き換えなさい。
	 * @param list
	 */
	public static void writeResult(Map<String, String> map){
		Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, String> me = itr.next();
			String keyStr = me.getKey();
			String valueStr = me.getValue();
			System.out.println(keyStr + valueStr);
		}
	}

	/**
	 * 次のプログラムを拡張for文を使ったものに書き換えなさい。
	 * @param list
	 */
	public static void writeResult(Set<String> set){
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String keyStr = itr.next();
			System.out.println(keyStr);
		}
	}

}
