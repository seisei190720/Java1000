package jp.co.worksap.ate.bootcamp.java1000.interfaces.practice3;

/**
 * インターフェースの多重実装をしましょう。
 *
 * 問題
 *
 * {@link Singer} インターフェースと {@link SongWriter} インターフェースを実装した
 * クラス {@link SingerSongWriter} を作成してください。
 *
 * @author ATE
 *
 */
public class SingerSongWriter implements Singer, SongWriter {
	@Override
	public String writeScore() {
		return "New score updateded";
	}

	@Override
	public void sing() {
		// なんか歌う
	}

}
