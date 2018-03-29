package CowBull.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by oleg on 17.07.17.
 */
public class Registration extends HttpServlet {

    private static final String url = "jdbc:mysql://localhost:3306/gameCowBull";
    private static final String user = "root";
    private static final String password = "stalker";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private static Integer rss;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Email = request.getParameter("Email");//получаем с формы емейл
        String Pass = request.getParameter("Password"); //получаем с формы пароль
        String Login = request.getParameter("Login"); //получаем с формы логин
        String Query = "INSERT INTO user (mail, login, password) VALUES ('"+Email+"', '"+Login+"', '"+Pass+"');"; //запрос в бд
        String Query2 = "SELECT * FROM user WHERE mail= '"+Email+"';";
        String Deteils;

        if (Email == "" || Pass == "" || Login == ""){
            Deteils = "Форма заполнена не корректно, пожалуйста заполните ВСЕ поля формы!";
            request.setAttribute("name", Deteils);
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
        else {

            try {

                // opening database connection to MySQL server
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // getting Statement object to execute query
                stmt = con.createStatement();
                rs = stmt.executeQuery(Query2);
                if (rs.next() == true){
                    Deteils = "Пользователь с таким Email уже зарегистрирован";
                    request.setAttribute("name", Deteils);
                    request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
                }
                else{
                    rss = stmt.executeUpdate(Query);
                    if (rss == 1){
                        request.getRequestDispatcher("/Game").forward(request, response);
                    }
                    else{
                        request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
                    }
                }



            }
            catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                //close connection ,stmt and resultset here
                try { con.close(); } catch(SQLException se) { /*can't do anything */ }
                try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            }


        }
    }
}
