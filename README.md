#language parser featuring custom grammar, done in java

build:
cd src
java MPParser .\primeri\primer2.ds

building  jcup:
java -cp java_cup.jar java_cup.Main -parser MPParser MPParser.cup
