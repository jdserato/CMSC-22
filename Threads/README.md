a. Compare the performance of doing a sequential processing vs. multithreading in printing out the generations of Rule 30. Support your answer using execution time data for both scenarios.
When I make use of threads in Rule 30, it seems that it would take much time (where 10 threads would take about 1100 milliseconds) to complete 200 generations than a single thread only (which takes only about 650 milliseconds).


b. What are some common problems where we could apply concurrency to improve program throughput?
I guess Rule 30 is not a really perfect application for multithreading since every row is dependent on the previous row thus may not significantly fasten the sequence.
Moreover, when a data or set of data is independent of other data, concurrency will likely be useful to decrement the time being used to run the program.
