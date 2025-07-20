# CURRENT LOGS WITH STANDARD IMPLEMENTATION
## note the time taken: 108ms
<pre>
2025-07-20T16:06:43.693-04:00  INFO 10064 --- [spring-batch] [           main] c.f.spring_batch.SpringBatchApplication  : Started SpringBatchApplication in 1.991 seconds (process running for 2.369)
2025-07-20T16:06:43.696-04:00  INFO 10064 --- [spring-batch] [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: []
2025-07-20T16:06:43.760-04:00  INFO 10064 --- [spring-batch] [           main] o.s.b.c.l.s.TaskExecutorJobLauncher      : Job: [FlowJob: [name=importUserJob]] launched with the following parameters: [{'run.id':'{value=1, type=class java.lang.Long, identifying=true}'}]
2025-07-20T16:06:43.785-04:00  INFO 10064 --- [spring-batch] [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step1]
2025-07-20T16:06:43.861-04:00  INFO 10064 --- [spring-batch] [           main] c.f.s.processors.CoffeeItemProcessor     : Converting ( Coffee{brand='Blue Mountain', origin='Jamaica', characteristics='Fruity'} ) into ( Coffee{brand='BLUE MOUNTAIN', origin='JAMAICA', characteristics='FRUITY'} )
2025-07-20T16:06:43.861-04:00  INFO 10064 --- [spring-batch] [           main] c.f.s.processors.CoffeeItemProcessor     : Converting ( Coffee{brand='Lavazza', origin='Colombia', characteristics='Strong'} ) into ( Coffee{brand='LAVAZZA', origin='COLOMBIA', characteristics='STRONG'} )
2025-07-20T16:06:43.862-04:00  INFO 10064 --- [spring-batch] [           main] c.f.s.processors.CoffeeItemProcessor     : Converting ( Coffee{brand='Folgers', origin='America', characteristics='Smokey'} ) into ( Coffee{brand='FOLGERS', origin='AMERICA', characteristics='SMOKEY'} )
2025-07-20T16:06:43.870-04:00  INFO 10064 --- [spring-batch] [           main] o.s.batch.core.step.AbstractStep         : Step: [step1] executed in 84ms
2025-07-20T16:06:43.876-04:00  INFO 10064 --- [spring-batch] [           main] .f.s.l.JobCompletionNotificationListener : --- JOB FINISHED, PLEASE VERIFY THE RESULTS
2025-07-20T16:06:43.877-04:00  INFO 10064 --- [spring-batch] [           main] .f.s.l.JobCompletionNotificationListener : Found < Coffee{brand='BLUE MOUNTAIN', origin='JAMAICA', characteristics='FRUITY'} > in the database.
2025-07-20T16:06:43.877-04:00  INFO 10064 --- [spring-batch] [           main] .f.s.l.JobCompletionNotificationListener : Found < Coffee{brand='LAVAZZA', origin='COLOMBIA', characteristics='STRONG'} > in the database.
2025-07-20T16:06:43.877-04:00  INFO 10064 --- [spring-batch] [           main] .f.s.l.JobCompletionNotificationListener : Found < Coffee{brand='FOLGERS', origin='AMERICA', characteristics='SMOKEY'} > in the database.
2025-07-20T16:06:43.881-04:00  INFO 10064 --- [spring-batch] [           main] o.s.b.c.l.s.TaskExecutorJobLauncher      : Job: [FlowJob: [name=importUserJob]] completed with the following parameters: [{'run.id':'{value=1, type=class java.lang.Long, identifying=true}'}] and the following status: [COMPLETED] in 108ms
2025-07-20T16:06:43.891-04:00  INFO 10064 --- [spring-batch] [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2025-07-20T16:06:43.894-04:00  INFO 10064 --- [spring-batch] [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
</pre>
