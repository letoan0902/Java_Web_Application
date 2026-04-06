# Bài 2: Tại sao Singleton Bean gây tính nhầm tiền

## Hiện tượng

Máy số 01 nạp giờ và bắt đầu chơi, máy số 02 cũng bị trừ tiền theo. Mọi máy đang dùng chung 1 bộ đếm.

## Nguyên nhân

- Trong Spring, `@Component` mặc định là **Singleton**, nghĩa là chỉ tạo **1 instance duy nhất** trong toàn bộ ứng dụng.
- Tất cả máy trạm đều inject cùng 1 đối tượng `PlaySession` -> cùng 1 biến `playTime`.
- Máy 01 gọi `addTime(60)` -> playTime = 60. Máy 02 gọi `addTime(30)` -> playTime = 90. Cả 2 máy đều thấy playTime = 90.

## Cách sửa

Đổi scope thành `prototype` để mỗi lần inject sẽ tạo 1 instance mới:

```java
@Component
@Scope("prototype")
public class PlaySession {
    private double playTime = 0;

    public void addTime(double time) {
        this.playTime += time;
    }
}
```

Như vậy mỗi máy trạm sẽ có `PlaySession` riêng, `playTime` được tính độc lập.
