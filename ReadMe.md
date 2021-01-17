This is java practice project using maven build tool.
Steps to run on local-
1. Git clone
2. To convert to eclipse: mvn eclipse:eclipse
3. Or To convert to Intellij: mvn idea:idea
4. Run mvn clean install -Dmaven.test.skip=true (Junits may not run all time hence skipping it)