<?php
echo header("refresh: 2");
echo '<html>';
echo '<head>';
echo '<meta http-equiv="Content-Type" content="text/html; charset=utf-8">';
echo '<title>NODEMCU CONTROL BY QIN</title>';
echo '<style type="text/css">';
echo '';
echo 'body {';
echo 'margin:0;';
echo 'padding:0;';
echo 'font-family: Sans-Serif;';
echo 'line-height: 1.5em;';
echo '}';
echo '';
echo 'header {';
echo 'background: #ccc;';
echo 'height: 100px;';
echo '}';
echo '';
echo 'header h1 {';
echo 'margin: 0;';
echo 'padding-top: 15px;';
echo '}';
echo '';
echo 'main {';
echo 'padding-bottom: 10010px;';
echo 'margin-bottom: -10000px;';
echo 'float: left;';
echo 'width: 100%;';
echo '}';
echo '';
echo 'nav {';
echo 'padding-bottom: 10010px;';
echo 'margin-bottom: -10000px;';
echo 'float: left;';
echo 'width: 230px;';
echo 'margin-left: -230px;';
echo 'background: #eee;';
echo '}';
echo '';
echo 'footer {';
echo 'clear: left;';
echo 'width: 100%;';
echo 'background: #ccc;';
echo 'text-align: center;';
echo 'padding: 4px 0;';
echo '}';
echo '';
echo '#wrapper {';
echo 'overflow: hidden;';
echo '}';
echo '';
echo '#content {';
echo 'margin-right: 230px; ';
echo '}';
echo '';
echo '.innertube {';
echo 'margin: 15px; /* Padding for content */';
echo 'margin-top: 0;';
echo '}';
echo '';
echo 'p {';
echo 'color: #555;';
echo '}';
echo '';
echo 'nav ul {';
echo 'list-style-type: none;';
echo 'margin: 0;';
echo 'padding: 0;';
echo '}';
echo '';
echo 'nav ul a {';
echo 'color: darkgreen;';
echo 'text-decoration: none;';
echo '}';
echo '.button {';
echo 'background-color: #4CAF50; /* Green */';
echo 'border: none;';
echo 'color: white;';
echo 'padding: 15px 32px;';
echo 'text-align: center;';
echo 'text-decoration: none;';
echo 'display: inline-block;';
echo 'font-size: 16px;';
echo 'margin: 4px 2px;';
echo 'cursor: pointer;';
echo '}';
echo '';
echo '</style>';
echo '';
echo '</head>';
echo '';
echo '<body>';
echo '';
echo '<header>';
echo '<div class="innertube">';
echo '<h1>IOT ESP8266</h1>';
echo '</div>';
echo '</header>';
echo '';
echo '<div id="wrapper">';
echo '';
echo '<main>';
echo '<div id="content">';
echo '<div class="innertube">';
echo '<h1>LAMP CONTROL</h1>';
echo 'Push the button';
echo '<br>';
echo '<button class="button"><a href=\writefile.php?data=on>ON</a></button>';
echo '<button class="button"><a href=\writefile.php?data=off>OFF</a></button>';
echo '<button class="button"><a href=\writefile.php?data=blink>BLINK</a></button>';
echo '</br>';
echo '<h1>';
echo 'STATUS:  ';
echo file_get_contents("datastorage1.txt");
echo '</h1>';
echo '</div>';
echo '</div>';
echo '</main>';
echo '';
echo '<nav>';
echo '<div class="innertube">';
echo '<h3>Contact</h3>';
echo '<ul>';
echo '<li><a href=https://www.facebook.com/khuong.nguyen.w14>Facebook</a></li>';
echo '</ul>';
echo '';
echo '</div>';
echo '</nav>';
echo '';
echo '</div>';
echo '';
echo '<footer>';
echo '<div class="innertube">';
echo '<p>DA NANG, VIET NAM</p>';
echo '</div>';
echo '</footer>';
echo '</body>';
echo '</html>';
?>