package application;

import db.DB;
import db.DBIntegrityException;
import db.DbException;

import java.sql.*;


public class Program {
    public static void main(String[] args) {
        Connection conn = null;

        conn.setAutoCommit(false);

        Statement st = null;
        try {
            conn = DB.getConnection();
            st = conn.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            /* fake error
            int x = 1;
            if (x<2) {
                throw new SQLException("Fake error");
            }
            */

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");


            conn.commit();

            System.out.println("rows1 " + rows1);
            System.out.println("rows2 " + rows2);

        }
        catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error trying to roll back! Caused by: " + e1.getMessage());
            }
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
