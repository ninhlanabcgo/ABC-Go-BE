README for abcgo
==========================

### Deploy to OpenShift

* Installing the OpenShift Client Tools https://developers.openshift.com/en/managing-client-tools.html

* Login to OpenShift rhc ssh < app name >
* Go to repo directory cd app-root/repo
* git clone < git url >
* Go to < git directory >
* git remote add upstream < git url > 
* git pull -s recursive -X theirs upstream master
* git update-index --chmod=+x .openshift/action_hooks/*
* git stash
* Package application sh .openshift/action_hooks/build
* Start application sh .openshift/action_hooks/start
* Stop application sh .openshift/action_hooks/stop

$ curl -u abcgoapp:mySecretOAuthSecret -H 'Content-Type: application/x-www-form-urlencoded' -X POST 'http://localhost:8080/oauth/token' -d 'username=admin&password=admin&grant_type=password&scope=read%20write&client_secret=mySecretOAuthSecret&client_id=abcgoapp'

$ curl http://localhost:8080/api/areas -H 'Authorization: Bearer 10aed2d9-554a-4da5-89e6-5f56adb5e20b'

Allow all user
$ curl http://localhost:8080/api/data/1-classes-area -H 'Authorization: Bearer 6156050d-7592-489e-963c-8133b008c051'

Allow admin user
$ curl http://localhost:8080/api/data/admin/1-classes-area -H 'Authorization: Bearer 6156050d-7592-489e-963c-8133b008c051'

Allow authentication user can insert, delete and update some class (...)
$ curl http://localhost:8080/api/data/user