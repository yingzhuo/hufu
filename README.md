[![JDK](http://img.shields.io/badge/JDK-v8.0-yellow.svg)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
[![Build](http://img.shields.io/badge/Build-Maven_2-green.svg)](https://maven.apache.org/)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.yingzhuo/hufu.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.yingzhuo%22%20AND%20a:%22hufu%22)

# hufu

Hufu is "虎符".

### Download

* [maven / gradle](https://search.maven.org/search?q=hufu) is highly recommended.

```xml
<dependency>
    <groupId>com.github.yingzhuo</groupId>
    <artifactId>hufu-api</artifactId>
    <version>1.0.4</version>
</dependency>
<dependency>
    <groupId>com.github.yingzhuo</groupId>
    <artifactId>hufu-core</artifactId>
    <version>1.0.4</version>
</dependency>
<!-- ECDSA -->
<dependency>
    <groupId>com.github.yingzhuo</groupId>
    <artifactId>hufu-impl-ecdsa</artifactId>
    <version>1.0.4</version>
</dependency>
<!-- DSA -->
<dependency>
    <groupId>com.github.yingzhuo</groupId>
    <artifactId>hufu-impl-dsa</artifactId>
    <version>1.0.4</version>
</dependency>
<!-- RSA -->
<dependency>
    <groupId>com.github.yingzhuo</groupId>
    <artifactId>hufu-impl-rsa</artifactId>
    <version>1.0.4</version>
</dependency>
```

### Usage

```java
package hufu;

import com.github.yingzhuo.hufu.api.*;
import com.github.yingzhuo.hufu.core.Hufu;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class HufuTestCases {

    @Test
    public void testHufu() {

        // 生成公钥私钥对
        SecretFactory secretFactory = Hufu.createSecretFactory();
        Secret secret = secretFactory.createRandom();
        System.out.println(secret.toString());

        // 签名
        Signature signature = Hufu.createSignature();
        byte[] data = "hello, world.".getBytes(StandardCharsets.UTF_8); // 待签名的数据
        String sign = signature.sign(data, (PrivateKey) secret);

        // 验证签名
        boolean ok = signature.verify(data, sign, (PublicKey) secret);
        if (ok) {
            System.out.println("签名正确");
        } else {
            System.out.println("签名不正确");
        }
    }

}
```

### Contributing

* Fork it
* Create your feature branch (git checkout -b my-new-feature)
* Commit your changes (git commit -am 'add some feature')
* Push to the branch (git push origin my-new-feature)
* Create new Pull Request

### Authors

* 应卓 - [github](https://github.com/yingzhuo)

### License

Apache 2.0 license. See [LICENSE](./LICENSE)
