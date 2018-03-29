package CowBull.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by oleg on 18.07.17.
 */
public class Process extends HttpServlet {

    private static final String url = "jdbc:mysql://localhost:3306/gameCowBull";
    private static final String user = "root";
    private static final String password = "stalker";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private static int q;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String num = request.getParameter("num");
        String nump = request.getParameter("nump");
        String Email = request.getParameter("email");
        String Password = request.getParameter("password");
        String id = request.getParameter("id");
        String Login  = request.getParameter("login");
        String str = "";
        String p="";
        Integer i=0;
        Integer k = 0;
        Integer b = 0;
        Double sum=0.0, count=0.0;
        Integer cout = 0;
        Boolean flag=false;
        String Deteils="";
        analisDate myNum = new analisDate();//класс isCorrectNum проверяет нет прислал ли пользователь символы отличные от цифр, и нет ли совпадений

        if (myNum.isCorrect(num) == false){
            Deteils = "Давайте играть по правилам! пришлите пожалуйста число из четырех разных цифр!";
            request.setAttribute("name", Deteils);
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
        p = request.getParameter("p"); //кол - во попыток
        if (p != "")//если попытки уже были
            i = Integer.parseInt(p);
        else
            i = 0;//иначе пользователь пробует угадать число первый раз

        if (Integer.parseInt(num) == Integer.parseInt(nump)){//если пользователь угадал
            flag = true;
            i++;
            str = "Поздравляю!!! число угадано, нажмите кнопку рестарт для новой попытки!";
            request.setAttribute("result", str);
        }
        else {//иначе анализируем число
            i++;
            k = myNum.analisK(num, nump);//сколько цифр угадано
            b = myNum.analisB(num, nump);//сколько из них на своем месте
            //System.out.println(k);
            //System.out.println(b);
        }
        try {
            // opening database connection to MySQL server
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
           //если число не угадано, заносим попытку в базу
                stmt = con.createStatement();
                String Query5 = "INSERT INTO att (user, b, k, num) VALUES ('" + id + "', '" + b + "', '" + k + "', '" + num + "');";// getting Statement object to execute query
                q = stmt.executeUpdate(Query5);

            if(flag == true) {//иначе вносим в базу результаты пользователя*/
                stmt = con.createStatement();
                String Query6 = "INSERT INTO Attempt (user, date, NA) VALUES ('" + id + "', now(), '" + i + "');";
                q = stmt.executeUpdate(Query6);
            }
            // executing SELECT query
            stmt = con.createStatement();//вывод предыдущих попыток
            String Query1 = "SELECT num, k, b FROM att WHERE user='" + id + "' ORDER BY id DESC LIMIT 10;";
            rs = stmt.executeQuery(Query1);
            cout = 0;
            while (rs.next()) {
                cout++;
                String str2 = rs.getString(1);
                if (str2.length() != 4){
                    str2 = "0"+str2;
                }
                request.setAttribute("nc" + cout + "", str2);
                request.setAttribute("k" + cout + "", rs.getInt(2));
                request.setAttribute("b" + cout + "", rs.getInt(3));

            }
            stmt = con.createStatement();//показываем предыдущие достижения пользователя
            String Query2 = "SELECT date, NA FROM Attempt WHERE user='"+id+"' ORDER BY date DESC LIMIT 5;";
            rs = stmt.executeQuery(Query2);
            cout = 0;
            while (rs.next()){
                cout++;
                request.setAttribute("date"+cout+"", rs.getDate(1));
                request.setAttribute("NA"+cout+"", rs.getString(2));
            }
            stmt = con.createStatement();//определяем среднее кол-во попыток всех пользователей
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
        request.setAttribute("startPage", "Угадывайте число, либо нажмите кнопку рестарт ;)");
        request.setAttribute("email1", Email);
        request.setAttribute("password1", Password);
        request.setAttribute("email", Email);
        request.setAttribute("password", Password);
        request.setAttribute("id", id);
        request.setAttribute("login", Login);
        request.setAttribute("name", Login);
        request.setAttribute("N", nump);
        request.setAttribute("p", i);

        request.getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);
    }

}
