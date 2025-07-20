# PREVIOUS THROUGHPUT WITH STANDARD IMPLEMENTATION

## processing 3740 records | note the time taken: 866ms

<pre>
2025-07-20T16:32:17.669-04:00  INFO 21160 --- [spring-batch] [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [FlowJob: [name=importUserJob]] completed with the following parameters: [{'run.id':'{value=1, type=class java.lang.Long, identifying=true}'}] and the following status: [COMPLETED] in 866ms
</pre>

# CURRENT THROUGHPUT WITH VIRTUAL THREADS IMPLEMENTATION

## processing 3740 records | note the time taken: 588ms

### As input size increases, the performance gap between implementations becomes more pronounced.

<pre>
2025-07-20T16:33:17.225-04:00  INFO 21140 --- [spring-batch] [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [FlowJob: [name=importUserJob]] completed with the following parameters: [{'run.id':'{value=1, type=class java.lang.Long, identifying=true}'}] and the following status: [COMPLETED] in 588ms
</pre>
