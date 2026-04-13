# Session04 - Bai tap Spring MVC

## Bai 3 - Bao cao (3-5 cau)

- Cach A: `/bai3/orders/5` thi so `5` nam **ngay trong duong dan (URI Path)**, duoc trich xuat bang `@PathVariable`.
- Cach B: `/bai3/orders?id=5` thi so `5` nam trong **chuoi truy van (Query String)**, duoc trich xuat bang `@RequestParam`.
- Theo bai hoc RESTful, khi can lay **ID cua 1 tai nguyen cu the** (1 don hang), Cach A phu hop hon vi URL gon gang va the hien ro 5 la dinh danh cua don hang.
- Vi vay em chon **Cach A** va code endpoint `GET /bai3/orders/{id}`.

## Bai 4 - Ban thiet ke luong I/O

URL: `/bai4/products?category=chay&limit=10`

- Input tu URL:
  - Query param `category`
  - Query param `limit`
- Controller: `org.example.session04.bai4.controller.ProductController#listProducts`
  - Day vao `ModelMap`:
    - key `category` -> gia tri tu query param
    - key `limit` -> gia tri tu query param (int)
    - key `message` -> "Tim kiem thanh cong"
- View JSP: `productList.jsp` (duong dan: `/WEB-INF/views/productList.jsp`)

## Bai 5 - Bao cao ngan

### Bay du lieu ep kieu
- Neu client go sai ID tren URL, vi du: `GET /bai5/orders/t`, Spring se nem loi binding do khong chuyen duoc chu `t` sang so `Long`.
- Du an da bat loi bang `@ControllerAdvice` + `@ExceptionHandler(MethodArgumentTypeMismatchException.class)` va tra ve thong bao than thien: `ID don hang phai la mot so`.

### Idempotent
- Route `DELETE /bai5/orders/{id}` la idempotent: xoa/huy cung 1 don hang nhieu lan lien tiep thi ket qua cuoi cung van la "don hang da bi huy" (khong tao them du lieu moi).
- Route `POST /bai5/orders` khong idempotent: moi lan goi POST co the tao ra 1 don hang moi, nen bam 3 lan co nguy co sinh ra 3 don hang rac.

