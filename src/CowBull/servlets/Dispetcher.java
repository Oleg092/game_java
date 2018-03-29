package CowBull.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by oleg on 17.07.17.
 */

public class Dispetcher extends HttpServlet {

    private static final String url = "jdbc:mysql://localhost:3306/gameCowBull";
    private static final String user = "root";
    private static final String password = "stalker";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;



    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String Email = request.getParameter("Email");//получаем с формы емейл
        String Pass = request.getParameter("Password"); //получаем с формы пароль
        String Query = "SELECT * FROM user WHERE mail= '"+Email+"' AND password= '"+Pass+"';"; //запрос в бд
        String Deteils;

        if (Email == "" || Pass == ""){//пользователь что то не заполнил
            Deteils = "Форма входа заполнена не корректно! Пожалуйста заполните поля Login и Пароль!";
            request.setAttribute("name", Deteils); //вывод на страницу подробностей ошибки
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
        else{ //если пользователь ввел пару "логин: пароль" проверяем наличие такой пары в бд

            try {

                // opening database connection to MySQL server
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // getting Statement object to execute query
                stmt = con.createStatement();

                // executing SELECT query
                rs = stmt.executeQuery(Query);

                if (rs.next() == false){//запрос вернул пустой результат
                    Deteils = "Аккаунт с таким Email не зарегистрирован, либо пароль введен не верно";
                    request.setAttribute("name", Deteils);
                    request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);

                }
                else{//пользователь найден, перенаправление в игру
                    //request.setAttribute("name", rs.next());
                    request.getRequestDispatcher("/Game").forward(request, response);

                }

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


        }

    }
}
