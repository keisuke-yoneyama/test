<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <title>4eachblog 掲示板</title>
        <link rel="stylesheet" type ="text/css" href="style.css">
    </head>
    <body>
        <?php
        
        mb_internal_encoding("utf8");
        $pdo = new PDO("mysql:dbname=lesson01;host=localhost;","root","mysql");
        
        $stmt = $pdo->query("select * from 4each_keiziban");
        ?>
        <header>  
    <img class="logo" src="4eachblog_logo.jpg"> 
         <ul class="topmenu">
            <li>トップ</li>
            <li>プロフィール</li>
            <li>4eachについて</li>
            <li>登録フォーム</li>
            <li>問い合わせ</li>
            <li>その他</li>
        </ul>
     </header>
     <main>
         <div class="leftcontainer">
            <h1 class="keijiban">プログラミングに役立つ掲示板</h1>
         <div class="contactbox">
            <h3 class="nyuuryoku">入力フォーム</h3>
    
         <form method="post" action="insert.php">
            
            <div class="form">
                ハンドルネーム<br>
            <input type="text" name="handlename" size=40><br>
            </div> 
            <br>
            <div class="form">タイトル<br>
            <input type="text" name="title" size=40>
            <br>
            </div> 
            
            <div class="form">
            コメント
            <br>
            <textarea cols=35 rows=7 name="comments"></textarea>
            <br>
            </div>
            
            <div class="form">
             <input class="submit" type="submit" value="送信する">
             </div> 
           
            
         </form>
        </div>
             
      
             <?php
             
             while($row=$stmt->fetch()){
                 echo "<div class='kiji'>";
                 echo "<h3>".$row['title']."</h3>";
                 echo "<div class='contents'>";
                 echo $row['comments'];
                 echo "<div class='handlename'>posted by".$row['handlename']."</div>";
                 echo "</div>";
                 echo "</div>";
             }
             ?>
             
             
             
         </div>
         
         <div class="rightcontainer">
                <div class="list">
                    <h1>人気の記事</h1>
                    <ul class="kizilist">
                        <li>PHPオススメ本</li>
                        <li>PHP MyAdminの使い方</li>
                        <li>いま人気のエディタTop5</li>
                        <li>HTMLの基礎</li>
                    </ul>
             </div>
             
                <div class="list">
                <h1>オススメリンク</h1>
                <ul class="kizilist">
                    <li>インターノウス株式会社</li>
                    <li>XAMPPのダウンロード</li>
                    <li>Eclipseのダウンロード</li>
                    <li>Braketsのダウンロード</li>
                    </ul>
             </div>
             
                <div class="list">
             <h1>カテゴリ</h1>
                    <ul class="kizilist">
                        <li>HTML</li>
                        <li>PHP</li>
                        <li>MySQL</li>
                        <li>JavaScript</li>
                    </ul>
             </div>
             
         </div>
    </main>
        <footer>
        copyright ©internous | 4each blog  is the one which provides A to Z about programming
    </footer>
    </body>
</html>