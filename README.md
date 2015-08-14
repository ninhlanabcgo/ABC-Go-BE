README for abcgo
==========================

$ curl -u abcgoapp:mySecretOAuthSecret -H 'Content-Type: application/x-www-form-urlencoded' -X POST 'http://localhost:8080/oauth/token' -d 'username=admin&password=admin&grant_type=password&scope=read%20write&client_secret=mySecretOAuthSecret&client_id=abcgoapp'

$ curl http://localhost:8080/api/areas -H 'Authorization: Bearer 10aed2d9-554a-4da5-89e6-5f56adb5e20b'