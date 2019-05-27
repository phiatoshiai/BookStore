# Lý Thuyết
### Tại sao phải sử dụng Liquibase
1. Theo dõi sự thay dổi của database ai làm gì ? ai thêm gì
2. Đồng nhất version của database với version của code khi release lên môi trường Production
3. Cung cấp những công cụ cần thiết để tương tác với database như so sánh các database với nhau
4. Chi tiết về liquibase tại đây https://www.liquibase.org/

### Thực Hành
#### Chuẩn bị
1. Tạo database library (xem ví dụ mẫu tại file database)
2. Download source code về với các chú ý sau
- File pom
-- Thêm 2 thư viện sau vào
        
        <dependency>
            <groupId>org.liquibase</groupId>
            <artifactId>liquibase-core</artifactId>
        </dependency>

        <dependency>
            <groupId>org.liquibase</groupId>
            <artifactId>liquibase-maven-plugin</artifactId>
            <version>3.4.1</version>
        </dependency>
