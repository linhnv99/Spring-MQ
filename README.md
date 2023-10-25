Note: 

:::Queue:::
- durable: true -> khi restart thì msg chưa xử lý sẽ k bị mất
- persistance: true -> lưu vào disk

:::Message:::
- ttl: thời gian xử lý message, nếu quá thì sẽ xóa bỏ msg
- exclusive(Queue): Xóa bỏ queue khi ko có consumer subscribe



## Tutorial

- Run producer
`java -jar build/libs/springboot-mq-0.0.1-SNAPSHOT.jar --spring.profiles.active=producer --server.port=8888`
- Run consumer
`java -jar build/libs/springboot-mq-0.0.1-SNAPSHOT.jar --spring.profiles.active=consumer --server.port=9999`



