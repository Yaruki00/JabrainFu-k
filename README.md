# JabrainFu-k

*ふぁっきんジャバ(違う)*  
史上20億番目くらいのBrainfuckインタプリタ(in Java)

駄目なとこ  
1. BFコードをプログラム中に書いてる  
2. buff_ptrの範囲チェックしてない  
3. byte型は符号付き 127 + 1 = -128  
4. '['と']'のcode_ptrの計算どうにかならないの  