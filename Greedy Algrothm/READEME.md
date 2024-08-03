

# GA Algorithm

## Background

Spin Transfer Torque Random Access Memory (STT-RAM ) is a non-volatile memory with advantages such as high density and lower power leakage, but it also has the issue of two-step state transitions（TTs）, which has a great impact on performance. The GA algorithm is a greedy algorithm. We use this algorithm to obtain the optimal mapping method in SST-RAM. The algorithm can reduce or even eliminate the problem of TTs.

## Software dependences

All versions from Java 8 and above

## Java Compiling

```shell
javac -encoding utf8 -d ./target ./src/com/java/ga/*.java
```

## Java Running

```shell
#args: <m> <n> <population size> <generations> <mutation rate>
java -classpath ./target com.java.ga.GeneticAlgorithm 3 4 200 1000 0.02
```

## Result

When finishing executing, you can find the result in the console.&#x20;

