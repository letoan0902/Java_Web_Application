# Bài 3: Thiết kế module gọi đồ ăn tại chỗ (OrderFoodService)

## Input / Output

**Input:** username, foodName, quantity

**Output:**
- Thành công: "Đặt [quantity] phần [foodName] thành công. Số dư còn lại: ...đ"
- Hết hàng: "Món [foodName] đã hết hàng."
- Không đủ số lượng: "Món [foodName] chỉ còn [stock], không đủ [quantity]."
- Số dư không đủ: "Số dư không đủ. Cần [totalCost]đ, hiện có [balance]đ."
- Số dư âm: "Tài khoản đang bị âm. Vui lòng nạp thêm tiền."

## Thiết kế

`OrderFoodService` phụ thuộc vào 2 interface:
- `InventoryRepository`: kiểm tra tồn kho
- `UserAccountRepository`: kiểm tra số dư và trừ tiền

Tiêm phụ thuộc qua Constructor Injection để đảm bảo Loose Coupling.

```java
@Service
public class OrderFoodService {
    private final InventoryRepository inventoryRepo;
    private final UserAccountRepository userAccountRepo;

    @Autowired
    public OrderFoodService(InventoryRepository inventoryRepo,
                            UserAccountRepository userAccountRepo) {
        this.inventoryRepo = inventoryRepo;
        this.userAccountRepo = userAccountRepo;
    }

    public OrderResult orderFood(String username, String foodName, int quantity) {
        // xử lý logic
    }
}
```

## Các bước xử lý logic

1. Kiểm tra món ăn có tồn tại không -> Không thì báo lỗi
2. Kiểm tra tồn kho: stock == 0 -> hết hàng, stock < quantity -> không đủ
3. Tính tổng tiền = đơn giá * số lượng
4. Kiểm tra số dư: âm -> báo lỗi, không đủ -> báo lỗi
5. Trừ tiền và giảm tồn kho
6. Trả về kết quả thành công

## Xử lý bẫy dữ liệu

- Gọi "Mì xào bò" mà kho trả về 0 -> bước 2 bắt lỗi, trả về thông báo hết hàng.
- Số dư tài khoản âm -> bước 4 bắt lỗi, trả về thông báo tài khoản bị âm.
