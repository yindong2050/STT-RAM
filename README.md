Java Compiling
javac -encoding utf8 -d ./target ./src/com/java/ga/*.java

Java Running
#args: <m> <n> <population size> <generations> <mutation rate>
java -classpath ./target com.java.ga.GeneticAlgorithm 3 4 200 1000 0.02
