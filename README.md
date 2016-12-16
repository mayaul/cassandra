# Cassandra key space 추가
Strategy
* SimpleStrategy : Row키에 대한 Hash결과에 의해 Data저장 노드가 결정되면, 무조건 Ring에서 시계방향으로 바로 다음(Next) 노드들에게 Replica를 배치 시키는 방식.<br/>
* NetworkTopologyStrategy : SimpleSnitch 모드가 아닌 Snitch-Strategy에 의해 정의된 Replication-Group(or Each DataCenter)정보를 기준으로 Replica를 적절히 배치.
# KEY SPACE
```
CREATE KEYSPACE dev WITH REPLICATION = {'class':'SimpleStrategy', 'replication_factor':3};
```
# Table
```
CREATE TABLE dev.test_table_ex1 (
    code text,
    location text,
    sequence text,
    description text,
    PRIMARY KEY (code, location)
);

CREATE TABLE dev.test_table_ex2 (
    key1 text,
    key2 text,
    localDate date,
    localDateTime varchar,
    PRIMARY KEY ((key1,key2))
);

CREATE table dev.test_table_ex3 (
	category varchar,
	PRIMARY KEY (category)
)
```