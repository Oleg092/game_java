package CowBull.servlets;

/**
 * Created by oleg on 16.07.17.
 */

import java.sql.*;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

    public class Game extends HttpServlet{

    private static final String url = "jdbc:mysql://localhost:3306/gameCowBull";
    private static final String user = "root";
    private static final String password = "stalker";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{


        String Email = request.getParameter("Email");
        String Password = request.getParameter("Password");
        if(request.getParameter("Email") == null){
            Email = request.getParameter("email1");
            Password = request.getParameter("password1");
        }


        Integer i = 0;
        Integer id = 0;
        String login = "";
        String Query = "SELECT id, login FROM user WHERE mail='"+Email+"' AND password='"+Password+"';";
        Double count = 1.0;
        Double sum = 1.0;
        try {

            // opening database connection to MySQL server
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(Query);
            while (rs.next()) {
                id = rs.getInt(1);
                login = rs.getString(2);
            }
            stmt = con.createStatement();
            String Query2 = "SELECT date, NA FROM Attempt WHERE user='"+id+"' ORDER BY date DESC LIMIT 5;";
            rs = stmt.executeQuery(Query2);
            while (rs.next()){
                i++;
                request.setAttribute("date"+i+"", rs.getDate(1));
                request.setAttribute("NA"+i+"", rs.getString(2));
            }
            stmt = con.createStatement();
            String Query3 = "SELECT Count(*) FROM Attempt;";
            rs = stmt.executeQuery(Query3);
            while (rs.next()){
                count = rs.getDouble(1);
            }
            stmt = con.createStatement();
            String Query4 = "SELECT Sum(NA) FROM Attempt;";
            rs = stmt.executeQuery(Query4);
            while (rs.next()){
                sum = rs.getDouble(1);
            }
            request.setAttribute("S", sum/count);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        analisDate myNum = new analisDate();
        String str = myNum.createNewNum();//str получает 4х значное число с 4 разными цифрами
        request.setAttribute("startPage", "Число уже загадано для вас, попробуйте его угадать и нажмите кнопку проверить ;)");
        request.setAttribute("N", str);
        request.setAttribute("name", login);
        request.setAttribute("email", Email);
        request.setAttribute("password", Password);
        request.setAttribute("id", id);
        request.setAttribute("login", login);
        request.getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);

    }
}

