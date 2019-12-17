Counting on-line users by session id.

Understand how session works :
there are three cases that a session can work normally;
1. the URL Path Parameter
2. based on Cookie
3. based on SSL(only works when you set "connector.setAttribute("SSLEnable")")
if 2 is not working, parameters will be rewriten into URL path;
About the session name, if you set element "<session-config>" in Web.xml, 
it will be the name fo you set, if not, its default name is "JSESSIONID". 
If 2 is working, Tomcat will keep parasing cookie and rewrite the sessionID.
If there is no such sessionID, it will create a new one and add it into Manager's 
collection. The manager will take care of how long will this session survive. 