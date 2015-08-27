README for abcgo
==========================

### Deploy to OpenShift

* Installing the OpenShift Client Tools https://developers.openshift.com/en/managing-client-tools.html

* Login to OpenShift rhc ssh < app name >
* Go to repo directory cd app-root/repo
* git clone < git url > .
* git remote add upstream < git url > 
* git pull -s recursive -X theirs upstream master
* git update-index --chmod=+x .openshift/action_hooks/*
* git stash
* Package application sh .openshift/action_hooks/build
* Start application sh .openshift/action_hooks/start
* Stop application sh .openshift/action_hooks/stop

### Test commandline

* Call parse
$ curl -v -H 'X-Parse-Application-Id: LOcvyGh9msyjVPK8o3EnfK7yrQesrlG657pbBk6u' -H 'X-Parse-REST-API-Key: zLOVjKK8Zo8kmFwpSBAUIqS4fuORSKx5i4Nn6RC0' -H 'Content-Type: application/json' -X GET 'https://api.parse.com/1/classes/area'

* Call gate way API
$ curl -u abcgoapp:mySecretOAuthSecret -H 'Content-Type: application/x-www-form-urlencoded' -X POST 'http://localhost:8080/oauth/token' -d 'username=admin&password=admin&grant_type=password&scope=read%20write&client_secret=mySecretOAuthSecret&client_id=abcgoapp'

* Allow all user
$ curl http://localhost:8080/api/data/1-classes-area -H 'Authorization: Bearer 6156050d-7592-489e-963c-8133b008c051'

* Allow admin user
$ curl http://localhost:8080/api/data/admin/1-classes-area -H 'Authorization: Bearer 6156050d-7592-489e-963c-8133b008c051'

* Allow authentication user can insert, delete and update some class (...)
$ curl http://localhost:8080/api/data/user