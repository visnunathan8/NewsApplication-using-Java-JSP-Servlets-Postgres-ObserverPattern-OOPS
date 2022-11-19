# NewsApplication
To design a system that can read API/JSON data from The New York Times and produce results to application:
- Data collection from The New York Times.
- Displaying it in the User Interface.
- Designing Observer Designer Pattern in the existing system.

# TECHNOLOGIES USED
• JAVA
• JSP
• SERVLET
• MYSQL
• HTML
• CSS
• JAVASCRIPT
• SELENIUM

# USE CASE DIAGRAM
![use case diagram](https://user-images.githubusercontent.com/30067377/201803820-e0fbe0dc-34b1-4f5c-b478-1c23b5a135ed.jpg)

# IMPLEMENTATION
  OBSERVER DESIGN PATTERN
  ![SEQUENCEDIAGRAM](https://user-images.githubusercontent.com/30067377/201804286-66e1578a-de0b-4191-83df-0f104f659128.PNG)

  This describes the ongoing picture inside the application from programmer’s perspective. In the below given diagram, two reviewers has been defined along with two subscribers. The subscribers are allowed to subscribe to the reviewers they wish to add. The NewsFeedListener are used to communicate with the corresponding reviewer. Once the Subscriber has subscribed to them, whenever the Corresponding reviewer has posted any content, the subscriber will receive a notification regarding it and can view the data.
  
  THE PROJECT IS BASICALLY DESIGNED USING JSP AND SERVLETS. INTIALLY THE DATA IS PULLED FROM THE API (https://developer.nytimes.com/) AND IS STORED IN A LOCAL MYSQL DATABASE. THE OBSERVER DESIGN PATTERN IS IMPLEMENTED WITH THE HELP OF REVIEWERS AND USER VIEW.
  THE REVIEWER CAN POST THE REVIEW FROM THEIR ACCOUNT AND THE CORRESPONGING USER WHO HAVE SUBSCRIBED WILL BE ABLE TO SEE THEM.

# MYSQL DUMP
Will contain the basic data's form the api along with some custom review data. the reviewer can login through username and password as :  reviewer1. Similarly user1 as username and password for user login.

# Testing
 UNIT TESTING 
 ![image](https://user-images.githubusercontent.com/30067377/201804739-c86cd075-cb6e-49e6-9c99-6b9a02f85956.png)

 SELENIUM TESTING
 ![image](https://user-images.githubusercontent.com/30067377/201804721-c71ef553-3dcb-423b-9e8b-7b1b5d4dd6af.png)

Will contain the basic data's form the api along with some custom review data. the reviewer can login through username and password as :  reviewer1. Similarly user1 as username and password for user login.

# LOGIN PAGE
![image](https://user-images.githubusercontent.com/30067377/201804907-84a75ded-f0b0-49da-857b-64a89949b7d0.png)

# REGISTRATION PAGE
![image](https://user-images.githubusercontent.com/30067377/201804936-11987e4f-742c-416e-b940-b93dbd6b1e48.png)

# REVIEWER VIEW
![image](https://user-images.githubusercontent.com/30067377/201804968-f0e60aac-0651-4930-b60b-af63e09e5121.png)

# USER VIEW 
![image](https://user-images.githubusercontent.com/30067377/201805007-124531bb-da5a-41d2-83b2-751dc6405568.png)

# REVIEW DATA LIST
![image](https://user-images.githubusercontent.com/30067377/201805054-6bb4f60e-2b24-48e2-85a1-9443dd81b088.png)

# SUBSCRIBING REVIEWER AND SUBSCRIBED DATA LIST
![image](https://user-images.githubusercontent.com/30067377/201805081-6aba6992-e10b-4e33-bc9a-bffd871cd457.png)

 
# VIDEO EXPLANATION
https://drive.google.com/file/d/1EhZCfjIxwD5eYHFlfHr_6XS7_29jjQBy/view?usp=sharing
