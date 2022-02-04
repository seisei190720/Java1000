package jp.co.worksap.ate.bootcamp.java1000.interfaces.practice3;

import jp.co.worksap.ate.bootcamp.java1000.interfaces.practice3.Singer;
import jp.co.worksap.ate.bootcamp.java1000.interfaces.practice3.SingerSongWriter;
import jp.co.worksap.ate.bootcamp.java1000.interfaces.practice3.SongWriter;
import junit.framework.TestCase;

public class SingerSongWriterTest extends TestCase {
	public void testSinger() {
		SingerSongWriter ssw = new SingerSongWriter();
		if (!(ssw instanceof Singer)) {
			fail("SingetSongWriter クラスに Singer インターフェースが実装されていません。");
		}
	}

	public void testSongWriter() {
		SingerSongWriter ssw = new SingerSongWriter();
		if (!(ssw instanceof SongWriter)) {
			fail("SingetSongWriter クラスに SongWriter インターフェースが実装されていません。");
		}
	}
}
