# Neko_channel
A casual message board for carefree chatting🐈

##　概要
WEBアプリケーションの開発練習として簡単な掲示板を作成。
今回はデータベースを使用せず、ログイン中のユーザの情報や投稿されたテキストは
アプリケーションスコープのインスタンスとしてArrayListに格納し、そこから取り出す。

##　機能
- ログイン機能
パスワードは全ユーザ共有で文字列「1234」を使用

- ログアウト機能

- つぶやき機能
投稿が空の場合には投稿を受けずにエラーメッセージの表示。つぶやきはアプリケーションが終了するまで保存される（アプリケーションスコープ）

- つぶやき閲覧機能
全ユーザのつぶやきを新しいものから順に表示。閲覧機能を使用するにはログイン状態である必要がある。

## 処理の流れ図
![Neko_channel_diagram](https://github.com/Mmmmjp/Neko_channel/blob/main/images/nekochannel_diagram.jpg)

## directory図
```
Neko_channel/
├── java/
│   ├── controller/
│   │   ├── Login.java
│   │   ├── Logout.java
│   │   └── Main.java
│   └── model/
│       ├── LoginLogic.java
│       ├── PostMutterLogic.java
│       ├── User.java (javaBeans)
│       └── Mutter.java (javaBeans)
└── webapp/
    ├── css/
    ├── images/
    ├── WEB-INF/
    │   └── views/
    │       ├── loginResult.jsp
    │       ├── logout.jsp
    │       └── main.jsp
    └── index.jsp
```

##その他
参考書籍：スッキリわかるサーブレット＆JSP入門
第10章【どこつぶ】
