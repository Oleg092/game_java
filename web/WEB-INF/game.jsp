<html>
    <head>
       <title>Игра бык-корова</title>
       <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <script type="text/javascript" src="./public/js/client.js"></script>
        <link rel="stylesheet" type="text/css" href="./public/style/style.css">
        <script src="./public/js/jquery-2.2.1.js"></script>
    </head>
    <body>
        <h1 id="title" class="lab">${startPage}</h1>
        <div class="gameContent" id="data_user">
            <H2 class="lab">Пользователь:</H1>
            <H2 class="lab">${name}</H1>
            <hr id="lineUserPrev">
            <div id="previousAttempts">
                <h2 class="lab">Предыдущие попытки:</h2>
                <h2 class="lab">Дата/Кол-во попыток</h2>
                <h2 class="lab">${date1}</h2>
                <h2 class="lab">${NA1}</h2>
                <h2 class="lab">${date2}</h2>
                <h2 class="lab">${NA2}</h2>
                <h2 class="lab">${date3}</h2>
                <h2 class="lab">${NA3}</h2>
                <h2 class="lab">${date4}</h2>
                <h2 class="lab">${NA4}</h2>
                <h2 class="lab">${date5}</h2>
                <h2 class="lab">${NA5}</h2>
            </div>
        </div>
        <div id="game" class="gameContent">
            <form action="/Process" method="POST">
                <input type="submit" name="startButton" id="startButton" value="Проверить">
                <input type="text" pattern="\d*" name="num" id="num" maxlength="4" required placeholder="Введите предполагаемое четырехзначное число">
                <input type="text" class="post" name="nump" value=${N}>
                <input type="text" class="post" name="email" value=${email}>
                <input type="text" class="post" name="password" value=${password}>
                <input type="text" class="post" name="id" value=${id}>
                <input type="text" class="post" name="login" value=${login}>
                <input type="text" class="post" name="p" value=${p}>

            </form>    
            <div id="inButton">
                <button id="0" onclick="inputText(id)">0</button>
                <button id="1" onclick="inputText(id)">1</button>
                <button id="2" onclick="inputText(id)">2</button>
                <button id="3" onclick="inputText(id)">3</button>
                <button id="4" onclick="inputText(id)">4</button>
                <button id="5" onclick="inputText(id)">5</button>
                <button id="6" onclick="inputText(id)">6</button>
                <button id="7" onclick="inputText(id)">7</button>
                <button id="8" onclick="inputText(id)">8</button>
                <button id="9" onclick="inputText(id)">9</button>
                <button id="clean" onclick="clean()" >Clean</button>
            </div>
            <div id="result">
                <form action="/Game" method="GET">
                    <input type="submit" value="Рестарт">
                    <input type="text" class="post" name="email1" value=${email1}>
                    <input type="text" class="post" name="password1" value=${password1}>     
                </form>
                <form action="/" method="GET">
                    <input type="submit" value="На главную">
                </form>
                <h1>${result}</h1>
                <h1>Число: ${nc1} K:${k1} B:${b1}</h1>
                <h1>Число: ${nc2} K:${k2} B:${b2}</h1>
                <h1>Число: ${nc3} K:${k3} B:${b3}</h1>
                <h1>Число: ${nc4} K:${k4} B:${b4}</h1>
                <h1>Число: ${nc5} K:${k5} B:${b5}</h1>
                <h1>Число: ${nc6} K:${k6} B:${b6}</h1>
                <h1>Число: ${nc7} K:${k7} B:${b7}</h1>
                <h1>Число: ${nc8} K:${k8} B:${b8}</h1>
                <h1>Число: ${nc9} K:${k9} B:${b9}</h1>
                <h1>Число: ${nc10} K:${k10} B:${b10}</h1>
                
            </div>
        </div>
        
        <div id="ratingPlayers" class="gameContent">
            <h2 class="lab">Среднее число попыток:</h2>
            <h2 class="lab">${S}</h2>
            <hr>
        </div>
    </body>
    