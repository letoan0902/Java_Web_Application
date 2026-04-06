# Bài 1: Phân tích lỗi Hard-code Dependency

## Đoạn code sai

```java
public RechargeService() {
    this.gateway = new InternalPaymentGateway(); // <-- Lỗi ở đây
}
```

## Tại sao sai

- `RechargeService` tự tạo dependency bằng `new InternalPaymentGateway()`, nghĩa là nó bị gắn chặt với 1 cổng thanh toán duy nhất.
- Muốn thêm Momo, ZaloPay thì phải vào sửa trực tiếp code bên trong class này.
- Không thể thay thế bằng Mock để viết Unit Test.
- Vi phạm nguyên lý IoC: class không nên tự tạo dependency mà nên nhận từ bên ngoài.

## Cách sửa

```java
@Service
public class RechargeService {
    private final PaymentGateway gateway;

    @Autowired
    public RechargeService(PaymentGateway gateway) {
        this.gateway = gateway; // Nhận từ bên ngoài, không tự new
    }

    public void processRecharge(String username, double amount) {
        gateway.pay(amount);
        System.out.println("Nạp " + amount + " cho " + username);
    }
}
```

Với cách này, muốn thêm cổng thanh toán mới chỉ cần tạo class implement `PaymentGateway`, không cần sửa `RechargeService`.
