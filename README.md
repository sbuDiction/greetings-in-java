# Greetings-in-java
# Terminal commands.
* for starting the h2 tcp sever
    - java -cp h2*.jar org.h2.tools.Server
    
    #
    * For connecting to the h2 tool.
* java -cp h2-*.jar org.h2.tools.Shell.

| mvn   |      descriptions      |  Type |
|----------|:-------------:|------:|
| mvn flyway:migrate |  create db tables | mvn |
| mvn flyway:info |    shows info db   |   mvn |
| mvn flyway:clean | drops all db objects |    mvn |

* mvn clean dependency:copy-dependencies package
    