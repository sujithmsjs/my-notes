The selection criteria
An Update Operator


com.mysql.cj.jdbc.exceptions.CommunicationsException: Communications link failure


##Store DB details
spring.datasource.url=jdbc:mysql://obs-aurora-mysql-preprod-01-instance-1.ctexk6vnzkdo.ap-south-1.rds.amazonaws.com:3306/obs_odesk?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8
spring.datasource.username=obsodesk_usr
spring.datasource.password=0BS04ESKTVUSR
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver


ALTER TABLE odesk_jwt_token RENAME refreshtoken;
