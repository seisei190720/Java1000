package jp.co.worksap.ate.bootcamp.java1000.interfaces;

/**
 * 作詞・作曲をする人を表したインターフェースです。
 * 
 * @author ATE
 *
 */
public interface SongWriter {
	/**
	 * 作詞・作曲を行います。
	 * 
	 * @return 作詞・作曲した曲名
	 */
	String writeScore();
}
