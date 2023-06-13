Note: 

:::Queue:::
- durable: true -> khi restart thì msg chưa xử lý sẽ k bị mất
- persistance: true -> lưu vào disk

:::Message:::
- ttl: thời gian xử lý message, nếu quá thì sẽ xóa bỏ msg
- exclusive(Queue): Xóa bỏ queue khi ko có consumer subscribe

