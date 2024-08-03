<h1>STT-RAM</h1>
<h2>Background</h2>
Spin Transfer Torque Random Access Memory (STT-RAM) is a non-volatile memory with advantages such as high density and lower power leakage. However, it has the issue of two-step state transitions（TTs）, which greatly impact performance. We use some methods to avoid TTs.
<h2>methods</h2>
<h3>Basic algorithm</h3>
The Basic algorithm uses a full permutation search of all possible sequences to find the solution. This algorithm can find the optimal solution. The disadvantage is that it is very slow. If the amount of data is large, it will take a long time.
<h3>GA algorithm</h3>
The GA algorithm is a greedy algorithm. We use this algorithm to obtain the optimal mapping method in SST-RAM. In this algorithm, we randomly obtain one result each time, which saves time in finding the best mapping. However, it cannot be used to obtain all possible results at the same time.
<h3>Advanced algorithm</h3>
The Advanced algorithm removes the repeated sequences in the basic algorithm and can also get the optimal solution. The time complexity of the algorithm is much faster than that of the basic algorithm. If the amount of data is large, it still takes a long time. When testing the (3, 4) method, the result can be obtained within 1 minute. If the data of (5, 6), (7, 8) and so on is tested, it will take longer.
<h2>Tools</h2>
Java Platform, JDK, JavaIDE(such as Eclipse, IDEA)
<h2>Java compile and run </h2>
In each method, there is a readme.md file, please read it first.
<h2>Result</h2>
Compile and run to get the result.
