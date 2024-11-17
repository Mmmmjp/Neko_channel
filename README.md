# Neko_channel
A casual message board for carefree chatting.

## 処理の流れ図
![Neko_channel_diagram](https://github.com/Mmmmjp/Neko_channel/blob/main/images/nekochannel_diagram.jpg)

## directory図
'''
└── Neko_channel/
    ├── java/
    │   ├── controller /
    │   │   ├── Login.java
    │   │   ├── Logout.java
    │   │   └── Main.java
    │   └── model /
    │       ├── LoginLogic.java
    │       ├── PostMutterLogic.java
    │       ├── User.java (javaBeans)
    │       └── Mutter.java (jaaBeans)
    └── webapp/
        ├── css
        ├── images
        ├── WEB-INF/
        │   └── views /
        │       ├── loginResult.jsp
        │       ├── logout.jsp
        │       └── main.jsp
        └── index.jsp
''' 