Caused by: org.springframework.beans.factory.BeanCreationException: Could not autowire field: com.alibaba.b2b.qa.databank.execute.biz.ExecuteDataService com.ali
baba.b2b.qa.databank.common.SeawaterUtils.executeDataService; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean w
ith name 'executeDataService' defined in class path resource [spring/common.xml]: Initialization of bean failed; nested exception is org.springframework.beans.f
actory.BeanCreationException: Error creating bean with name 'belfryJobManager' defined in class path resource [spring/agentcenter.xml]: Cannot resolve reference
 to bean 'jobQueue' while setting bean property 'jobQueue'; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean wit
h name 'jobQueue' defined in class path resource [spring/agentcenter.xml]: Cannot resolve reference to bean 'doCache' while setting bean property 'doCache'; nes
ted exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'doCache' defined in class path resource [spring/agentce
nter.xml]: Invocation of init method failed; nested exception is org.springframework.jdbc.CannotGetJdbcConnectionException: Could not get JDBC Connection; neste
d exception is org.apache.commons.dbcp.SQLNestedException: Cannot create PoolableConnectionFactory (Could not create connection to database server. Attempted re
connect 3 times. Giving up.)
