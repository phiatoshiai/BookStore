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
-- Thêm 2 thư viện liquibase sau vào
        
        <dependency>
            <groupId>org.liquibase</groupId>
            <artifactId>liquibase-core</artifactId>
        </dependency>

        <dependency>
            <groupId>org.liquibase</groupId>
            <artifactId>liquibase-maven-plugin</artifactId>
            <version>3.4.1</version>
        </dependency>
-- Thêm trong thẻ build của maven

<build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>

            <plugin>
                <groupId>org.liquibase</groupId>
                <artifactId>liquibase-maven-plugin</artifactId>
                <version>3.4.1</version>

                <configuration>
                    <propertyFile>src/main/resources/database.properties</propertyFile> (nơi đặt file database để xem thay đổi của database)
                    <changeLogFile>src/main/resources/liquidbase/db.changelog-dbmaster.xml (file master bao gồm các thay đổi của developer cho từng column, table và field)
                    
                    </changeLogFile>
                    <promptOnNonLocalDatabase>false</promptOnNonLocalDatabase>
                </configuration>
                <executions>

                    <execution>
                        <id>liquibase-dbmaster-update</id>
                        <phase>process-resources</phase>
                        <goals>
                            <goal>update</goal>
                        </goals>
                    </execution>

                </executions>
            </plugin>

        </plugins>
    </build>
    
    
