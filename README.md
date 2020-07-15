# crew-analytics-csv
CSV upload module for CrewAnalytics

### DB setup:
Mysql with crew_analytics DB
- Run csv-db.sql script.
> mysql> source /Users/a-9288/Downloads/csv-db.sql

### To run:
- mvn spring-boot:run

### REST endpoints:
1. For CSV upload
- POST: http://localhost:8080/api/csv/upload

2. To see all table values
- GET: http://localhost:8080/api/csv/crews
