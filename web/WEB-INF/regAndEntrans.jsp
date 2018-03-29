<html>
    <head>
       <title>Игра бык-корова</title>
       <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <script type="text/javascript" src="./public/js/client.js"></script>
        <link rel="stylesheet" type="text/css" href="./public/style/style.css">

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="./public/js/jquery-2.2.1.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="./public/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1 id="title" class="lab">Добро пожаловать в игру "Бык - корова"!</h1>
        <h1 id="title" class="lab">Чтобы начать играть, пройдите процесс аутентификации, или зарегестрируйтесь"!</h1>
        <div id="inGame">
		          <div id="in">
                <h1 class="lab">Войти</h1>
                <div>
                <form action="/Dispetcher" method="GET">
                    <label for="inputEmail" class="lab">Email</label>
                    <div>
                        <input maxlength="50" type="email" name="Email" class="form-control" id="inputEmail" placeholder="Email">
                    </div>
                    </div>
                    <div>
                        <label for="inputPassword" class="lab">Пароль</label>
                        <div>
                          <input maxlength="12" type="password" name="Password" class="form-control" id="inputPassword" placeholder="Password">
                        </div>
                    </div>
                   <br><input type="submit" name"Entrans" value="Вход"></br>
                  </div>
                </form>
                <div id="reg">
                    <h1 class="lab">Регистрация</h1>
                <div>
                    <form action="/Reg" method="GET">
                        <label for="inputEmail" class="lab">Email</label>
                        <div>
                          <input maxlength="50" type="email" name="Email" class="form-control" id="inputEmail" placeholder="Email">
                        </div>
                      </div>
                      <div>
                        <label for="inputPassword" class="lab">Пароль</label>
                        <div>
                          <input maxlength="12" type="password" name="Password" class="form-control" id="inputPassword" placeholder="Password">
                        </div>
                 </div> 
                      <div>
                        </br>
                        <label for="inputLogin" class="lab">Login</label>
                        <div>
                          <input maxlength="20" type="Login" name="Login" class="form-control" id="inputLogin" placeholder="Login">
                        </div>
                 </div>      
                 </br><input type="submit" name="Reg" value="Регистрация">
                 </form>
              </div>
        </div>
    </body>
</html>
