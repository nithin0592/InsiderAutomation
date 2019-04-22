# 33Across Automation Tests

## Quick Start Guide

### Setup:
To run tests locally, do the following:

1. Download & install Java into your local machine (http://www.oracle.com/technetwork/java/javase/downloads/index.html)
1. Download & install Maven into your local machine (https://maven.apache.org/download.cgi)
1. Install browsers (supports on Windows and Mac: [Firefox, Chrome, Safari, IE])

### Run:


##### MVN CMD
```
mvn clean test -Dmaven.surefire.debug -U -DforkCount=0 -Dtestng.thread.count=1 -Dbrowser=firefox -Dplatform=mac -Dgroups=Advertisement

``` 

`-Dmaven.surefire.debug -U -DforkCount=0` : execute test in run/debug mode
`-Dtestng.thread.count = 1` : run test in single/multiple threads 
`-Dbrowser = firefox` : run with different browser. eg: `firefox, chrome, IE`
`-Dplatform=mac` : run with different operating systems. eg: `mac, windows`
`-Dgroups=Advertisement` : test group name for single/ multiple tests. eg: `Advertisement, regression`


1. To kickoff a group of tests update thread count parameter eg: `testng.thread.count = 10` that is defined in testng.xml, use the following command: `mvn clean test -Dmaven.surefire.debug -U -DforkCount=0 -Dtestng.thread.count=10 -Dbrowser=firefox -Dplatform=mac -Dgroups=regression`
1. To kickoff a single test, add an unique name in groups field of a particular test that you want to run, for ex: @Test(groups = {"unique-test-name"}. Then use the following command: `mvn clean test -Dmaven.surefire.debug -U -DforkCount=0 -Dtestng.thread.count=1 -Dbrowser=firefox -Dplatform=mac -Dgroups=Advertisement`
1. Example tests to run: AdvertisementTest


### How To Debug:
There are few ways to run in debug mode. 

1. Passing forkCount:
    1. Pass `-Dmaven.surefire.debug` & `-DforkCount=0` as parameter in mvn cmd. For ex: `mvn clean test -Dmaven.surefire.debug -U -DforkCount=0 -Dtestng.thread.count=1 -Dbrowser=firefox -Dplatform=mac -Dgroups=Advertisement`
1. Changing port number: 
    1. Pass `-DforkCount=0` & `mvn -Dmaven.surefire.debug="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=$<port-number> -Xnoagent -Djava.compiler=NONE" test`. For ex: `mvn clean test -U "-Dmaven.surefire.debug=-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5091 -Xnoagent -Djava.compiler=NONE" -DforkCount=0 -Dtestng.thread.count=1 -Dbrowser=firefox -Dplatform=mac -Dgroups=Advertisement`


    
