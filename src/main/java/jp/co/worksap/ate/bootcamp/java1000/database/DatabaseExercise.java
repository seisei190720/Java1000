package jp.co.worksap.ate.bootcamp.java1000.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;

public class DatabaseExercise {

	/*
	 * 以下の問題に答えなさい。 但し、メソッドの定義を変更してはいけません。
	 */

	/**
	 * 問題
	 * 
	 * 以下のようなテーブルがある。
	 * 
	 * テーブル名 : syain
	 * カラム名 : 
	 * 	sya_id number(10,0) : 社員ID,
	 * 	sya_nm varchar(255) : 社員名
	 * 
	 * insertSyain メソッドで、syainId, syainName を、
	 * それぞれ、syain テーブルの sya_id, sya_nm カラムに
	 * インサートするプログラムを書きなさい。
	 * 
	 * 成功した場合は true、失敗した場合は false を返しなさい。
	 */
	public boolean insertSyain(Connection con, int syainId, String syainName) {
		return false;
	}

	/**
	 * 問題
	 * 
	 * 以下のようなテーブルがある。
	 * 
	 * テーブル名 : syain 
	 * カラム名 : 
	 * 	sya_id number(10,0) : 社員ID,
	 * 	sya_nm varchar(255) : 社員名,
	 * 	deleted number(1,0) : 削除フラグ,
	 * 	prc_date date : 更新日時
	 * 
	 * 引数に渡ってくる Date 以前の prc_date が記録されているレコードの deleted カラムを 1 に更新しなさい。
	 * 返り値には更新された行数を返しなさい。
	 * 
	 * 失敗した場合は SQLException を返しなさい。
	 */
	public int updateSyain(Connection con, Date date) throws SQLException{
		return 0;
	}


	/**
	 * 問題
	 * 
	 * 以下のようなテーブルがある。
	 * 
	 * テーブル名 : category
	 * カラム名 : 
	 * 	cat_id number(10,0) : カテゴリーID,
	 * 	cat_nm varchar(255) : カテゴリー名
	 * 
	 * このテーブルに入っているデータを全て、
	 * cat_id を key、cat_nm を value として Map に登録して返り値として返しなさい。
	 * 
	 * key は Integer オブジェクト、
	 * value は String オブジェクトとしなさい。
	 * 
	 * 失敗した場合は SQLException を返しなさい。
	 * 
	 */
	public Map<Integer, String> selectMst(Connection con) throws SQLException{
		return null;
	}

}
