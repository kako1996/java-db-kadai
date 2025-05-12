package kadai_010;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Scores_Chapter10 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner scanner = null;
		 Connection con = null;
	        Statement statement = null;
	        
	        try {
	            // データベースに接続
	            con = DriverManager.getConnection(
	                "jdbc:mysql://localhost/challenge_java",
	                "root",
	                "パスワード"
	            );
	            
	         // SQLクエリを準備
	            statement = con.createStatement();
	            String sql1 = "UPDATE scores SET score_math = '95' , score_english = '80' WHERE id = 5;";
	            String sql2 = "SELECT * FROM scores ORDER BY score_math DESC, score_english DESC";
	            
	         // SQLクエリを実行（DBMSに送信）
	            System.out.println("データベース接続成功" + statement.toString());
	            System.out.println("レコード更新を実行します");
	            int rowCnt = statement.executeUpdate(sql1);
	            System.out.println( rowCnt + "件のレコードが更新されました");
	            System.out.println("数学・英語の点数が高い順に並べ替えました");
	            ResultSet result = statement.executeQuery(sql2);
	            
	         // SQLクエリの実行結果を抽出
	            while(result.next()) {
	                int id = result.getInt("id");
	                String name = result.getString("name");
	                int score_math = result.getInt("score_math");
	                int score_english = result.getInt("score_english");
	                System.out.println(result.getRow() + "件目：id=" + id
	                                   + "／name=" + name + "／score_math =" + score_math + " /score_english =" + score_english );
	            }
	        } catch(SQLException e) {
	            System.out.println("エラー発生：" + e.getMessage());
	        } finally {
	            // 使用したオブジェクトを解放
	        	if( scanner != null ) {
	                scanner.close();
	            }
	            if( statement != null ) {
	                try { statement.close(); } catch(SQLException ignore) {}
	            }
	            if( con != null ) {
	                try { con.close(); } catch(SQLException ignore) {}
	            }
	        }
	}

}
