package jp.co.worksap.ate.bootcamp.java1000.stream;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Channel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * リソースクローズ関数 インスタンス作成不可
 * 
 */
public class ResourceCloser {
	/**
	 * コンストラクタ（隠蔽）
	 * 
	 */
	private ResourceCloser() {
	}
	/**
	 * PreparedStatementクローズ
	 * 
	 * @param ps
	 */
	public static void close(Statement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
	}
	/**
	 * PreparedStatement&ResultSetクローズ
	 * 
	 * @param ps
	 * @param rs
	 */
	public static void close(Statement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
	}
	/**
	 * Connection&PreparedStatementクローズ
	 * @param con
	 * @param ps
	 */
	public static void close(Connection con,Statement ps){
		if(ps != null){
			try {
				ps.close();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
	}
	/**
	 * Connection&PreparedStatement&ResultSetクローズ 
	 * @param con
	 * @param ps
	 * @param rs
	 */
	public static void close(Connection con,Statement ps, ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
		if(ps != null){
			try {
				ps.close();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
	}
	/**
	 * Connectionクローズ
	 * @param con
	 */
	public static void close(Connection con){
		if(con !=null){
			try {
				con.close();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
	}
	/**
	 * ResultSetクローズ
	 * 
	 * @param rs
	 */
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
	}
	/**
	 * InputStreamクローズ
	 * 
	 * @param istream
	 */
	public static void close(InputStream istream) {
		if (istream != null) {
			try {
				istream.close();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
	}
	/**
	 * Readerクローズ
	 * 
	 * @param rd
	 */
	public static void close(Reader rd) {
		if (rd != null) {
			try {
				rd.close();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
	}
	/**
	 * OutputStreamクローズ
	 * 
	 * @param ostream
	 */
	public static void close(OutputStream ostream) {
		if (ostream != null) {
			try {
				ostream.close();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
	}
	/**
	 * Writerクローズ
	 * 
	 * @param wr
	 */
	public static void close(Writer wr) {
		if (wr != null) {
			try {
				wr.close();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
	}
	/**
	 * ServerSocketクローズ
	 * @param svSoc
	 */
	public static void close(ServerSocket svSoc) {
		if(svSoc != null){
			try {
				svSoc.close();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
	}
	/**
	 * Socketクローズ
	 * @param cliSoc
	 */
	public static void close(Socket cliSoc) {
		if(cliSoc != null){
			try {
				cliSoc.close();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}

	}
	/**
	 * Channelクローズ
	 * @param ch
	 */
	public static void close(Channel ch) {
		if(ch != null){
			try {
				ch.close();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
	}
}
