
This is a java Stock Analyzer that runs on Pivotal Cloud Foundry.


Check out the version running on PCF at http://stockanalyzer.west.fe.pivotal.io/index

Instructions:
1. Enter a ticker : EMC 
and click submit

2. Results page should show you a buy/sell recommendation

This is the initial Commit.  I will be building out additional functionality over time.

A version of this in python runs on the Google App Engine at http://analyze-stock.appspot.com/

From Eclipse:
mvn clean
mvn package


To Push to Pivotal Cloud Foundry:
From a terminal:


cd /Users/ssahadevan/Documents/workspace/StockAnalyzer-java/target

cf push stockAnalyzer -p ./stockAnalyzer-0.1.0.jar
